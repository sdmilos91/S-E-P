package core.services;

import core.models.entities.Order;

public interface OrderService {

	public Order findOrder(long order_Id );
	public Order createOrder(Order data);
	public Order updateOrder(Order order);
}
