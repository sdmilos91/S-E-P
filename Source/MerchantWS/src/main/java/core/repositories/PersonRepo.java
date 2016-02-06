package core.repositories;

import java.util.List;

import core.models.entities.Person;

public interface PersonRepo {

	public Person findPerson(int person_Id);
	public Person createPerson(Person data);
	public List<Person> getAll();
	
}
