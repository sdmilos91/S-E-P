package core.models.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "CAR")
public class Vehicle implements java.io.Serializable {
	
	@Id 
	@Column(name = "chasseId", nullable = false)
	private String chasseId;
	
	@OneToOne(targetEntity=Person.class)
	private String JMBG;
	
	@Column(name = "type", nullable = false)
	private String type;
	
	@Column(name = "licencePlate", nullable = false)
	private String licencePlate;
	
	@Column(name = "age", nullable = false)
	private Date age;
	
	@OneToOne(targetEntity=VehickleModel.class)
	private int vehickleModel_Id;
	
	@OneToMany(mappedBy = "vehicle")
	public java.util.Set<Policy> policies;
	
	@ManyToOne
	@JoinColumn(name = "JMBG")
	public Person owner;
	
	public String getChasseId() {
		return chasseId;
	}
	public void setChasseId(String chasseId) {
		this.chasseId = chasseId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLicencePlate() {
		return licencePlate;
	}
	public void setLicencePlate(String licencePlate) {
		this.licencePlate = licencePlate;
	}
	public Date getAge() {
		return age;
	}
	public void setAge(Date age) {
		this.age = age;
	}
	public String getJMBG() {
		return JMBG;
	}
	public void setJMBG(String jMBG) {
		JMBG = jMBG;
	}
	public int getVehickleModel_Id() {
		return vehickleModel_Id;
	}
	public void setVehickleModel_Id(int vehickleModel_Id) {
		this.vehickleModel_Id = vehickleModel_Id;
	}
	public java.util.Set<Policy> getPolicies() {
		return policies;
	}
	public void setPolicies(java.util.Set<Policy> policies) {
		this.policies = policies;
	}
	public Person getOwner() {
		return owner;
	}
	public void setOwner(Person owner) {
		this.owner = owner;
	}
	
}
