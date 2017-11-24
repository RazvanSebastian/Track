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

import edu.utcluj.track.dao.NewDevice;
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

	@PostMapping
	@PreAuthorize("permitAll()")
	public ResponseEntity<?> create(@RequestBody NewDevice newDevice) {
		try {
			return new ResponseEntity<>(this.deviceService.create(newDevice), HttpStatus.CREATED);
		} catch (DeviceAlreadyRegisteredException | UserNotFoundException | NoMatchingException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
		
	@PostMapping("/authentication")
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<?> find(@RequestBody NewDevice device) {
		try {
			return new ResponseEntity<>(deviceService.find(device), HttpStatus.OK);
		} catch (DeviceNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

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
