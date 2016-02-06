package core.models.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "CUST_ORDER")
public class Order implements java.io.Serializable {
	
	@Id 
	@Column(name = "order_Id", nullable = false)
	private long order_Id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "person_Id")
	private Person person;
	
	@Column(name = "timestamp", nullable = false)
	private String timestamp;
	
	@Column(name = "amount", nullable = false)
	private double amount;
	
	@Column(name = "acquirerID", nullable = true)
	private long acquirerID;
	
	@Column(name = "acquirerTimestamp", nullable = true)
	private String acquirerTimestamp;
	
	@OneToOne
	@JoinColumn(name = "policy_Id")
	private Policy policy;

	public long getOrder_Id() {
		return order_Id;
	}

	public void setOrder_Id(long order_Id) {
		this.order_Id = order_Id;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public long getAcquirerID() {
		return acquirerID;
	}

	public void setAcquirerID(long acquirerID) {
		this.acquirerID = acquirerID;
	}

	public String getAcquirerTimestamp() {
		return acquirerTimestamp;
	}

	public void setAcquirerTimestamp(String acquirerTimestamp) {
		this.acquirerTimestamp = acquirerTimestamp;
	}
	
}