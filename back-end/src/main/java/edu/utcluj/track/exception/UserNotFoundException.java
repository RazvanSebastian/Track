package edu.utcluj.track.exception;

public class UserNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserNotFoundException() {
		super("The user was not found!");
	}
	
}
