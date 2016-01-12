package TaxiTracker.rest.controller;

import TaxiTracker.service.DriverService;
import TaxiTracker.service.dto.DriverDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Collection;

@Controller
@RequestMapping("/drivers")
public class DriverController {

	@Inject
	private DriverService driverService;

	/**
	 * Create
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public DriverDTO createDriver(@RequestBody DriverDTO driver) {
		DriverDTO createdDriver = driverService.create(driver);
		System.out.println("Driver created with id = " + createdDriver.getId());
		return createdDriver;
	}

	/**
	 * ReadAll
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Collection<DriverDTO> getDrivers() {
		System.out.println("Collection of Driver requested");
		return driverService.list();
	}

	/**
	 * Read
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public DriverDTO getDriver(@PathVariable long id) {
		System.out.println("Driver requested with id = " + id);
		return driverService.read(id);
	}

	/**
	 * Update
	 */
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public DriverDTO updateDriver(@RequestBody DriverDTO driver) {
		DriverDTO updatedDriver = driverService.update(driver);
		System.out.println("Driver updated with id = " + updatedDriver.getId());
		return updatedDriver;
	}

	/**
	 * Delete
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteDriver(@PathVariable long id) {
		DriverDTO driver = driverService.read(id);
		driverService.delete(driver);
		System.out.println("Delete Driver with id = " + id);
	}
}
