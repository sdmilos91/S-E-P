package core.services;

import core.models.entities.Policy;

public interface PolicyService {

	public Policy findPolicy(int policy_Id);
	public Policy createPolicy(Policy data);
}
