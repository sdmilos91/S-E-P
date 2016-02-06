package core.services;

import java.util.List;

import core.models.entities.Person;

public interface PersonService {

	public Person findPerson(int person_Id);
	public Person createPerson(Person data);
	public List<Person> getAll();
}
