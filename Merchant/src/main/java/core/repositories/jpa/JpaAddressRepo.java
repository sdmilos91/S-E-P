package core.repositories.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import core.models.entities.Address;
import core.repositories.AddressRepo;

@Repository
public class JpaAddressRepo implements AddressRepo {

	@PersistenceContext
	private EntityManager em;

	public Address findAddress(String address_Id) {
		return em.find(Address.class, address_Id);
	}

	public Address createAddress(Address data) {
		em.persist(data);
		return data;
	}
}
