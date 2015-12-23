package core.repositories;

import core.models.entities.Vehicle;

public interface VehicleRepo {

	public Vehicle findCar(String chasseId);
	public Vehicle createCar(Vehicle data);
}
