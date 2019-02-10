package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.SciencePaperDownload;
import com.example.service.SciencePaperDownloadService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/paper")
public class SciencePaperController {
	
	@Autowired
	SciencePaperDownloadService sciencePaperService;

	@RequestMapping(
			value = "/download",
			method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<?>downloadPaper(@RequestBody String paperName){
		SciencePaperDownload paper = sciencePaperService.findByName(paperName);
		
		if(paper != null){
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + paper.getName() + "\"")
					.body(paper.getPic());
		}		
		return ResponseEntity.status(404).body(null);		
	}

}
