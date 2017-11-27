package edu.utcluj.track.exception;

public class DeviceAlreadyRegisteredException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public DeviceAlreadyRegisteredException() {
		super("This device is already registered! Please login with your username and password to access account!");
	}
}
