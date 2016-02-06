package core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import core.models.entities.Order;
import core.repositories.OrderRepo;
import core.services.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepo repo;
	
	public Order findOrder(long order_Id ) {
		
		return repo.findOrder(order_Id);
		
	}
	
	public Order createOrder(Order data) {
		
		return repo.createOrder(data);
	}

	public Order updateOrder(Order order) {
		
		return repo.updateOrder(order);
	}
}
