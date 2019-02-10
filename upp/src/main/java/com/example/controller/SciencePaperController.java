package com.example.controller;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/paper")
public class SciencePaperController {
	
	@RequestMapping(
			value = "/download",
			method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<?>downloadPaper(@RequestBody String paperName){
		System.out.println(paperName);
		Path resourceDirectory = Paths.get("src","main","resources");
		System.out.println(resourceDirectory);
		return null;
	}

}
