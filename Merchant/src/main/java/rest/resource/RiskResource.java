package rest.resource;

import java.util.Date;

import org.springframework.hateoas.ResourceSupport;

import core.models.entities.Risk;

public class RiskResource extends ResourceSupport {

private int risk_Id;
	
	private String value;
	
	private Date validFrom;

	private Date validTo;

	private float coef;

	private boolean flag;

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
	
	public Risk toRisk() {
		Risk risk = new Risk();
		risk.setRisk_Id(risk_Id);
		risk.setCoef(coef);
		risk.setFlag(flag);
		risk.setValue(value);
		risk.setValidFrom(validFrom);
		risk.setValidTo(validTo);
		return risk;
	}
}
