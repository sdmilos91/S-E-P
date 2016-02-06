package core.models.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
public class Customer extends Person implements java.io.Serializable {
	
	@Column(name = "email", nullable = true)
	private String email;
	
	@Column(name = "passportNumber", nullable = false)
	private String passportNumber;
	
	@Column(name = "telephoneNumber", nullable = false)
	private String telephoneNumber;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "customers")
	public List<Policy> usingPolicies;

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

	public List<Policy> getUsingPolicies() {
		return usingPolicies;
	}

	public void setUsingPolicies(List<Policy> usingPolicies) {
		this.usingPolicies = usingPolicies;
	}


	
}