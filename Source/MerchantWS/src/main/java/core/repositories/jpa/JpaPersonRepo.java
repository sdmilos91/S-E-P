package core.repositories.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import core.models.entities.Person;
import core.repositories.PersonRepo;

@Repository
public class JpaPersonRepo implements PersonRepo {

	@PersistenceContext
	private EntityManager em;
	
	public Person findPerson(int person_Id) {
		return em.find(Person.class, person_Id);
	}

	public Person createPerson(Person data) {
		em.persist(data);
		return data;
	}
	
	@SuppressWarnings("unchecked")
	public List<Person> getAll() {
		
		List<Person> persons = em.createQuery("select p from Person p" ).getResultList();
		return persons;
	}
	

}
