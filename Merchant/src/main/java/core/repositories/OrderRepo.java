package core.repositories;

import core.models.entities.Order;

public interface OrderRepo {
	
	public Order findOrder(int order_Id );
	public Order createOrder(Order data);
	
}
