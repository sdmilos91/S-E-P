package core.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import core.models.entities.Risk;
import core.repositories.RiskRepo;
import core.services.RiskService;
import core.services.util.RiskList;

@Service
@Transactional
public class RiskServiceImpl implements RiskService {

	@Autowired
	private RiskRepo repo;
	
	public RiskList findRisks(String riskType) {
		
		return repo.findRisks(riskType);
	}

	public Risk findRisk(int riskId) {
		
		return repo.findRisk(riskId);
	}

}
