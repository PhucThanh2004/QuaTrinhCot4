package vn.iotstar.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import vn.iotstar.entity.User;
import vn.iotstar.repository.UserRepository1;

@Service
public class UserService {
	private final UserRepository1 userRepository1;
	
	public UserService(UserRepository1 userRepository1) {
		this.userRepository1 = userRepository1;
	}
	
	public List<User> allUsers() {
		List<User> users = new ArrayList<>();
		
		userRepository1.findAll().forEach(users::add);
		
		return users;
	}
}
