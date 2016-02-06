package core.models;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerModel {
	@JsonProperty("address")
	private String address;
	@JsonProperty("citizenID")
	@Size(min=13,max=13)
	private String citizenID;
	@JsonProperty("email")
	private String email;
	@JsonProperty("lastname")
	private String lastname;
	@JsonProperty("name")
	private String name;
	@JsonProperty("passportNumber")
	private String passportNumber;
	@JsonProperty("phoneNumber")
	private String phoneNumber;

	/**
	* 
	* @return
	* The address
	*/
	@JsonProperty("address")
	public String getAddress() {
	return address;
	}

	/**
	* 
	* @param address
	* The address
	*/
	@JsonProperty("address")
	public void setAddress(String address) {
	this.address = address;
	}

	/**
	* 
	* @return
	* The citizenID
	*/
	@JsonProperty("citizenID")
	public String getCitizenID() {
	return citizenID;
	}

	/**
	* 
	* @param citizenID
	* The citizenID
	*/
	@JsonProperty("citizenID")
	public void setCitizenID(String citizenID) {
	this.citizenID = citizenID;
	}

	/**
	* 
	* @return
	* The email
	*/
	@JsonProperty("email")
	public String getEmail() {
	return email;
	}

	/**
	* 
	* @param email
	* The email
	*/
	@JsonProperty("email")
	public void setEmail(String email) {
	this.email = email;
	}

	/**
	* 
	* @return
	* The lastname
	*/
	@JsonProperty("lastname")
	public String getLastname() {
	return lastname;
	}

	/**
	* 
	* @param lastname
	* The lastname
	*/
	@JsonProperty("lastname")
	public void setLastname(String lastname) {
	this.lastname = lastname;
	}

	/**
	* 
	* @return
	* The name
	*/
	@JsonProperty("name")
	public String getName() {
	return name;
	}

	/**
	* 
	* @param name
	* The name
	*/
	@JsonProperty("name")
	public void setName(String name) {
	this.name = name;
	}

	/**
	* 
	* @return
	* The passportNumber
	*/
	@JsonProperty("passportNumber")
	public String getPassportNumber() {
	return passportNumber;
	}

	/**
	* 
	* @param passportNumber
	* The passportNumber
	*/
	@JsonProperty("passportNumber")
	public void setPassportNumber(String passportNumber) {
	this.passportNumber = passportNumber;
	}

	/**
	* 
	* @return
	* The phoneNumber
	*/
	@JsonProperty("phoneNumber")
	public String getPhoneNumber() {
	return phoneNumber;
	}

	/**
	* 
	* @param phoneNumber
	* The phoneNumber
	*/
	@JsonProperty("phoneNumber")
	public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
	}

}
