package rest.resource;

import org.springframework.hateoas.ResourceSupport;

import core.models.entities.Customer;

public class CustomerResource extends ResourceSupport{
	
	private String JMBG;
	
	private String firstName;

	private String surName;

	private String email;
	
	private String passportNumber;
	
	private String telephoneNumber;
	
	public String getJMBG() {
		return JMBG;
	}
	
	public void setJMBG(String jMBG) {
		JMBG = jMBG;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getSurName() {
		return surName;
	}
	
	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	
	 public Customer toCustomer() {
		 
		 	Customer customer = new Customer();
		 	customer.setJMBG(JMBG);
		 	customer.setFirstName(firstName);
		 	customer.setSurName(surName);
		 	customer.setEmail(email);
		 	customer.setPassportNumber(passportNumber);
	        return customer;
	 }
	
}
