package edu.utcluj.track.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.bouncycastle.util.encoders.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import edu.utcluj.track.dao.NewDevice;
import edu.utcluj.track.exception.DeviceAlreadyRegisteredException;
import edu.utcluj.track.exception.DeviceNotFoundException;
import edu.utcluj.track.exception.NoMatchingException;
import edu.utcluj.track.exception.UserNotFoundException;
import edu.utcluj.track.model.Device;
import edu.utcluj.track.model.User;
import edu.utcluj.track.repository.IDeviceRepository;
import edu.utcluj.track.repository.IUserRepository;
import edu.utcluj.track.service.IDeviceService;

@Component
public class DeviceService implements IDeviceService{

	@Autowired
	private IDeviceRepository deviceRepository;
	
	@Autowired
	private IUserRepository userRepository;
	
	/**
	 * Generate device token using email password and android id; 
	 * the token is created by appending these strings and then encoded into base64
	 * 
	 * @param newDevice
	 * @return
	 */
	protected String generateDeviceToken(NewDevice newDevice) {
		StringBuilder builder = new StringBuilder();
		builder
			.append(newDevice.getEmail()).append('.')
			.append(newDevice.getDeviceId());
		System.out.println(builder.toString());
		String t = new String(Base64.encode(builder.toString().getBytes()));
		System.out.println(t);
		return t;
	}
	
	@Override
	public String create(NewDevice newDevice) throws DeviceAlreadyRegisteredException, UserNotFoundException, NoMatchingException {
		//check if the user is registered
		User user = userRepository.find(newDevice.getEmail());
		if (user == null)
			throw new UserNotFoundException();
		
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		if(!bCryptPasswordEncoder.matches(newDevice.getPassword(), user.getPassword()))
			throw new NoMatchingException("The email or password are not matching!");
		
		//check if the device is registered
		String token = generateDeviceToken(newDevice);
		if (deviceRepository.find(token) != null)
			throw new DeviceAlreadyRegisteredException();
		
		//We have registered the device
		final Device device = deviceRepository.save(new Device(token,new Date(System.currentTimeMillis())));
		//Assigned the device to user and update
		user.getDevices().add(device);
		userRepository.save(user);
		
		return device.getToken();
	}

	@Override
	public Device find(NewDevice newDevice) throws DeviceNotFoundException {
		final Device device = deviceRepository.find(generateDeviceToken(newDevice));
		if(device == null)
			throw new DeviceNotFoundException();
		return device;
	}

	@Override
	public List<Device> findAll(String username) throws UserNotFoundException {
		final User user = userRepository.find(username);
		if(user == null)
			throw new UserNotFoundException();
		return user.getDevices().stream().collect(Collectors.toList());
	}

}
