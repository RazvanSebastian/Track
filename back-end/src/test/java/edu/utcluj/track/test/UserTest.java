package edu.utcluj.track.test;

import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.utcluj.track.dto.DeviceDto;
import edu.utcluj.track.exception.DeviceAlreadyRegisteredException;
import edu.utcluj.track.exception.DeviceNotFoundException;
import edu.utcluj.track.exception.NoMatchingException;
import edu.utcluj.track.exception.UserAlreadyExistException;
import edu.utcluj.track.exception.UserNotFoundException;
import edu.utcluj.track.model.Position;
import edu.utcluj.track.model.Role;
import edu.utcluj.track.model.User;
import edu.utcluj.track.model.UserRole;
import edu.utcluj.track.repository.IRoleRepository;
import edu.utcluj.track.repository.IUserRepository;
import edu.utcluj.track.service.IDeviceService;
import edu.utcluj.track.service.IPositionService;
import edu.utcluj.track.service.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private IUserService userService;

	@Autowired
	private IRoleRepository roleRepository;

	@Autowired
	private IDeviceService deviceService;

	@Autowired
	private IPositionService positionService;

	@Test
	public void saveUser() throws UserAlreadyExistException, DeviceAlreadyRegisteredException, UserNotFoundException,
			NoMatchingException, DeviceNotFoundException {
		roleRepository.deleteAll();
		assertTrue(roleRepository.count() == 0);

		roleRepository.save(new Role("ROLE_USER"));
		roleRepository.save(new Role("ROLE_ADMIN"));

		User user = new User();
		user.setEmail("u@u.com");
		user.setPassword("password");
		userService.create(user, UserRole.USER);

		User admin = new User();
		admin.setEmail("a@a.com");
		admin.setPassword("password");
		userService.create(admin, UserRole.ADMIN);

		assertTrue(userRepository.find(user.getEmail()) != null);
		assertTrue(userRepository.find(admin.getEmail()) != null);

		String token1 = UUID.randomUUID().toString();

		deviceService.create(new DeviceDto("u@u.com", "password", token1, "device_test_1"));

		positionService.save(new Position(new Date(System.currentTimeMillis()), "46.7704", "23.5231"), token1);
		positionService.save(new Position(new Date(System.currentTimeMillis()), "46.7332", "23.3421"), token1);
		positionService.save(new Position(new Date(System.currentTimeMillis()), "46.7232", "23.3121"), token1);
		positionService.save(new Position(new Date(System.currentTimeMillis()), "46.7404", "23.4231"), token1);
		positionService.save(new Position(new Date(System.currentTimeMillis()), "46.7310", "23.3131"), token1);
		positionService.save(new Position(new Date(System.currentTimeMillis()), "46.7231", "23.4021"), token1);
	}

}