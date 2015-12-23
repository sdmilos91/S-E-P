package core.models.entities;

import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "POLICY")
public class Policy implements java.io.Serializable {

	@Id 
	@Column(name = "policy_Id", nullable = false)
	private int policy_Id;
	
	@OneToOne(targetEntity=Order.class)
	private int order_Id;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CustomersForPolicy", joinColumns = { @JoinColumn(name = "policy_Id") }, inverseJoinColumns = { @JoinColumn(name = "JMBG") })
	public java.util.Set<Customer> customers = new HashSet<Customer>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "RisksForPolicy", joinColumns = { @JoinColumn(name = "policy_Id") }, inverseJoinColumns = { @JoinColumn(name = "risk_Id") })
	public java.util.Set<Risk> risks = new HashSet<Risk>();
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "flat_Id")
	public Flat flat;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "vehicle_id")
	public Vehicle vehicle;

	public int getPolicy_Id() {
		return policy_Id;
	}

	public void setPolicy_Id(int policy_Id) {
		this.policy_Id = policy_Id;
	}

	public int getOrder_Id() {
		return order_Id;
	}

	public void setOrder_Id(int order_Id) {
		this.order_Id = order_Id;
	}

	public java.util.Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(java.util.Set<Customer> customers) {
		this.customers = customers;
	}

	public java.util.Set<Risk> getRisks() {
		return risks;
	}

	public void setRisks(java.util.Set<Risk> risks) {
		this.risks = risks;
	}

	public Flat getFlat() {
		return flat;
	}

	public void setFlat(Flat flat) {
		this.flat = flat;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
}
