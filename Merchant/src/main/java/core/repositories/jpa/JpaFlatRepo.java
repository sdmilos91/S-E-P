package core.repositories.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import core.models.entities.Flat;
import core.repositories.FlatRepo;

@Repository
public class JpaFlatRepo implements FlatRepo {

	@PersistenceContext
	private EntityManager em;
	
	public Flat findFlat(String flat_Id) {
		return em.find(Flat.class, flat_Id);
	}

	public Flat createFlat(Flat data) {
		em.persist(data);
		return data;
	}

}
