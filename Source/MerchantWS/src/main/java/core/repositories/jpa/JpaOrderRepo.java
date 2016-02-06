package core.repositories.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import core.models.entities.Order;
import core.repositories.OrderRepo;

@Repository
public class JpaOrderRepo implements OrderRepo {

	@PersistenceContext
	private EntityManager em;
	
	public Order findOrder(long order_Id) {
		return em.find(Order.class, order_Id);
	}

	public Order createOrder(Order data) {
		em.persist(data);
		return data;
	}

	public Order updateOrder(Order order) {		
		em.merge(order);
		return order;
	}

}
