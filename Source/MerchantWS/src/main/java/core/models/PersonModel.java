package core.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonModel {
	
	@JsonProperty("Name")
	private String name;
	
	@JsonProperty("Lastname")
	private String lastname;
	
	@JsonProperty("CitizenID")
	private String citizenId;
	
	@JsonProperty("Address")
	private String address;

	@JsonProperty("Name")
	public String getName() {
		return name;
	}

	@JsonProperty("Name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("Lastname")
	public String getLastname() {
		return lastname;
	}

	@JsonProperty("Lastname")
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@JsonProperty("CitizenID")
	public String getCitizenId() {
		return citizenId;
	}

	@JsonProperty("CitizenID")
	public void setCitizenId(String citizenId) {
		this.citizenId = citizenId;
	}

	@JsonProperty("Address")
	public String getAddress() {
		return address;
	}

	@JsonProperty("Address")
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
