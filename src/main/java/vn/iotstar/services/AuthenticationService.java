package vn.iotstar.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import vn.iotstar.entity.User;
import vn.iotstar.models.LoginUserModel;
import vn.iotstar.models.RegisterUserModel;
import vn.iotstar.repository.UserRepository1;

@Service
public class AuthenticationService {
	private final UserRepository1 userRepository1;
	
	private final PasswordEncoder passwordEncoder;
	
	private final AuthenticationManager authenticationManager;
	
	public AuthenticationService(
			UserRepository1 userRepository1,
			AuthenticationManager authenticationManager,
			PasswordEncoder passwordEncoder
			) {
		this.authenticationManager = authenticationManager;
		this.userRepository1 = userRepository1;
		this.passwordEncoder = passwordEncoder;
	}
	
	public User signup(RegisterUserModel input) {
		User user = new User();
		user.setFullname(input.getFullname());
		user.setEmail(input.getEmail());
		user.setPassword(passwordEncoder.encode(input.getPassword()));
		
		return userRepository1.save(user);
	}
	
	public User Authenticate(LoginUserModel input) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						input.getEmail(), 
						input.getPassword()));
		return userRepository1.findByEmail(input.getEmail()).orElseThrow();
	}
}
