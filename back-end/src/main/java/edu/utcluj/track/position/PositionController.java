package edu.utcluj.track.position;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

/**
 * @author radu.miron
 * @since 18.10.2016
 */
@RestController
@RequestMapping(value = "/position")
public class PositionController {
	@Autowired
	private PositionService positionService;

	@PostMapping
	public Position save(@RequestBody Position position) {
		return this.positionService.savePosition(position);
	}

	@GetMapping
	public List<Position> find(@RequestParam(name = "terminal", required = true) String terminalId) {
		return this.positionService.findAll(terminalId);
	}

	@DeleteMapping
	public ResponseEntity<?> delete(@RequestParam(name = "terminal", required = true) String terminalId) {
		try {
			this.positionService.delete(terminalId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable(name = "id", required = true) Long id,
			@RequestParam(name = "latitude", required = true) String latitude,
			@RequestParam(name = "longitude", required = true) String longitude) {
		this.positionService.update(id, latitude, longitude);
	}
}
