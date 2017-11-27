package edu.utcluj.track.service;

import org.springframework.stereotype.Service;

import edu.utcluj.track.exception.UserAlreadyExistException;
import edu.utcluj.track.model.User;
import edu.utcluj.track.model.UserRole;

@Service
public interface IUserService {

	/**
	 * Create new user
	 * 
	 * @param user
	 * @param role
	 * @return user created with set id
	 * @throws UserAlreadyExistException
	 */
	public User create(User user, UserRole role) throws UserAlreadyExistException;

}