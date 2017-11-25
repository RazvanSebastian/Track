package edu.utcluj.track.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.utcluj.track.dao.DeviceDao;
import edu.utcluj.track.exception.DeviceAlreadyRegisteredException;
import edu.utcluj.track.exception.DeviceNotFoundException;
import edu.utcluj.track.exception.NoMatchingException;
import edu.utcluj.track.exception.UserNotFoundException;
import edu.utcluj.track.service.IDeviceService;

@RestController
@RequestMapping("/device")
public class DeviceController {

	@Autowired
	private IDeviceService deviceService;

	//
	// Android client
	//
	@PostMapping
	@PreAuthorize("permitAll()")
	public ResponseEntity<?> create(@RequestBody DeviceDao deviceDao) {
		try {
			this.deviceService.create(deviceDao);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (DeviceAlreadyRegisteredException | UserNotFoundException | NoMatchingException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/authentication")
	public ResponseEntity<?> find(@RequestBody DeviceDao deviceDao) {
		try {
			return new ResponseEntity<>(deviceService.find(deviceDao).getToken(), HttpStatus.OK);
		} catch (DeviceNotFoundException | NoMatchingException | UserNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping
	public ResponseEntity<?> checkToken(@RequestHeader("token") String token) {
		return deviceService.find(token) ? new ResponseEntity<>(HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}

	//
	// Browser client
	//
	@GetMapping("/all")
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<?> findAll(@RequestHeader(name = "username") String username) {
		try {
			return new ResponseEntity<>(deviceService.findAll(username), HttpStatus.OK);
		} catch (UserNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}
