package core.models.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "RISKTYPE")
public class RiskType implements java.io.Serializable {

	@Id 
	@Column(name = "riskType_Id", nullable = false)
	private int riskType_Id;
	
	@Column(name = "riskType", nullable = false)
	private String riskType;
	
	@OneToMany(mappedBy="riskType")
	private Set<Risk> risks;

	public int getRiskType_Id() {
		return riskType_Id;
	}

	public void setRiskType_Id(int riskType_Id) {
		this.riskType_Id = riskType_Id;
	}

	public String getRiskType() {
		return riskType;
	}

	public void setRiskType(String riskType) {
		this.riskType = riskType;
	}

	public Set<Risk> getRisks() {
		return risks;
	}

	public void setRisks(Set<Risk> risks) {
		this.risks = risks;
	}
	
}
