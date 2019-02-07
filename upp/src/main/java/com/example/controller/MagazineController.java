package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Magazine;
import com.example.service.MagazineService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/magazine")
public class MagazineController {
	
	@Autowired
	private MagazineService magazineService;
	
	@RequestMapping(
            value = "/getAllMagazines",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
	public ResponseEntity<List<Magazine>> getAllMagazines(){
		
		List<Magazine> magazines = magazineService.findAll();
		
		return new ResponseEntity<List<Magazine>>(magazines, HttpStatus.OK);
	}

}
