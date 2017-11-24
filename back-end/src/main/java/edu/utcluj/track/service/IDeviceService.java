package edu.utcluj.track.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.utcluj.track.dao.NewDevice;
import edu.utcluj.track.exception.DeviceAlreadyRegisteredException;
import edu.utcluj.track.exception.DeviceNotFoundException;
import edu.utcluj.track.exception.NoMatchingException;
import edu.utcluj.track.exception.UserNotFoundException;
import edu.utcluj.track.model.Device;

@Service
public interface IDeviceService {

	public String create(NewDevice newDevice) throws DeviceAlreadyRegisteredException, UserNotFoundException, NoMatchingException;
	
	public Device find(String token) throws DeviceNotFoundException;

	public List<Device> findAll(String username) throws UserNotFoundException;
}
