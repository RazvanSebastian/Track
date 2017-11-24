package edu.utcluj.track.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.utcluj.track.exception.DeviceNotFoundException;
import edu.utcluj.track.model.Position;
import edu.utcluj.track.service.IPositionService;

@RestController
@RequestMapping("/position")
public class PositionController {

	@Autowired
	private IPositionService positionService;

	@PostMapping
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<?> save(@RequestHeader(name = "token") String token, @RequestBody Position newPosition) {
		try {
			positionService.save(newPosition, token);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (DeviceNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<?> findAll(@RequestHeader(name = "token") String token,
			@RequestParam(name = "startdate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
			@RequestParam(name = "enddate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
		try {
			return new ResponseEntity<>(positionService.findAll(token, startDate, endDate), HttpStatus.OK);
		} catch (DeviceNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}
