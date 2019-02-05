package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.LogUserDTO;
import com.example.model.User;
import com.example.service.UserService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class Usercontroller {

	@Autowired
	private UserService userService;
	
	@RequestMapping(
            value = "/login/{email}/{password}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
	public ResponseEntity<User> login(@PathVariable String email, @PathVariable String password) {
		
		System.out.println("Entered into login controller.");				
		User user = this.userService.findByEmail(email);
		
		if(user == null || !user.getPassword().equals(password)){
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
		
		return new ResponseEntity<User>(user, HttpStatus.OK);		
	}
	
	@RequestMapping(
			value = "/register",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<User>register(@RequestBody User data){
		this.userService.register(data);
		
		return new ResponseEntity<User>(data, HttpStatus.OK);
	}
}
