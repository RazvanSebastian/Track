package edu.utcluj.track.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.utcluj.track.dao.DeviceDao;
import edu.utcluj.track.exception.DeviceAlreadyRegisteredException;
import edu.utcluj.track.exception.DeviceNotFoundException;
import edu.utcluj.track.exception.NoMatchingException;
import edu.utcluj.track.exception.UserNotFoundException;
import edu.utcluj.track.model.Device;

@Service
public interface IDeviceService {

	/**
	 * Save a new device in database if the device id is not registered yet. Also
	 * it's verifying if the email and password are matching; if not it means that
	 * the user is not registered and the application will register him with email
	 * and password and also will store the device
	 * 
	 * @throws UserNotFoundException
	 * @throws NoMatchingException
	 * @throws DeviceAlreadyRegisteredException
	 */
	public void create(DeviceDao deviceDao)
			throws DeviceAlreadyRegisteredException, UserNotFoundException, NoMatchingException;

	/**
	 * Used for login on android device. This method will check if the user is
	 * registered and also if the device is already or not registered. 
	 * 
	 * @note1 An android device can be register only one time for only one user!
	 * @note2 One user can have multiple devices associate with his account!
	 * 
	 * @param newDevice
	 * 
	 * @return device
	 * 
	 * @throws DeviceNotFoundException
	 * @throws NoMatchingException
	 * @throws UserNotFoundException
	 */
	public Device find(DeviceDao newDevice) throws DeviceNotFoundException, NoMatchingException, UserNotFoundException;

	/**
	 * Find all devices associated with a user account
	 * 
	 * @param username
	 * 
	 * @return List of devices
	 * 
	 * @throws UserNotFoundException
	 */
	public List<Device> findAll(String username) throws UserNotFoundException;
	
	/**
	 * @param token
	 * @return true if the device with @token is registered 
	 */
	public boolean find(String token);
}
