package com.example.service;

import com.example.model.User;

public interface UserService {
	User findByEmail(String email);
	User register(User u);
	
}
