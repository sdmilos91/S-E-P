package core.repositories.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import core.models.entities.Car;
import core.repositories.CarRepo;

@Repository
public class JpaCarRepo implements CarRepo {

	@PersistenceContext
	private EntityManager em;

	public Car findCar(String chasseId) {
		return em.find(Car.class, chasseId);
	}

	public Car createCar(Car data) {
		em.persist(data);
		return data;
	}

}
