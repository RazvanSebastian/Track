package edu.utcluj.track.position.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.utcluj.track.position.model.Position;
import edu.utcluj.track.position.service.IPositionService;
import edu.utcluj.track.position.service.impl.PositionService;

/**
 * @author radu.miron
 * @since 18.10.2016
 */
@RestController
@RequestMapping(value = "/position")
public class PositionController {

	@Autowired
	private IPositionService positionService;

	@PostMapping
	@PreAuthorize(value = "hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	public Position save(@RequestBody Position position) {
		return this.positionService.savePosition(position);
	}

	@GetMapping
	@PreAuthorize(value = "hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	public List<Position> find(@RequestParam(name = "terminal", required = true) String terminalId) {
		return this.positionService.findAll(terminalId);
	}

	@DeleteMapping
	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> delete(@RequestParam(name = "terminal", required = true) String terminalId) {
		try {
			this.positionService.delete(terminalId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping(value = "/{id}")
	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable(name = "id", required = true) Long id,
			@RequestParam(name = "latitude", required = true) String latitude,
			@RequestParam(name = "longitude", required = true) String longitude) {
		this.positionService.update(id, latitude, longitude);
	}
}
