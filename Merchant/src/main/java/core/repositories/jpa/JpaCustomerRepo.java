package core.repositories.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import core.models.entities.Customer;
import core.repositories.CustomerRepo;

@Repository
public class JpaCustomerRepo implements CustomerRepo {

	@PersistenceContext
	private EntityManager em;
	
	public Customer findCustomer(String customer_Id) {
		return em.find(Customer.class, customer_Id);
	}

	public Customer createCustomer(Customer data) {
		em.persist(data);
		return data;
	}

}
