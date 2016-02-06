package core.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "PERSON")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person implements java.io.Serializable {

	@Id 
	@GeneratedValue
	@Column(name = "person_Id",nullable = false)
	private int person_Id;

	@Column(name = "jmbg",nullable = false)
	private String jmbg;
	
	@Column(name = "firstName",nullable = false)
	private String firstName;
	
	@Column(name = "surName",nullable = false)
	private String surName;
	
	@Column(name = "email",nullable = true)
	private String email;
	
	@Column(name = "address", nullable = true)
	private String address ;
	
	@OneToOne(mappedBy="person")
	private Order order;
	
	public int getPerson_Id() {
		return person_Id;
	}
	public void setPerson_Id(int person_Id) {
		this.person_Id = person_Id;
	}
	public String getJMBG() {
		return jmbg;
	}
	public void setJMBG(String jMBG) {
		this.jmbg = jMBG;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getJmbg() {
		return jmbg;
	}
	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


}