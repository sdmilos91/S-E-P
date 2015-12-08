package core.models.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "FLATINSURANCE")
public class FlatInsurance implements java.io.Serializable {

	@Id 
	@Column(name = "flatInsurance_Id", nullable = false)
	private int flatInsurance_Id;
	
	@OneToOne(targetEntity=Flat.class)
	private String flat_Id;
	
	@OneToOne(targetEntity=Order.class)
	private int order_Id;
	
	@Column(name = "duration", nullable = false)
	private int duration;
	
	 @ManyToMany(cascade = {CascadeType.ALL})
	 @JoinTable(name="FLATINSUR_ACCIDENTS", 
	             joinColumns={@JoinColumn(name="flatInsurance_Id")}, 
	             inverseJoinColumns={@JoinColumn(name="accident_Id")})
	private Set<Accidents> accidents = new HashSet<Accidents>();

	public int getFlatInsurance_Id() {
		return flatInsurance_Id;
	}

	public void setFlatInsurance_Id(int flatInsurance_Id) {
		this.flatInsurance_Id = flatInsurance_Id;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getFlat_Id() {
		return flat_Id;
	}

	public void setFlat_Id(String flat_Id) {
		this.flat_Id = flat_Id;
	}

	public int getOrder_Id() {
		return order_Id;
	}

	public void setOrder_Id(int order_Id) {
		this.order_Id = order_Id;
	}

	public Set<Accidents> getAccidents() {
		return accidents;
	}

	public void setAccidents(Set<Accidents> accidents) {
		this.accidents = accidents;
	}
	
	
	
}
