package core.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "AGERANGE")
public class AgeRange implements java.io.Serializable {
	
	@Id 
	@Column(name = "ageRange_Id", nullable = false)
	private String ageRange_Id;
	
	@Column(name = "ageRangeValue", nullable = false)
	private String ageRangeValue;
	
	@Column(name = "coef", nullable = false)
	private long coef;
	
	@Column(name = "flag", nullable = false)
	private char flag;

	public String getAgeRange_Id() {
		return ageRange_Id;
	}

	public void setAgeRange_Id(String ageRange_Id) {
		this.ageRange_Id = ageRange_Id;
	}

	public String getAgeRangeValue() {
		return ageRangeValue;
	}

	public void setAgeRangeValue(String ageRangeValue) {
		this.ageRangeValue = ageRangeValue;
	}

	public long getCoef() {
		return coef;
	}

	public void setCoef(long coef) {
		this.coef = coef;
	}

	public char getFlag() {
		return flag;
	}

	public void setFlag(char flag) {
		this.flag = flag;
	}
	
	

}
