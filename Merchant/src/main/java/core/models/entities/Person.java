package core.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.InheritanceType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "PERSON")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person implements java.io.Serializable {

	@Id 
	@Column(name = "JMBG", nullable = false)
	private String JMBG;
	
	@Column(name = "firstName", nullable = false)
	private String firstName;
	
	@Column(name = "surName", nullable = false)
	private String surName;
	
	
	public String getJMBG() {
		return JMBG;
	}
	public void setJMBG(String jMBG) {
		JMBG = jMBG;
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

}