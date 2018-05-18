package edu.utcluj.track.service.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import edu.utcluj.track.dto.DeviceDto;
import edu.utcluj.track.exception.DeviceAlreadyRegisteredException;
import edu.utcluj.track.exception.DeviceNotFoundException;
import edu.utcluj.track.exception.NoMatchingException;
import edu.utcluj.track.exception.UserNotFoundException;
import edu.utcluj.track.model.Device;
import edu.utcluj.track.model.User;
import edu.utcluj.track.pojo.DevicePojo;
import edu.utcluj.track.repository.IDeviceRepository;
import edu.utcluj.track.repository.IUserRepository;
import edu.utcluj.track.service.IDeviceService;
import springfox.documentation.swagger2.mappers.ModelMapper;

@Transactional
@Component
public class DeviceService implements IDeviceService {

	@Autowired
	private IDeviceRepository deviceRepository;

	@Autowired
	private IUserRepository userRepository;

	@Override
	public void create(DeviceDto deviceDao)
			throws DeviceAlreadyRegisteredException, UserNotFoundException, NoMatchingException {
		// check if the user is registered
		User user = userRepository.find(deviceDao.getEmail());
		if (user == null)
			throw new UserNotFoundException();

		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		if (!bCryptPasswordEncoder.matches(deviceDao.getPassword(), user.getPassword()))
			throw new NoMatchingException("The email or password are not matching!");

		// check if the device is registered
		if (deviceRepository.find(deviceDao.getDeviceToken()) != null)
			throw new DeviceAlreadyRegisteredException();

		// We have registered the device
		final Device device = deviceRepository.save(
				new Device(deviceDao.getDeviceToken(), deviceDao.getName(), new Date(System.currentTimeMillis())));
		// Assigned the device to user and update
		user.getDevices().add(device);
		userRepository.save(user);
	}

	@Override
	public Device find(DeviceDto newDevice) throws DeviceNotFoundException, NoMatchingException, UserNotFoundException {
		final User user = userRepository.find(newDevice.getEmail());
		if (user == null)
			throw new UserNotFoundException();

		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		if (!bCryptPasswordEncoder.matches(newDevice.getPassword(), user.getPassword()))
			throw new NoMatchingException("The email or password are not matching!");

		if (user.getDevices().isEmpty())
			throw new DeviceNotFoundException();

		Iterator<Device> iterator = user.getDevices().iterator();
		Device device = null;
		while (iterator.hasNext()) {
			device = iterator.next();
			if (device.getToken().equals(newDevice.getDeviceToken()))
				return device;
		}
		throw new DeviceNotFoundException();
	}

	@Override
	public List<DevicePojo> findAll(String username) throws UserNotFoundException {
		final User user = userRepository.find(username);
		if (user == null)
			throw new UserNotFoundException();
		return user.getDevices().stream().collect(Collectors.toList()) // get list of devices
				.stream().map(p -> new DevicePojo(p.getToken(), p.getName(), p.getRegistrationDate()))
				.collect(Collectors.toList());// get only the device without position
	}

	@Override
	public boolean find(String token) {
		return deviceRepository.find(token) != null ? true : false;
	}

	@Override
	public void delete(String email, String token) throws DeviceNotFoundException, UserNotFoundException {
		final Device device = deviceRepository.find(token);
		if (device == null)
			throw new DeviceNotFoundException();

		User user = userRepository.find(email);
		if (user == null)
			throw new UserNotFoundException();

		Set<Device> devices = user.getDevices();
		for (Device d : devices) {
			if (d.getToken().equals(token)) {
				devices.remove(d);
				break;
			}
		}
		user.setDevices(devices);
		userRepository.save(user);

		deviceRepository.delete(device);
	}

}
