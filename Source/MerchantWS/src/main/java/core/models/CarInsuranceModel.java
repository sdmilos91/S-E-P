package core.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CarInsuranceModel {
	
	@JsonProperty("Risks")
	private List<TravelInsuranceRisk> risks;
	
	@JsonProperty("CarType")
	private String carType;
	
	@JsonProperty("Age")
	private int age;
	
	@JsonProperty("CarIdNumber")
	private String carIdNumber;
	
	@JsonProperty("Owner")
	private PersonModel owner;

	@JsonProperty("Risks")
	public List<TravelInsuranceRisk> getRisks() {
		return risks;
	}
	
	@JsonProperty("Risks")
	public void setRisks(List<TravelInsuranceRisk> risks) {
		this.risks = risks;
	}
	
	@JsonProperty("CarType")
	public String getCarType() {
		return carType;
	}
	
	@JsonProperty("CarType")
	public void setCarType(String carType) {
		this.carType = carType;
	}

	@JsonProperty("Age")
	public int getAge() {
		return age;
	}

	@JsonProperty("Age")
	public void setAge(int age) {
		this.age = age;
	}
	
	@JsonProperty("CarIdNumber")
	public String getCarIdNumber() {
		return carIdNumber;
	}

	@JsonProperty("CarIdNumber")
	public void setCarIdNumber(String carIdNumber) {
		this.carIdNumber = carIdNumber;
	}

	@JsonProperty("Owner")
	public PersonModel getOwner() {
		return owner;
	}

	@JsonProperty("Owner")
	public void setOwner(PersonModel owner) {
		this.owner = owner;
	}
	
	
	
}
