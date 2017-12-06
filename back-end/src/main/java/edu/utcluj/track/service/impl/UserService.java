package edu.utcluj.track.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import edu.utcluj.track.exception.UserAlreadyExistException;
import edu.utcluj.track.model.Role;
import edu.utcluj.track.model.User;
import edu.utcluj.track.model.UserRole;
import edu.utcluj.track.repository.IRoleRepository;
import edu.utcluj.track.repository.IUserRepository;
import edu.utcluj.track.service.IUserService;

@Transactional
@Component
public class UserService implements IUserService {

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private IRoleRepository roleRepository;

	@Override
	public User create(User user, UserRole role) throws UserAlreadyExistException {
		if (userRepository.find(user.getEmail()) != null)
			throw new UserAlreadyExistException(user.getEmail());
		// encrypt password
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		// set up user details
		user.setAccountNonLocked(true);
		user = userRepository.save(user);
		// add role to user
		Set<Role> roles = new HashSet<>();
		switch (role) {
		case USER:
			roles.add(roleRepository.findRole("ROLE_USER"));
			break;
		case ADMIN:
			roles.add(roleRepository.findRole("ROLE_ADMIN"));
			break;
		default:
			roles.add(roleRepository.findRole("ROLE_USER"));
			break;
		}
		// set up roles
		user.setRoles(roles);
		// store
		return userRepository.save(user);
	}

}