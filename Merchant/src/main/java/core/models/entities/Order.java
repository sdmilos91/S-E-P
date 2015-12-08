package core.models.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "ORDER")
public class Order implements java.io.Serializable {
	
	@Id 
	@Column(name = "order_Id", nullable = false)
	private int order_Id;
	
	@OneToOne(targetEntity=CarInsurance.class)
	private int carInsurance_Id;
	
	@OneToOne(targetEntity=FlatInsurance.class)
	private int flatInsurance_Id;
	
	@OneToOne(targetEntity=Person.class)
	private String JMBG;
	
	@OneToMany
	private Set<TravelInsurance> travelInsurances;
	
	@Column(name = "timestamp", nullable = false)
	private Date timestamp;
	
	@Column(name = "amount", nullable = false)
	private double amount;

	public int getOrder_Id() {
		return order_Id;
	}

	public void setOrder_Id(int order_Id) {
		this.order_Id = order_Id;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getCarInsurance_Id() {
		return carInsurance_Id;
	}

	public void setCarInsurance_Id(int carInsurance_Id) {
		this.carInsurance_Id = carInsurance_Id;
	}

	public int getFlatInsurance_Id() {
		return flatInsurance_Id;
	}

	public void setFlatInsurance_Id(int flatInsurance_Id) {
		this.flatInsurance_Id = flatInsurance_Id;
	}

	public String getJMBG() {
		return JMBG;
	}

	public void setJMBG(String jMBG) {
		JMBG = jMBG;
	}

	public Set<TravelInsurance> getTravelInsurances() {
		return travelInsurances;
	}

	public void setTravelInsurances(Set<TravelInsurance> travelInsurances) {
		this.travelInsurances = travelInsurances;
	}

}