package core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import core.models.entities.Person;
import core.repositories.PersonRepo;
import core.services.PersonService;

@Service
@Transactional
public class PersonServiceImpl implements PersonService{


	@Autowired
	private PersonRepo repo;
	
	public Person findPerson(int person_Id) {

		return repo.findPerson(person_Id);
	}

	public Person createPerson(Person data) {
		
		return repo.createPerson(data);
	}
	
	public List<Person> getAll() {
		
		return repo.getAll();
	}

}
