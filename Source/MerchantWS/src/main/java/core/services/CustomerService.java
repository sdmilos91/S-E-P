package core.services;

import core.models.entities.Customer;

public interface CustomerService {

	public Customer findCustomer(int customer_Id);
	public Customer createCustomer(Customer data);
	public Customer findCustomer(String jmbg);
}
