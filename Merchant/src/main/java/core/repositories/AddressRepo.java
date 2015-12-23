package core.repositories;

import core.models.entities.Address;

public interface AddressRepo {

	public Address findAddress(String address_Id);
	public Address createAddress(Address data);
	
}
