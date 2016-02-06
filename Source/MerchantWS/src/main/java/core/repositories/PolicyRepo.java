package core.repositories;

import core.models.entities.Policy;

public interface PolicyRepo {

	public Policy findPolicy(int policy_Id);
	public Policy createPolicy(Policy data);
}
