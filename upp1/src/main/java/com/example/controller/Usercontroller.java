package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.RegisterUserResponse;
import com.example.model.CurrentUser;
import com.example.model.User;
import com.example.service.UserService;
import com.example.test.Hashing;
//import com.example.test.Hashing;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class Usercontroller {

	@Autowired
	private UserService userService;
	
	@RequestMapping(
            value = "/login",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
	public ResponseEntity<User> login(@ModelAttribute("currentUser") CurrentUser currentUser) {
		
//		System.out.println("Entered into login controller.");				
//		User user = this.userService.findByEmail(email);
//		
//
//		String hashCheck = Hashing.hash(password);			// provera
//		System.out.println(hashCheck);
//		
//		if(user == null || !user.getPassword().equals(Hashing.hash(password))){
//			return new ResponseEntity<>((User) null, HttpStatus.OK);
//		}
//		
//		return new ResponseEntity<User>(user, HttpStatus.OK);
		System.out.println("treba da vrati:" +currentUser);
		
		if(currentUser == null){
			return null;
		}	
		
		return new ResponseEntity<User>(currentUser.getUser(), HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "/register",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<RegisterUserResponse>register(@RequestBody User data){
		
		Optional<User> testUsername = userService.findByUsername(data.getUsername());
		Optional<User> testEmail = userService.findByEmail(data.getEmail());
		
		
		if(testUsername.isPresent()){
			RegisterUserResponse response = new RegisterUserResponse(userService.findByUsername(data.getUsername()).get(), "username");
			return new ResponseEntity<RegisterUserResponse>(response, HttpStatus.OK);
		}
		else if(testEmail.isPresent()){
			RegisterUserResponse response = new RegisterUserResponse(userService.findByEmail(data.getEmail()).get(), "email");
			return new ResponseEntity<RegisterUserResponse>(response, HttpStatus.OK);
		}
				

//		User newUser = new User(data.getUsername(), data.getFirstname(), data.getLastname(), data.getCity(), data.getCountry(), data.getEmail(), hashedPw,
//				"author", data.getScientificFieldList());
		
		String password = new BCryptPasswordEncoder().encode(data.getPassword());
		
		User newUser = new User(data.getUsername(), data.getFirstname(), data.getLastname(), data.getCity(), data.getCountry(), data.getEmail(), password, "USER");
		
		this.userService.register(newUser);		
		RegisterUserResponse response = new RegisterUserResponse(newUser,"success");
		
		return new ResponseEntity<RegisterUserResponse>(response, HttpStatus.OK);
	}
}
