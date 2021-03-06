package edu.utcluj.track.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import edu.utcluj.track.exception.DeviceNotFoundException;
import edu.utcluj.track.model.Device;
import edu.utcluj.track.model.Position;
import edu.utcluj.track.repository.IDeviceRepository;
import edu.utcluj.track.repository.IPositionRepository;
import edu.utcluj.track.service.IPositionService;

@Transactional
@Component
public class PositionService implements IPositionService {

	@Autowired
	private IPositionRepository positionRepository;

	@Autowired
	private IDeviceRepository deviceRepository;

	@Override
	public void save(Position newPosition, String token) throws DeviceNotFoundException {
		if (newPosition.getLatitude() == null || newPosition.getLongitude() == null)
			throw new NullPointerException("Latitude and/or longitude are null !");
		final Position position = positionRepository.save(newPosition);

		Device device = deviceRepository.find(token);
		if (device == null)
			throw new DeviceNotFoundException();

		device.getPositions().add(position);
		deviceRepository.save(device);
	}

	@Override
	public List<Position> findAll(String token, Date startDate, Date endDate) throws DeviceNotFoundException {
		if (startDate == null || endDate == null)
			throw new NullPointerException("At leat one date is null !");

		if (deviceRepository.find(token) == null)
			throw new DeviceNotFoundException();

		final Device device = deviceRepository.findAllDevicePosition(token, startDate, endDate);
		if(device == null)
			return new ArrayList<>();
		return device.getPositions();
	}
}
