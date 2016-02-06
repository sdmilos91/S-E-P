package core.repositories;

import core.models.entities.Customer;

public interface CustomerRepo {
	
	public Customer findCustomer(int customer_Id);
	public Customer findCustomer(String jmbg);
	public Customer createCustomer(Customer data);
}
