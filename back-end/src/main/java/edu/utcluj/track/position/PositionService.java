package edu.utcluj.track.position;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author radu.miron
 * @since 18.10.2016
 */
@Service
public class PositionService {
	@Autowired
	private PositionRepository positionRepository;

	public Position savePosition(Position position) {
		position.setCreateTime(new Date(System.currentTimeMillis()));
		return positionRepository.save(position);
	}

	public List<Position> findAll(String terminalId) {
		return this.positionRepository.findAll(terminalId);
	}

	public void delete(String terminalId) throws Exception {
		if (this.positionRepository.findFirstByTerminalId(terminalId) == null)
			throw new Exception("Terminalul " + terminalId + " nu are inregistrari in baza de date!");
		this.positionRepository.delete(terminalId);
	}

	public void update(Long id, String latitude, String longitude) {
		this.positionRepository.update(id, latitude, longitude);
	}
}
