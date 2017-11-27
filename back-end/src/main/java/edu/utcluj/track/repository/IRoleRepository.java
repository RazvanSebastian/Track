package edu.utcluj.track.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.utcluj.track.model.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long>{
	
	@Query("SELECT r FROM Role r WHERE r.role =:role")
	public Role findRole(@Param("role") String role);
}