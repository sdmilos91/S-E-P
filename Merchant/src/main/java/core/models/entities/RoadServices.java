package core.models.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "ROADSERVICES")
public class RoadServices implements java.io.Serializable {
	
	@Id 
	@Column(name = "roadService_Id", nullable = false)
	private String roadService_Id;
	
	@Column(name = "roadServiceName", nullable = false)
	private String roadServiceName;
	
	@Column(name = "coef", nullable = false)
	private long coef;
	
	@ManyToMany
    private Set<CarInsurance> carInsurances = new HashSet<CarInsurance>();


	public String getRoadService_Id() {
		return roadService_Id;
	}

	public void setRoadService_Id(String roadService_Id) {
		this.roadService_Id = roadService_Id;
	}

	public String getRoadServiceName() {
		return roadServiceName;
	}

	public void setRoadServiceName(String roadServiceName) {
		this.roadServiceName = roadServiceName;
	}

	public long getCoef() {
		return coef;
	}

	public void setCoef(long coef) {
		this.coef = coef;
	}

	public Set<CarInsurance> getCarInsurances() {
		return carInsurances;
	}

	public void setCarInsurances(Set<CarInsurance> carInsurances) {
		this.carInsurances = carInsurances;
	}
	
}