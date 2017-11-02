package edu.utcluj.track.test;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.utcluj.track.position.Position;
import edu.utcluj.track.position.PositionRepository;
import edu.utcluj.track.position.PositionService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private PositionRepository positionRepository;

	@Autowired
	private PositionService positionService;

	@Test
	public void crud() {
		positionRepository.deleteAll();
		assertTrue(positionRepository.findAll().isEmpty());

		// create positions
		final String terminal1 = "terminal1";
		final long time = System.currentTimeMillis();

		positionService.savePosition(new Position(terminal1, new Date(time), "40.5", "20.4"));
		positionService.savePosition(new Position(terminal1, new Date(time + 1000), "21.322", "33.56"));
		positionService.savePosition(new Position(terminal1, new Date(time + 2000), "18.5", "76.4"));

		assertTrue(positionService.findAll(terminal1).size() == 3);

		// create positions with another terminal
		final String terminal2 = "terminal2";

		positionService.savePosition(new Position(terminal2, new Date(time), "38.5", "22.4"));
		positionService.savePosition(new Position(terminal2, new Date(time + 1000), "22.267", "15.11"));
		positionService.savePosition(new Position(terminal2, new Date(time + 2000), "21.56", "65.123"));

		assertTrue(positionService.findAll(terminal2).size() == 3);
	}

}
