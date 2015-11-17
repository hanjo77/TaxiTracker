package TaxiTracker.service.impl;

import TaxiTracker.model.Car;
import TaxiTracker.repository.CarRepository;
import TaxiTracker.service.CarService;
import TaxiTracker.service.dto.CarDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import javax.inject.Inject;
import javax.inject.Named;
import java.lang.reflect.Type;
import java.util.Collection;

@Named
public class DefaultCarService implements CarService {

    @Inject
    private CarRepository carRepository;

    private final ModelMapper mapper = new ModelMapper();

    public CarDTO create(CarDTO carDto) {
        Car car = mapper.map(carDto, Car.class);
        Car persistedCar = carRepository.save(car);
        return mapper.map(persistedCar, CarDTO.class);
    }

    public CarDTO read(long id) {
        Car car = carRepository.findOne(id);
        if (car == null) return null;
        return mapper.map(car, CarDTO.class);
    }

    public Collection<CarDTO> list() {
        Iterable<Car> cars = carRepository.findAll();
        Type listType = new TypeToken<Collection<CarDTO>>() {
        }.getType();
        return mapper.map(cars, listType);
    }

    public CarDTO update(CarDTO carDto) {
        Car car = mapper.map(carDto, Car.class);
        Car updatedCar = carRepository.save(car);
        return mapper.map(updatedCar, CarDTO.class);
    }

    public void delete(CarDTO carDto) {
        Car car = carRepository.findOne(carDto.getId());
        carRepository.delete(car);
    }
}
