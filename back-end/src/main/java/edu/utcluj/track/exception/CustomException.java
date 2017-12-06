package edu.utcluj.track.exception;

public class CustomException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CustomException(int status, String message) {
		this(message + '\n' + "Status code = " + status);
	}
}
