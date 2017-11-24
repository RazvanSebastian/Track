package edu.utcluj.track.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.utcluj.track.model.Device;
import edu.utcluj.track.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
	
	@Query("SELECT user FROM User user WHERE user.email = :email")
	User find(@Param("email") String username);
	
	@Query("SELECT user FROM User user INNER JOIN user.devices device WHERE user.email =:email")
	List<Device> findAllUserDevices(@Param("email") String email);

}