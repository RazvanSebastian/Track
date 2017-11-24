package edu.utcluj.track.position.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.utcluj.track.position.model.Position;

@Service
public interface IPositionService {

	public Position savePosition(Position position);

	public List<Position> findAll(String terminalId);
	
	public void delete(String terminalId) throws Exception;
	
	public void update(Long id, String latitude, String longitude);
}
