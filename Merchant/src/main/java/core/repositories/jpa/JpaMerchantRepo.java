package core.repositories.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import core.models.entities.Merchant;
import core.repositories.MerchantRepo;

@Repository
public class JpaMerchantRepo implements MerchantRepo {
	
	@PersistenceContext
	private EntityManager em;

	public Merchant findMerchant(String JMBG) {
		return em.find(Merchant.class, JMBG);
	}

	public Merchant createMerchant(Merchant data) {
		em.persist(data);
		return data;
	}

}
