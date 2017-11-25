//package edu.utcluj.track.test;
//
//import static org.junit.Assert.*;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import edu.utcluj.track.exception.UserAlreadyExistException;
//import edu.utcluj.track.model.Role;
//import edu.utcluj.track.model.User;
//import edu.utcluj.track.model.UserRole;
//import edu.utcluj.track.repository.IRoleRepository;
//import edu.utcluj.track.repository.IUserRepository;
//import edu.utcluj.track.service.IUserService;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class UserTest {
//
//	@Autowired
//	private IUserRepository userRepository;
//
//	@Autowired
//	private IUserService userService;
//
//	@Autowired
//	private IRoleRepository roleRepository;
//
//	@Test
//	public void saveUser() throws UserAlreadyExistException {
//		roleRepository.deleteAll();
//		assertTrue(roleRepository.count() == 0);
//
//		roleRepository.save(new Role("ROLE_USER"));
//		roleRepository.save(new Role("ROLE_ADMIN"));
//
//		User user = new User();
//		user.setEmail("u@u.com");
//		user.setPassword("password");
//		userService.create(user, UserRole.USER);
//
//		User admin = new User();
//		admin.setEmail("a@a.com");
//		admin.setPassword("password");
//		userService.create(admin, UserRole.ADMIN);
//
//		assertTrue(userRepository.find(user.getEmail()) != null);
//		assertTrue(userRepository.find(admin.getEmail()) != null);
//	}
//
//}