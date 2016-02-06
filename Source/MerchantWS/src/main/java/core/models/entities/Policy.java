package core.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
	@GeneratedValue
	@Column(name = "policy_Id", nullable = false)
	private int policy_Id;
	
	@OneToOne(mappedBy="policy")
	private Order order;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "CustomersForPolicy", joinColumns = { @JoinColumn(name = "policy_Id") }, inverseJoinColumns = { @JoinColumn(name = "person_Id") })
	private List<Customer> customers = new ArrayList<Customer>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "RisksForPolicy", joinColumns = { @JoinColumn(name = "policy_Id") }, inverseJoinColumns = { @JoinColumn(name = "id") })
	private List<TravelInsuranceRisk> risks = new ArrayList<TravelInsuranceRisk>();
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "flat_Id", nullable = true)
	private Flat flat;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "vehicle_id", nullable = true)
	private Vehicle vehicle;

	public int getPolicy_Id() {
		return policy_Id;
	}

	public void setPolicy_Id(int policy_Id) {
		this.policy_Id = policy_Id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}


	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<TravelInsuranceRisk> getRisks() {
		return risks;
	}

	public void setRisks(List<TravelInsuranceRisk> risks) {
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
