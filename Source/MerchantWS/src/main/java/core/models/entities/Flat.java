package core.models.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "FLAT")
public class Flat implements java.io.Serializable {
	
	@Id 
	@GeneratedValue
	@Column(name = "flat_Id", nullable = false)
	private int flat_Id;
	
	@Column(name = "flatAge", nullable = false)
	private int flatAge;
	
	@Column(name = "floorArea", nullable = true)
	private float floorArea;
	
	@Column(name = "flatValue", nullable = false)
	private double flatValue;
	
	@Column(name = "address", nullable = true)
	private String address;
	
	@OneToMany(mappedBy = "flat")
	public Set<Policy> policies;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "JMBG")
	public Person owner;
	
	public int getFlat_Id() {
		return flat_Id;
	}

	public void setFlat_Id(int flat_Id) {
		this.flat_Id = flat_Id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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