package core.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "INSURANCEAMOUNTS")
public class InsuranceAmounts implements java.io.Serializable {
	
	@Id 
	@Column(name = "amount_Id", nullable = false)
	private String amount_Id;
	
	@Column(name = "amount", nullable = false)
	private double amount;

	public String getAmount_Id() {
		return amount_Id;
	}

	public void setAmount_Id(String amount_Id) {
		this.amount_Id = amount_Id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
	

}
