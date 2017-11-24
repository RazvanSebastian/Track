package edu.utcluj.track.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.utcluj.track.model.Position;

@Repository
public interface IPositionRepository extends JpaRepository<Position, Long>{
	
}
