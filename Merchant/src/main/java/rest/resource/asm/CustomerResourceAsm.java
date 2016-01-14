package rest.resource.asm;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import core.models.entities.Customer;
import rest.mvc.CustomerController;
import rest.resource.CustomerResource;

public class CustomerResourceAsm extends ResourceAssemblerSupport<Customer,CustomerResource>{

	public CustomerResourceAsm() {
		super(CustomerController.class, CustomerResource.class);
		
	}

	public CustomerResource toResource(Customer customer) {
		
		CustomerResource res = new CustomerResource();
		res.setJMBG(customer.getJMBG());
		res.setFirstName(customer.getFirstName());
		res.setSurName(customer.getSurName());
		res.setEmail(customer.getEmail());
		res.setPassportNumber(customer.getPassportNumber());
		res.setTelephoneNumber(customer.getTelephoneNumber());
		Link link = linkTo(methodOn(CustomerController.class).getCustomer(customer.getJMBG())).withSelfRel();
		res.add(link.withSelfRel());
		return res;
	}

}
