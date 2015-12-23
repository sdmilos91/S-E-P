package core.repositories;

import core.models.entities.Person;

public interface PersonRepo {

	public Person findPerson(String JMBG );
	public Person createPerson(Person data);
	
}
