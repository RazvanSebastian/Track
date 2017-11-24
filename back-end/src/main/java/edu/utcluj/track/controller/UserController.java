package edu.utcluj.track.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.utcluj.track.exception.UserAlreadyExistException;
import edu.utcluj.track.model.User;
import edu.utcluj.track.model.UserRole;
import edu.utcluj.track.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

	@PostMapping("/user-register")
	@PreAuthorize("permitAll()")
	public ResponseEntity<?> createUser(@RequestBody User user) {
		try {
			userService.create(user, UserRole.USER);
			return new ResponseEntity<>("User succesfully register!", HttpStatus.CREATED);
		} catch (UserAlreadyExistException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("admin-create")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> createAdmin(@RequestBody User user) {
		try {
			userService.create(user, UserRole.ADMIN);
			return new ResponseEntity<>("User succesfully register!", HttpStatus.CREATED);
		} catch (UserAlreadyExistException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
