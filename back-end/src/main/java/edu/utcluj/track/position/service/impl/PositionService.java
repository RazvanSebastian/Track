package edu.utcluj.track.position.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.utcluj.track.position.model.Position;
import edu.utcluj.track.position.repository.PositionRepository;
import edu.utcluj.track.position.service.IPositionService;

/**
 * @author radu.miron
 * @since 18.10.2016
 */
@Component
public class PositionService implements IPositionService {
	@Autowired
	private PositionRepository positionRepository;

	@Override
	public Position savePosition(Position position) {
		position.setCreateTime(new Date(System.currentTimeMillis()));
		return positionRepository.save(position);
	}

	@Override
	public List<Position> findAll(String terminalId) {
		return this.positionRepository.findAll(terminalId);
	}

	@Override
	public void delete(String terminalId) throws Exception {
		if (this.positionRepository.findFirstByTerminalId(terminalId) == null)
			throw new Exception("Terminalul " + terminalId + " nu are inregistrari in baza de date!");
		this.positionRepository.delete(terminalId);
	}

	@Override
	public void update(Long id, String latitude, String longitude) {
		this.positionRepository.update(id, latitude, longitude);
	}
}
