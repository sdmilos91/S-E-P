package core.repositories.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import core.models.entities.Merchant;
import core.repositories.MerchantRepo;

@Repository
public class JpaMerchantRepo implements MerchantRepo {
	
	@PersistenceContext
	private EntityManager em;

	public Merchant findMerchant(int id) {
		return em.find(Merchant.class, id);
	}

	public Merchant createMerchant(Merchant data) {
		em.persist(data);
		return data;
	}
	
	@SuppressWarnings("unchecked")
	public Merchant getMerchantData() {
		
		List<Merchant> merchants = em.createQuery("select m from Merchant m" ).getResultList();
		return merchants.get(0);
	}

}
