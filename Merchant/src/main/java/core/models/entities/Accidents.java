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
@Table(name = "ACCIDENTS")
public class Accidents implements java.io.Serializable {
	
	@Id 
	@Column(name = "accident_Id", nullable = false)
	private String accident_Id;
	
	@Column(name = "accidentName", nullable = false)
	private String accidentName;
	
	@Column(name = "coef", nullable = false)
	private long coef;
	
	@ManyToMany
    private Set<FlatInsurance> flatInsurances = new HashSet<FlatInsurance>();

	public String getAccident_Id() {
		return accident_Id;
	}

	public void setAccident_Id(String accident_Id) {
		this.accident_Id = accident_Id;
	}

	public String getAccidentName() {
		return accidentName;
	}

	public void setAccidentName(String accidentName) {
		this.accidentName = accidentName;
	}

	public long getCoef() {
		return coef;
	}

	public void setCoef(long coef) {
		this.coef = coef;
	}

	public Set<FlatInsurance> getFlatInsurances() {
		return flatInsurances;
	}

	public void setFlatInsurances(Set<FlatInsurance> flatInsurances) {
		this.flatInsurances = flatInsurances;
	}
	
}