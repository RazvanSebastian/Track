package edu.utcluj.track.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.utcluj.track.model.Device;

@Repository
public interface IDeviceRepository extends JpaRepository<Device, Long>{
	
	@Query("SELECT device FROM Device device WHERE device.token =:token")
	public Device find(@Param("token") String token);
	
	@Query("SELECT device FROM Device device INNER JOIN device.positions position "
			+ "WHERE device.token =:token AND position.createTime BETWEEN :startdate and :enddate")
	public Device findAllDevicePosition(@Param("token") String token,
										@Param("startdate") Date startDate, 
										@Param("enddate") Date endDate);
	
	
}
