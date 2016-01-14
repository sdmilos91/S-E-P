package rest.mvc;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import core.models.entities.Customer;
import core.services.CustomerService;
import rest.resource.CustomerResource;
import rest.resource.asm.CustomerResourceAsm;

@Controller
public class CustomerController {
	
private CustomerService service;
	
	@Autowired
	public CustomerController(CustomerService service) {
		this.service = service;
	}
	
	@CrossOrigin
	@RequestMapping(value="/rest/customers/{JMBG}", method = RequestMethod.GET)
	public ResponseEntity<CustomerResource> getCustomer(
			@PathVariable String JMBG) {
		
		Customer customer = service.findCustomer(JMBG);
		CustomerResource res = new CustomerResourceAsm().toResource(customer);
		return new ResponseEntity<CustomerResource>(res,HttpStatus.OK);
		
	}
	
	@CrossOrigin
	@RequestMapping(value="/rest/customers", method = RequestMethod.POST)
	public ResponseEntity<CustomerResource> createCustomer(@RequestBody CustomerResource sentCustomer) {
		
		Customer createdCustomer = service.createCustomer(sentCustomer.toCustomer());
		CustomerResource res = new CustomerResourceAsm().toResource(createdCustomer);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(res.getLink("self").getHref()));
        return new ResponseEntity<CustomerResource>(res, headers, HttpStatus.CREATED);
	}

}
