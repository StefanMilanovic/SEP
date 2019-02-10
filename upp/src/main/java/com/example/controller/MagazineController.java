package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.KoncentratorData;
import com.example.model.CurrentUser;
import com.example.model.Magazine;
import com.example.model.User;
import com.example.service.MagazineService;
import com.example.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/magazine")
public class MagazineController {
	
	@Autowired
	private MagazineService magazineService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(
            value = "/getAllMagazines",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
	public ResponseEntity<List<Magazine>> getAllMagazines(){
		
		List<Magazine> magazines = magazineService.findAll();
		
		return new ResponseEntity<List<Magazine>>(magazines, HttpStatus.OK);
	}
	
	@RequestMapping(
			value="/createKoncentratorData",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<KoncentratorData> createKoncentratorData(@RequestBody double price){
				
		KoncentratorData newData = new KoncentratorData(price,"2111111212121", "1");
		
		return new ResponseEntity<KoncentratorData>(newData, HttpStatus.OK);
	}
	
	@RequestMapping(
			value="/allowUser",
			method = RequestMethod.POST	,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<?> allowUser(@ModelAttribute("currentUser") CurrentUser currentUser, @RequestBody String magId){
		
		Magazine mag = magazineService.findOne(Long.parseLong(magId));
		User loggedUser = currentUser.getUser();
		
		mag.getAllowedUsers().add(loggedUser);
		loggedUser.getAllowedMagazines().add(mag);
		
		magazineService.save(mag);
		userService.register(loggedUser);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}	
	

}
