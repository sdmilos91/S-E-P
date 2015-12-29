package core.repositories;

import core.models.entities.Risk;
import core.services.util.RiskList;

public interface RiskRepo {

	public Risk findRisk(int riskId);
	
	public RiskList findRisks(String riskType);
	
}
