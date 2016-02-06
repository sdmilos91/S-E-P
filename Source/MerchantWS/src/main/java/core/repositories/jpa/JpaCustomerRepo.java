package core.repositories.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import core.models.entities.Customer;
import core.repositories.CustomerRepo;

@Repository
public class JpaCustomerRepo implements CustomerRepo {

	@PersistenceContext
	private EntityManager em;
	
	public Customer findCustomer(int customer_Id) {
		return em.find(Customer.class, customer_Id);
	}

	public Customer createCustomer(Customer data) {
		em.persist(data);
		return data;
	}
	
	@SuppressWarnings("unchecked")
	public Customer findCustomer(String jmbg) {
		
		List<Customer> results = new ArrayList<Customer>();
		results = em.createQuery("select c from Customer c where c.jmbg like " + jmbg  ).getResultList();
		
		if(results.size() != 0) return  results.get(0);
		else return null;
	}

}
