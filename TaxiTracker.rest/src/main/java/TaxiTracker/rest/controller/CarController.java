package TaxiTracker.rest.controller;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import TaxiTracker.service.CarService;
import TaxiTracker.service.dto.CarDTO;

@Controller
@RequestMapping("/cars")
public class CarController {

	@Inject
	private CarService carService;

	/**
	 * Create
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public CarDTO createCar(@RequestBody CarDTO car) {
		CarDTO createdCar = carService.create(car);
		System.out.println("Car created with id = " + createdCar.getId());
		return createdCar;
	}

	/**
	 * ReadAll
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Collection<CarDTO> getCars() {
		System.out.println("Collection of Car requested");
		return carService.list();
	}

	/**
	 * Read
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public CarDTO getCar(@PathVariable long id) {
		System.out.println("Car requested with id = " + id);
		return carService.read(id);
	}

	/**
	 * Update
	 */
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public CarDTO updateCar(@RequestBody CarDTO car) {
		CarDTO updatedCar = carService.update(car);
		System.out.println("Car updated with id = " + updatedCar.getId());
		return updatedCar;
	}

	/**
	 * Delete
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteCar(@PathVariable long id) {
		CarDTO car = carService.read(id);
		carService.delete(car);
		System.out.println("Delete Car with id = " + id);
	}
}
