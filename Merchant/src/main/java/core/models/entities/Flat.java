package core.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "FLAT")
public class Flat implements java.io.Serializable {
	
	@Id 
	@Column(name = "flat_Id", nullable = false)
	private String flat_Id;
	
	@OneToOne(targetEntity=AgeRange.class)
	private String ageRange_Id;
	
	@OneToOne(targetEntity=FloorAreaRange.class)
	private String floorArea_Id;
	
	@OneToOne(targetEntity=Address.class)
	private String address_Id;
	
	@OneToOne(targetEntity=Person.class)
	private String JMBG;
	
	public String getFlat_Id() {
		return flat_Id;
	}

	public void setFlat_Id(String flat_Id) {
		this.flat_Id = flat_Id;
	}

	public String getAgeRange_Id() {
		return ageRange_Id;
	}

	public void setAgeRange_Id(String ageRange_Id) {
		this.ageRange_Id = ageRange_Id;
	}

	public String getFloorArea_Id() {
		return floorArea_Id;
	}

	public void setFloorArea_Id(String floorArea_Id) {
		this.floorArea_Id = floorArea_Id;
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
	
}