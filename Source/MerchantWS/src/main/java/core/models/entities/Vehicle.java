package core.models.entities;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "VECHICKLE")
public class Vehicle implements java.io.Serializable {
	
	@Id 
	@GeneratedValue
	@Column(name = "vehicle_Id", nullable = false)
	private int vehicle_Id;
	 
	@Column(name = "chasseId", nullable = true)
	private String chasseId;
	
	@Column(name = "type", nullable = false)
	private String type;
	
	@Column(name = "licencePlate", nullable = false)
	private String licencePlate;
	
	@Column(name = "age", nullable = false)
	private int age;
		
	@OneToMany(mappedBy = "vehicle")
	public java.util.Set<Policy> policies;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "JMBG")
	public Person owner;
	
	public int getVehicle_Id() {
		return vehicle_Id;
	}
	public void setVehicle_Id(int vehicle_Id) {
		this.vehicle_Id = vehicle_Id;
	}
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
