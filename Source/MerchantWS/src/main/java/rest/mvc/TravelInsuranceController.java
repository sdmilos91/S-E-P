package rest.mvc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import core.models.AcqurierResponseMessageModel;
import core.models.CarInsuranceModel;
import core.models.CustomerModel;
import core.models.FlatInsuranceModel;
import core.models.MerchantOrderResponseModel;
import core.models.ResponseOrderModel;
import core.models.TransactionMessageModel;
import core.models.TravelInsuranceModel;
import core.models.UrlModel;
import core.models.entities.Customer;
import core.models.entities.Flat;
import core.models.entities.Order;
import core.models.entities.Person;
import core.models.entities.Risk;
import core.models.entities.Policy;
import core.models.entities.TravelInsuranceRisk;
import core.models.entities.Vehicle;
import core.services.CustomerService;
import core.services.MerchantService;
import core.services.OrderService;
import core.services.PersonService;
import core.services.PolicyService;
import core.services.RiskService;
import core.util.MailSender;

@Controller
public class TravelInsuranceController {

	
	private MerchantService merchantService;
	
	private OrderService orderService;
	
	private RiskService riskService;
	
	private PersonService personService;
	
	private PolicyService policyService;	
	
	private CustomerService customerService;
	
	@Autowired
	public TravelInsuranceController(MerchantService merchantService, PolicyService policyService, OrderService orderService,
			PersonService personService, RiskService riskService) {
		this.merchantService = merchantService;
		this.policyService = policyService;
		this.orderService = orderService;
		this.personService  = personService;
		this.riskService = riskService;
	}
	
	@CrossOrigin
	@RequestMapping(value="/rest/travel_insurances", method = RequestMethod.POST)
	public ResponseEntity<MerchantOrderResponseModel> createTravelInsurance(@RequestBody @Valid TravelInsuranceModel sentTravelInsurance, BindingResult result) {
		
		if(result.hasErrors()) {
			MerchantOrderResponseModel createOrderResponseModel = new MerchantOrderResponseModel();
			createOrderResponseModel.setError(true);
			createOrderResponseModel.setErrorMessage("Nevalidan model");
			HttpHeaders headers2 = new HttpHeaders();
	        return new ResponseEntity<MerchantOrderResponseModel>(createOrderResponseModel, headers2, HttpStatus.BAD_REQUEST);
		}
		Policy policy = new Policy();
		
		Order order = new Order();
		double totalAmount = 0;
		
		long order_id = (long) Math.floor(Math.random() * 9000000000L) + 1000000000L;
		double amountTravelInsurance = getAmount(sentTravelInsurance.getRisks());
		double amountFlatInsurance = 0; 
		double amountCarInsurance = 0; 
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
		List<TravelInsuranceRisk> risks = new ArrayList<TravelInsuranceRisk>();
		for(int i=0; i<sentTravelInsurance.getRisks().size(); i++) {
			TravelInsuranceRisk travelInsuranceRisk = new TravelInsuranceRisk();
			travelInsuranceRisk.setRiskId(sentTravelInsurance.getRisks().get(i).getRiskId());
			travelInsuranceRisk.setValue(sentTravelInsurance.getRisks().get(i).getValue());
			risks.add(travelInsuranceRisk);
		}
		
		List<Customer> customers = new ArrayList<Customer>();
		for(CustomerModel custModel : sentTravelInsurance.getCustomers()) {
			Customer cust = new Customer();
			cust.setAddress(custModel.getAddress());
			cust.setEmail(custModel.getEmail());
			cust.setFirstName(custModel.getName());
			cust.setSurName(custModel.getLastname());
			cust.setJmbg(custModel.getCitizenID());
			cust.setPassportNumber(custModel.getPassportNumber());
			cust.setTelephoneNumber(custModel.getPhoneNumber());
			customers.add(cust);
		}
			
			
		Person contractor = null;
		for(int i=0; i<customers.size(); i++) 
			if(customers.get(i).getEmail() != null)
				contractor = customers.get(i);
		
		order.setOrder_Id(order_id);
		order.setAmount(totalAmount);
		order.setTimestamp(dateFormat.format(date));
		order.setPerson(contractor);
		
		policy.setOrder(order);
		policy.setRisks(risks);
		policy.setCustomers(customers);
		
		
		CarInsuranceModel carModel = sentTravelInsurance.getCarInsuranceModel();
		
		Vehicle vehicle = new Vehicle();
		boolean vehicle_owner_exist = false;
		if(carModel != null) {
			amountCarInsurance = getAmount(sentTravelInsurance.getCarInsuranceModel().getRisks());
			vehicle.setAge(carModel.getAge());
			vehicle.setType(carModel.getCarType());
			vehicle.setLicencePlate(carModel.getCarIdNumber());
			Person owner = new Person();
			owner.setFirstName(carModel.getOwner().getName());
			owner.setSurName(carModel.getOwner().getLastname());
			owner.setJmbg(carModel.getOwner().getCitizenId());
			owner.setAddress(carModel.getOwner().getAddress());
			vehicle.setOwner(owner);
			for(Person person : personService.getAll()) {
				if(person.getJMBG().equals(vehicle.getOwner().getJMBG())) {
					vehicle_owner_exist = true;
					break;
				}
			}
			policy.setVehicle(vehicle);			
		}
		
		FlatInsuranceModel flatModel = sentTravelInsurance.getFlatInsuranceModel();
		
		Flat flat = new Flat();
		boolean flat_owner_exist = false;
		if(flatModel != null) {
			amountFlatInsurance = getAmount(sentTravelInsurance.getFlatInsuranceModel().getRisks());
			flat.setFlatAge(flatModel.getAge());
			flat.setFlatValue(flatModel.getValue());
			Person owner = new Person();
			owner.setFirstName(flatModel.getOwner().getName());
			owner.setSurName(flatModel.getOwner().getLastname()); 
			owner.setJmbg(flatModel.getOwner().getCitizenId());
			owner.setAddress(flatModel.getOwner().getAddress());
			flat.setOwner(owner);
			for(Person person : personService.getAll()) {
				if(person.getJMBG().equals(flat.getOwner().getJMBG())) {
					flat_owner_exist = true;
					break;
				}
			}
			policy.setFlat(flat);			
		}
		
		boolean order_owner_exist = false;
		for(Person person : personService.getAll()) {
			if(person.getJMBG().equals(order.getPerson().getJMBG())) {
				order_owner_exist = true;
				break;
			}
		}
		
		/*
		for(Customer customer : policy.getCustomers()) {
			if(customerService.findCustomer(customer.getJMBG()) == null) {
				customerService.createCustomer(customer);
			}
		}
			*/	
		int duration = sentTravelInsurance.getDuration();
		totalAmount = (amountTravelInsurance + amountFlatInsurance + amountCarInsurance) * (1+duration/10);
		try {
			/*
			if(!order_owner_exist)
				personService.createPerson(order.getPerson());
			if(!flat_owner_exist)
				personService.createPerson(flat.getOwner());
			if(!vehicle_owner_exist)
				personService.createPerson(vehicle.getOwner());
		*/
			orderService.createOrder(order);
			policyService.createPolicy(policy);
		}
		
		catch(Exception e) {
			MerchantOrderResponseModel createOrderResponseModel = new MerchantOrderResponseModel();
			createOrderResponseModel.setError(true);
			createOrderResponseModel.setErrorMessage("Greska prilikom snimanja podataka u bazu!");
			HttpHeaders headers2 = new HttpHeaders();
	        return new ResponseEntity<MerchantOrderResponseModel>(createOrderResponseModel, headers2, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseOrderModel responseOrder = new ResponseOrderModel();
		responseOrder.setMerchantId(merchantService.getMerchantData().getMerchantId());
		responseOrder.setMerhcantPassword(merchantService.getMerchantData().getMerchantPassword());
		responseOrder.setErrorUrl(merchantService.getMerchantData().getErrorURL());
		responseOrder.setAmount(totalAmount);
		responseOrder.setMerchantOrderId(order_id);
		responseOrder.setMerchantTimestamp(dateFormat.format(date));
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		@SuppressWarnings({ "unchecked", "rawtypes" })
		HttpEntity entity = new HttpEntity(responseOrder,headers);
		
		try {
			ResponseEntity<AcqurierResponseMessageModel> response = restTemplate.exchange("http://192.168.1.4:58643/api/Bank/CreateOrder",HttpMethod.POST, entity, AcqurierResponseMessageModel.class);
	
			MerchantOrderResponseModel createOrderResponseModel = new MerchantOrderResponseModel();
			if(!(response.getStatusCode() == HttpStatus.OK)) {
				createOrderResponseModel.setError(true);
				createOrderResponseModel.setErrorMessage("Greska prilikom poziva servisa banke!");
			}
		
			else {
				createOrderResponseModel.setPaymentURL(response.getBody().getPaymentURL());
				createOrderResponseModel.setPaymentID(response.getBody().getPaymentID());
				createOrderResponseModel.setError(false);

			}
		
        HttpHeaders headers2 = new HttpHeaders();
        return new ResponseEntity<MerchantOrderResponseModel>(createOrderResponseModel, headers2, HttpStatus.CREATED);
		}
		
		catch(Exception e) {
			MerchantOrderResponseModel createOrderResponseModel = new MerchantOrderResponseModel();
			createOrderResponseModel.setError(true);
			createOrderResponseModel.setErrorMessage("Greska u transakciji");
			HttpHeaders headers2 = new HttpHeaders();
	        return new ResponseEntity<MerchantOrderResponseModel>(createOrderResponseModel, headers2, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin
	@RequestMapping(value="/rest/travel_insurances/url", method = RequestMethod.POST)
	public ResponseEntity<UrlModel> sendRedirectionURL(@RequestBody TransactionMessageModel transactionModelMessage) {
	  UrlModel urlModel = new UrlModel();
	  try {
		if(transactionModelMessage.isError()) {
			urlModel.setUrl(merchantService.getMerchantData().getFailedURL());
			Order order = orderService.findOrder(transactionModelMessage.getBankOrderResponseModel().getMerchantOrderID());
			MailSender.sendMail("Travel Insurance Purchase", "Sorry there was a problem with purchasing travel insurance!"
				, order.getPerson().getEmail());
		}
		else {
			urlModel.setUrl(merchantService.getMerchantData().getSuccessURL());
			Order order = orderService.findOrder(transactionModelMessage.getBankOrderResponseModel().getMerchantOrderID());
			order.setAcquirerID(transactionModelMessage.getBankOrderResponseModel().getAcquirerID());
			order.setAcquirerTimestamp(transactionModelMessage.getBankOrderResponseModel().getAcquirerTimestamp());
			orderService.updateOrder(order);
			MailSender.sendMail("Travel Insurance Purchase","Travel purchase was successfull!", order.getPerson().getEmail());
		}
		
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<UrlModel>(urlModel, headers, HttpStatus.CREATED);
	  }
	  
	  catch (Exception e) {
		    urlModel.setUrl(merchantService.getMerchantData().getFailedURL());
		    Order order = null;
		    if(transactionModelMessage.getBankOrderResponseModel() != null)
		    	 order = orderService.findOrder(transactionModelMessage.getBankOrderResponseModel().getMerchantOrderID());
			MailSender.sendMail("Travel Insurance Purchase", "Sorry there was a problem with purchasing travel insurance!"
					, order.getPerson().getEmail());
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<UrlModel>(urlModel, headers, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	}
	
	public double getAmount(List<core.models.TravelInsuranceRisk> risks) {
		double amount = 0;
		boolean isFirstFlagFalse = true;
		
		for(int i = 0; i < risks.size(); i++){
			
			Risk risk = riskService.findRisk(risks.get(i).getRiskId()); 
			int value = risks.get(i).getValue();
			
			if(risk != null){
				if(risk.isFlag() == false){
					if(isFirstFlagFalse){ //ako je prvo racunanje mnozenje postavi amount = 1 da se ne bi mnozilo sa nulom
						amount = 1;
					}
					amount = amount * (risk.getCoef() * value);
					isFirstFlagFalse = false;
				}else{
					amount = amount + (risk.getCoef() * value);
					isFirstFlagFalse = false;
				}
			}
				
		}
		
		return amount;
	}

}
