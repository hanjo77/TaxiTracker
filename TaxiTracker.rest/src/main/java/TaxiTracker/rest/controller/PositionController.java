package TaxiTracker.rest.controller;

import TaxiTracker.service.PositionService;
import TaxiTracker.service.dto.PositionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Collection;

@Controller
@RequestMapping("/positions")
public class PositionController {

	@Inject
	private PositionService positionService;

	/**
	 * Create
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public PositionDTO createPosition(@RequestBody PositionDTO position) {
		PositionDTO createdPosition = positionService.create(position);
		System.out.println("Position created with id = " + createdPosition.getId());
		return createdPosition;
	}

	/**
	 * ReadAll
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Collection<PositionDTO> getPositions() {
		System.out.println("Collection of Position requested");
		return positionService.list();
	}

	/**
	 * Read
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public PositionDTO getPosition(@PathVariable long id) {
		System.out.println("Position requested with id = " + id);
		return positionService.read(id);
	}

	/**
	 * Update
	 */
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public PositionDTO updatePosition(@RequestBody PositionDTO position) {
		PositionDTO updatedPosition = positionService.update(position);
		System.out.println("Position updated with id = " + updatedPosition.getId());
		return updatedPosition;
	}

	/**
	 * Delete
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deletePosition(@PathVariable long id) {
		PositionDTO position = positionService.read(id);
		positionService.delete(position);
		System.out.println("Delete Position with id = " + id);
	}
}
