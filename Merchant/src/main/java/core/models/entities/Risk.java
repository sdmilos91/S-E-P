package core.models.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "RISK")
public class Risk implements java.io.Serializable {

	@Id 
	@Column(name = "risk_Id", nullable = false)
	private int risk_Id;
	
	@Column(name = "value", nullable = false)
	private String value;
	
	@Column(name = "validFrom", nullable = false)
	private Date validFrom;
	
	@Column(name = "validTo", nullable = false)
	private Date validTo;
	
	@Column(name = "coef", nullable = false)
	private float coef;
	
	@Column(name = "flag", nullable = false)
	private boolean flag;
	
	@OneToOne(targetEntity=RiskType.class)
	private int riskType_Id;
	
	@ManyToMany(mappedBy = "risks")
	public java.util.Set<Policy> inPolicies;

	public int getRisk_Id() {
		return risk_Id;
	}

	public void setRisk_Id(int risk_Id) {
		this.risk_Id = risk_Id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public float getCoef() {
		return coef;
	}

	public void setCoef(float coef) {
		this.coef = coef;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public int getRiskType_Id() {
		return riskType_Id;
	}

	public void setRiskType_Id(int riskType_Id) {
		this.riskType_Id = riskType_Id;
	}

	public java.util.Set<Policy> getInPolicies() {
		return inPolicies;
	}

	public void setInPolicies(java.util.Set<Policy> inPolicies) {
		this.inPolicies = inPolicies;
	}
	
}
