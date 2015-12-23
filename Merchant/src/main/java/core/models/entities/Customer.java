package core.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "CUSTOMER")
public class Customer extends Person implements java.io.Serializable {
	
	@Column(name = "email", nullable = true)
	private String email;
	
	@Column(name = "passportNumber", nullable = false)
	private String passportNumber;
	
	@Column(name = "telephoneNumber", nullable = false)
	private String telephoneNumber;
	
	@OneToOne(targetEntity=Address.class)
	private String address_Id ;
	
	@ManyToMany(mappedBy = "customers")
	public java.util.Set<Policy> usingPolicies;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getAddress_Id() {
		return address_Id;
	}

	public void setAddress_Id(String address_Id) {
		this.address_Id = address_Id;
	}

	public java.util.Set<Policy> getUsingPolicies() {
		return usingPolicies;
	}

	public void setUsingPolicies(java.util.Set<Policy> usingPolicies) {
		this.usingPolicies = usingPolicies;
	}
	
}