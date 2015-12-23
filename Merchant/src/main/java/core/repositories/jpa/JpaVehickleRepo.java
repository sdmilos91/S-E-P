package core.repositories.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import core.models.entities.Vehicle;
import core.repositories.VehicleRepo;

@Repository
public class JpaVehickleRepo implements VehicleRepo {

	@PersistenceContext
	private EntityManager em;

	public Vehicle findCar(String chasseId) {
		return em.find(Vehicle.class, chasseId);
	}

	public Vehicle createCar(Vehicle data) {
		em.persist(data);
		return data;
	}

}
