package edu.utcluj.track.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.utcluj.track.model.Device;

@Repository
public interface IDeviceRepository extends JpaRepository<Device, Long>{
	
	@Query("SELECT device FROM Device device WHERE device.token =:token")
	public Device find(@Param("token") String token);
	
}
