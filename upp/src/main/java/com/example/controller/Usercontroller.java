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

import com.example.DTO.RegisterUserResponse;
import com.example.model.User;
import com.example.service.UserService;
//import com.example.test.Hashing;


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
			return new ResponseEntity<User>((User) null, HttpStatus.OK);
		}
		
		return new ResponseEntity<User>(user, HttpStatus.OK);		
	}
	
	@RequestMapping(
			value = "/register",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<RegisterUserResponse>register(@RequestBody User data){
		
		
		if(userService.findByUsername(data.getUsername()) != null){
			RegisterUserResponse response = new RegisterUserResponse(userService.findByUsername(data.getUsername()), "username");
			return new ResponseEntity<RegisterUserResponse>(response, HttpStatus.OK);
		}
		else if(userService.findByEmail(data.getEmail()) != null){
			RegisterUserResponse response = new RegisterUserResponse(userService.findByEmail(data.getEmail()), "email");
			return new ResponseEntity<RegisterUserResponse>(response, HttpStatus.OK);
		}
		
		String pw = data.getPassword();
		
		//String hashedPw = Hashing.hash(pw);
		String hashedPw = pw;

		User newUser = new User(data.getUsername(), data.getFirstname(), data.getLastname(), data.getCity(), data.getCountry(), data.getEmail(), hashedPw,
				"author", data.getScientificFieldList());
		
		this.userService.register(newUser);		
		RegisterUserResponse response = new RegisterUserResponse(newUser,"success");
		
		return new ResponseEntity<RegisterUserResponse>(response, HttpStatus.OK);
	}
}
