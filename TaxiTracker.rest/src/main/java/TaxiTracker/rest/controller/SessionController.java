package TaxiTracker.rest.controller;

import TaxiTracker.service.SessionService;
import TaxiTracker.service.dto.SessionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Collection;

@Controller
@RequestMapping("/sessions")
public class SessionController {

	@Inject
	private SessionService sessionService;

	/**
	 * Create
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public SessionDTO createSession(@RequestBody SessionDTO session) {
		SessionDTO createdSession = sessionService.create(session);
		System.out.println("Session created with id = " + createdSession.getId());
		return createdSession;
	}

	/**
	 * ReadAll
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Collection<SessionDTO> getSessions() {
		System.out.println("Collection of Session requested");
		return sessionService.list();
	}

	/**
	 * Read
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public SessionDTO getSession(@PathVariable long id) {
		System.out.println("Session requested with id = " + id);
		return sessionService.read(id);
	}

	/**
	 * Update
	 */
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public SessionDTO updateSession(@RequestBody SessionDTO session) {
		SessionDTO updatedSession = sessionService.update(session);
		System.out.println("Session updated with id = " + updatedSession.getId());
		return updatedSession;
	}

	/**
	 * Delete
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteSession(@PathVariable long id) {
		SessionDTO session = sessionService.read(id);
		sessionService.delete(session);
		System.out.println("Delete Session with id = " + id);
	}
}
