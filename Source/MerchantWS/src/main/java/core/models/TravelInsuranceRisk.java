package core.models;



import com.fasterxml.jackson.annotation.JsonProperty;


public class TravelInsuranceRisk  {
	
	@JsonProperty("risk_Id")
	private Integer riskId;
	@JsonProperty("value")
	private Integer value;

	/**
	* 
	* @return
	* The riskId
	*/
	@JsonProperty("risk_Id")
	public Integer getRiskId() {
	return riskId;
	}

	/**
	* 
	* @param riskId
	* The risk_id
	*/
	@JsonProperty("risk_Id")
	public void setRiskId(Integer riskId) {
	this.riskId = riskId;
	}

	/**
	* 
	* @return
	* The value
	*/
	@JsonProperty("value")
	public Integer getValue() {
	return value;
	}

	/**
	* 
	* @param value
	* The value
	*/
	@JsonProperty("value")
	public void setValue(Integer value) {
	this.value = value;
	}

}
