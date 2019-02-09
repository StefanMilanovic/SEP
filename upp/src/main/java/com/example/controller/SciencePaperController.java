package com.example.controller;

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
		return null;
	}

}
