package core.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "TRAVELINSURANCE")
public class TravelInsurance implements java.io.Serializable {

	@Id 
	@Column(name = "travelInsurace_Id", nullable = false)
	private String travelInsurace_Id;
	
	@OneToOne(targetEntity=Order.class)
	private int order_Id;
	
	@OneToOne(targetEntity=Region.class)
	private String region_Id;
	
	@OneToOne(targetEntity=InsuranceAmounts.class)
	private String amount_Id;
	
	@OneToOne(targetEntity=AgeRange.class)
	private String ageRange_Id;
	
	@OneToOne(targetEntity=Sports.class)
	private String sport_Id;
	
	@OneToOne(targetEntity=Person.class)
	private String JMBG;
	
	@Column(name = "duration", nullable = false)
	private int duration;

	public String getTravelInsurace_Id() {
		return travelInsurace_Id;
	}

	public void setTravelInsurace_Id(String travelInsurace_Id) {
		this.travelInsurace_Id = travelInsurace_Id;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getOrder_Id() {
		return order_Id;
	}

	public void setOrder_Id(int order_Id) {
		this.order_Id = order_Id;
	}

	public String getRegion_Id() {
		return region_Id;
	}

	public void setRegion_Id(String region_Id) {
		this.region_Id = region_Id;
	}

	public String getAmount_Id() {
		return amount_Id;
	}

	public void setAmount_Id(String amount_Id) {
		this.amount_Id = amount_Id;
	}

	public String getAgeRange_Id() {
		return ageRange_Id;
	}

	public void setAgeRange_Id(String ageRange_Id) {
		this.ageRange_Id = ageRange_Id;
	}

	public String getSport_Id() {
		return sport_Id;
	}

	public void setSport_Id(String sport_Id) {
		this.sport_Id = sport_Id;
	}

	public String getJMBG() {
		return JMBG;
	}

	public void setJMBG(String jMBG) {
		JMBG = jMBG;
	}
	
	
}