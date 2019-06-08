package com.example.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Optional<User> findByEmail(String email) {
		return this.userRepository.findByEmail(email);
	}

	@Override
	public User register(User u) {
		return this.userRepository.save(u);
	}

	@Override
	public Optional<User> findByUsername(String username) {
		return this.userRepository.findByUsername(username);
	}

}
