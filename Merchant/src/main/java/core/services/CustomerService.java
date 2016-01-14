package core.services;

import core.models.entities.Customer;

public interface CustomerService {

	public Customer findCustomer(String customer_Id);
	public Customer createCustomer(Customer data);
}
