package TaxiTracker.service;

import TaxiTracker.service.dto.CarDTO;

import java.util.Collection;

/**
 * Created by hanjo on 17.11.15.
 */
public interface CarService {

    public CarDTO create(CarDTO car);

    public CarDTO read(long id);

    public Collection<CarDTO> list();

    public CarDTO update(CarDTO car);

    public void delete(CarDTO car);
}
