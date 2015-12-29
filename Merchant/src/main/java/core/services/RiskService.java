package core.services;

import core.models.entities.Risk;
import core.services.util.RiskList;

public interface RiskService {

	public Risk findRisk(int riskId);
	
	public RiskList findRisks(String riskType);
}
