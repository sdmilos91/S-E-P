package core.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FlatInsuranceModel {

	@JsonProperty("Risks")
	private List<TravelInsuranceRisk> risks;
	
	@JsonProperty("Area")
	private float area;
	
	@JsonProperty("Value")
	private float value;
	
	@JsonProperty("Age")
	private int age;	
	
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
	
	@JsonProperty("Age")
	public int getAge() {
		return age;
	}

	@JsonProperty("Age")
	public void setAge(int age) {
		this.age = age;
	}
	
	@JsonProperty("Area")
	public float getArea() {
		return area;
	}

	@JsonProperty("Area")
	public void setArea(float area) {
		this.area = area;
	}

	@JsonProperty("Value")
	public float getValue() {
		return value;
	}

	@JsonProperty("Value")
	public void setValue(float value) {
		this.value = value;
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
