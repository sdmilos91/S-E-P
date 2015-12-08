package core.repositories;

import core.models.entities.Car;

public interface CarRepo {

	public Car findCar(String chasseId);
	public Car createCar(Car data);
}
