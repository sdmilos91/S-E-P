package core.models.entities;

import java.util.Set;

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
@Table(name = "FLAT")
public class Flat implements java.io.Serializable {
	
	@Id 
	@Column(name = "flat_Id", nullable = false)
	private String flat_Id;
	
	@Column(name = "flatAge", nullable = false)
	private int flatAge;
	
	@Column(name = "floorArea", nullable = false)
	private float floorArea;
	
	@Column(name = "flatValue", nullable = false)
	private double flatValue;
	
	@OneToOne(targetEntity=Address.class)
	private String address_Id;
	
	@OneToOne(targetEntity=Person.class)
	private String JMBG;
	
	@OneToMany(mappedBy = "flat")
	public Set<Policy> policies;

	@ManyToOne
	@JoinColumn(name = "JMBG")
	public Person owner;
	
	public String getFlat_Id() {
		return flat_Id;
	}

	public void setFlat_Id(String flat_Id) {
		this.flat_Id = flat_Id;
	}

	public String getAddress_Id() {
		return address_Id;
	}

	public void setAddress_Id(String address_Id) {
		this.address_Id = address_Id;
	}

	public String getJMBG() {
		return JMBG;
	}

	public void setJMBG(String jMBG) {
		JMBG = jMBG;
	}

	public int getFlatAge() {
		return flatAge;
	}

	public void setFlatAge(int flatAge) {
		this.flatAge = flatAge;
	}

	public float getFloorArea() {
		return floorArea;
	}

	public void setFloorArea(float floorArea) {
		this.floorArea = floorArea;
	}

	public double getFlatValue() {
		return flatValue;
	}

	public void setFlatValue(double flatValue) {
		this.flatValue = flatValue;
	}

	public Set<Policy> getPolicies() {
		return policies;
	}

	public void setPolicies(Set<Policy> policies) {
		this.policies = policies;
	}

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}
	
}