package core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import core.models.entities.Customer;
import core.repositories.CustomerRepo;
import core.services.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepo repo;

	public Customer findCustomer(int customer_Id) {
		
		return repo.findCustomer(customer_Id);
	}
	
	public Customer createCustomer(Customer data) {
		
		return repo.createCustomer(data);
	}
	
	public Customer findCustomer(String jmbg) {
		
		return repo.findCustomer(jmbg);
	}
}
