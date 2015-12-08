package core.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "FLOORAREARANGE")
public class FloorAreaRange implements java.io.Serializable {

	@Id 
	@Column(name = "floorArea_Id", nullable = false)
	private String floorArea_Id;
	
	@Column(name = "floorAreaValue", nullable = false)
	private String floorAreaValue;
	
	@Column(name = "coef", nullable = false)
	private long coef;

	public String getFloorArea_Id() {
		return floorArea_Id;
	}

	public void setFloorArea_Id(String floorArea_Id) {
		this.floorArea_Id = floorArea_Id;
	}

	public String getFloorAreaValue() {
		return floorAreaValue;
	}

	public void setFloorAreaValue(String floorAreaValue) {
		this.floorAreaValue = floorAreaValue;
	}

	public long getCoef() {
		return coef;
	}

	public void setCoef(long coef) {
		this.coef = coef;
	}
	
}