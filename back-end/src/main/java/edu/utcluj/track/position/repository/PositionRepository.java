package edu.utcluj.track.position.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import edu.utcluj.track.position.model.Position;

/**
 * @author radu.miron
 * @since 18.10.2016
 */

@Transactional
public interface PositionRepository extends JpaRepository<Position, Long> {

	Position findFirstByTerminalId(String terminalId);

	@Query("select position from Position position where position.terminalId = :terminalId")
	List<Position> findAll(@Param("terminalId") String terminalId);

	@Modifying
	@Query("delete from Position where terminalId = :terminalId")
	void delete(@Param("terminalId") String terminalId);

	@Modifying
	@Query("update Position position set position.latitude = :latitude, position.longitude = :longitude where id = :id")
	void update(@Param("id") Long id, @Param("latitude") String latitude, @Param("longitude") String longitude);
}
