package core.models.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "CARINSURANCE")
public class CarInsurance implements java.io.Serializable {
	
	@Id 
	@Column(name = "carInsurance_Id", nullable = false)
	private int carInsurance_Id;
	
	@OneToOne(targetEntity=Car.class)
	private String chasseId;
	
	@OneToOne(targetEntity=Order.class)
	private int order_Id;
		
	@Column(name = "duration", nullable = false)
	private int duration;
	
	 @ManyToMany(cascade = {CascadeType.ALL})
	 @JoinTable(name="CARINSUR_ROADSERVICES", 
	             joinColumns={@JoinColumn(name="carInsurance_Id")}, 
	             inverseJoinColumns={@JoinColumn(name="roadService_Id")})
	 private Set<RoadServices> roadServices = new HashSet<RoadServices>();

	public int getCarInsurance_Id() {
		return carInsurance_Id;
	}

	public void setCarInsurance_Id(int carInsurance_Id) {
		this.carInsurance_Id = carInsurance_Id;
	}


	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getChasseId() {
		return chasseId;
	}

	public void setChasseId(String chasseId) {
		this.chasseId = chasseId;
	}

	public int getOrder_Id() {
		return order_Id;
	}

	public void setOrder_Id(int order_Id) {
		this.order_Id = order_Id;
	}

	public Set<RoadServices> getRoadServices() {
		return roadServices;
	}

	public void setRoadServices(Set<RoadServices> roadServices) {
		this.roadServices = roadServices;
	}
	
	
	
	
	
}
