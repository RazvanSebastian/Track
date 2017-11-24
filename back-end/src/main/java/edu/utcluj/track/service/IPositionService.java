package edu.utcluj.track.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.utcluj.track.exception.DeviceNotFoundException;
import edu.utcluj.track.model.Position;

@Service
public interface IPositionService {
	
	/**
	 * Store a new position received from android client and is assigned to the device using his unique token
	 * @param newPosition
	 * @param token
	 * @throws DeviceNotFoundException
	 */
	public void save(Position newPosition,String token) throws DeviceNotFoundException;
	
	/**
	 * Receive all positions between two dates from an android token using his token
	 * @param token
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws DeviceNotFoundException
	 */
	public List<Position> findAll(String token,Date startDate,Date endDate ) throws DeviceNotFoundException;
	
}
