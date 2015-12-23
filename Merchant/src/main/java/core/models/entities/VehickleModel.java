package core.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "VEHICKLEMODEL")
public class VehickleModel implements java.io.Serializable {

	@Id 
	@Column(name = "vehickleModel_Id", nullable = false)
	private int vehickleModel_Id;
	
	@Column(name = "vehickleMark", nullable = false)
	private String vehickleMark;
	
	@Column(name = "vehickleModel", nullable = false)
	private String vehickleModel;

	public int getVehickleModel_Id() {
		return vehickleModel_Id;
	}

	public void setVehickleModel_Id(int vehickleModel_Id) {
		this.vehickleModel_Id = vehickleModel_Id;
	}

	public String getVehickleMark() {
		return vehickleMark;
	}

	public void setVehickleMark(String vehickleMark) {
		this.vehickleMark = vehickleMark;
	}

	public String getVehickleModel() {
		return vehickleModel;
	}

	public void setVehickleModel(String vehickleModel) {
		this.vehickleModel = vehickleModel;
	}
	
}
