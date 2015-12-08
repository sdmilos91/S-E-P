package core.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "REGION")
public class Region implements java.io.Serializable {

	@Id 
	@Column(name = "region_Id", nullable = false)
	private String region_Id;
	
	@Column(name = "regionName", nullable = false)
	private String regionName;
	
	@Column(name = "coef", nullable = false)
	private long coef;

	public String getRegion_Id() {
		return region_Id;
	}

	public void setRegion_Id(String region_Id) {
		this.region_Id = region_Id;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public long getCoef() {
		return coef;
	}

	public void setCoef(long coef) {
		this.coef = coef;
	}
	
}