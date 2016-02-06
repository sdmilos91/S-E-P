package core.repositories;

import core.models.entities.Order;

public interface OrderRepo {
	
	public Order findOrder(long order_Id );
	public Order createOrder(Order data);
	public Order updateOrder(Order order);
	
}
