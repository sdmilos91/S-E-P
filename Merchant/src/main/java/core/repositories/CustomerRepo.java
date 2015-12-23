package core.repositories;

import core.models.entities.Customer;

public interface CustomerRepo {
	
	public Customer findCustomer(String customer_Id);
	public Customer createCustomer(Customer data);
}
