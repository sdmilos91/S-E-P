package core.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "SPORTS")
public class Sports implements java.io.Serializable {

	@Id 
	@Column(name = "sport_Id", nullable = false)
	private String sport_Id;
	
	@Column(name = "sportName", nullable = false)
	private String sportName;
	
	@Column(name = "coef", nullable = false)
	private long coef;

	public String getSport_Id() {
		return sport_Id;
	}

	public void setSport_Id(String sport_Id) {
		this.sport_Id = sport_Id;
	}

	public String getSportName() {
		return sportName;
	}

	public void setSportName(String sportName) {
		this.sportName = sportName;
	}

	public long getCoef() {
		return coef;
	}

	public void setCoef(long coef) {
		this.coef = coef;
	}
	
	
	
}
