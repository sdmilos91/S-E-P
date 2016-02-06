package core.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TravelInsuranceModel {
	@JsonProperty("risks")
	private List<TravelInsuranceRisk> risks = new ArrayList<TravelInsuranceRisk>();
	@JsonProperty("duration")
	private Integer duration;
	@JsonProperty("amount")
	private double amount;
	@JsonProperty("customers")
	private List<CustomerModel> customers = new ArrayList<CustomerModel>();
	@JsonProperty("car")
	private CarInsuranceModel carInsuranceModel;
	@JsonProperty("flat")
	private FlatInsuranceModel flatInsuranceModel;

	/**
	* 
	* @return
	* The risks
	*/
	@JsonProperty("risks")
	public List<TravelInsuranceRisk> getRisks() {
	return risks;
	}

	/**
	* 
	* @param risks
	* The risks
	*/
	@JsonProperty("risks")
	public void setRisks(List<TravelInsuranceRisk> risks) {
	this.risks = risks;
	}

	/**
	* 
	* @return
	* The duration
	*/
	@JsonProperty("duration")
	public Integer getDuration() {
	return duration;
	}

	/**
	* 
	* @param duration
	* The duration
	*/
	@JsonProperty("duration")
	public void setDuration(Integer duration) {
	this.duration = duration;
	}

	/**
	* 
	* @return
	* The amount
	*/
	@JsonProperty("amount")
	public double getAmount() {
	return amount;
	}

	/**
	* 
	* @param amount
	* The amount
	*/
	@JsonProperty("amount")
	public void setAmount(double amount) {
	this.amount = amount;
	}

	/**
	* 
	* @return
	* The customers
	*/
	@JsonProperty("customers")
	public List<CustomerModel> getCustomers() {
	return customers;
	}

	/**
	* 
	* @param customers
	* The customers
	*/
	@JsonProperty("customers")
	public void setCustomers(List<CustomerModel> customers) {
	this.customers = customers;
	}

	@JsonProperty("car")
	public CarInsuranceModel getCarInsuranceModel() {
		return carInsuranceModel;
	}

	@JsonProperty("car")
	public void setCarInsuranceModel(CarInsuranceModel carInsuranceModel) {
		this.carInsuranceModel = carInsuranceModel;
	}

	@JsonProperty("flat")
	public FlatInsuranceModel getFlatInsuranceModel() {
		return flatInsuranceModel;
	}
	
	@JsonProperty("flat")
	public void setFlatInsuranceModel(FlatInsuranceModel flatInsuranceModel) {
		this.flatInsuranceModel = flatInsuranceModel;
	}
	
}
