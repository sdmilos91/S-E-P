package core.repositories;

import core.models.entities.Flat;

public interface FlatRepo {

	public Flat findFlat(String flat_Id);
	public Flat createFlat(Flat data);
}
