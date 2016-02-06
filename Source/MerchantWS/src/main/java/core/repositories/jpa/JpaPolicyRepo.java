package core.repositories.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import core.models.entities.Policy;
import core.repositories.PolicyRepo;

@Repository
public class JpaPolicyRepo implements PolicyRepo {
	
	@PersistenceContext
	private EntityManager em;

	public Policy findPolicy(int policy_id) {
		return em.find(Policy.class, policy_id);
	}

	public Policy createPolicy(Policy data) {
		em.persist(data);
		return data;
	}

}
