package core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import core.models.entities.Policy;
import core.repositories.PolicyRepo;
import core.services.PolicyService;

@Service
@Transactional
public class PolicyServiceImpl implements PolicyService {
	
	@Autowired
	private PolicyRepo repo;

	public Policy findPolicy(int policy_Id) {
		
		return repo.findPolicy(policy_Id);
		
	}
	public Policy createPolicy(Policy data) {
		
		return repo.createPolicy(data);
		
	}
	
}
