package core.repositories.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import core.models.entities.Person;
import core.repositories.PersonRepo;

@Repository
public class JpaPersonRepo implements PersonRepo {

	@PersistenceContext
	private EntityManager em;
	
	public Person findPerson(String JMBG) {
		return em.find(Person.class, JMBG);
	}

	public Person createPerson(Person data) {
		em.persist(data);
		return data;
	}

}
