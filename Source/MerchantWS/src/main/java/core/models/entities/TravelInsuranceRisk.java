package core.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name = "TRAVEL_INSURANCE_RISK")
public class TravelInsuranceRisk implements java.io.Serializable {
	
	@Id 
	@GeneratedValue
	@Column(name = "id",nullable = false)
	private int id; 
	
	@Column(name = "riskId",nullable = false)
	private Integer riskId;
	
	@Column(name = "value",nullable = false)
	private Integer value;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getRiskId() {
		return riskId;
	}

	public void setRiskId(Integer riskId) {
		this.riskId = riskId;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
}
