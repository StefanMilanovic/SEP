package com.example.camunda.javaDelegate;

import com.example.model.SciencePaper;
import com.example.service.SciencePaperService;
import com.example.service.StorageService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Service
@Transactional
public class ApprovedSciencePaperService implements JavaDelegate {
	//DiscardSciencePaperService

	@Autowired
	SciencePaperService sciencePaperService;

	@Autowired
	StorageService storageService;

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private Environment env;



	@Override
	public void execute(DelegateExecution execution) throws Exception {
		@SuppressWarnings("unchecked")
		HashMap<String, Object> sciencePaperData = (HashMap<String, Object>) execution.getVariable("sciencePaperData");
		//NEMA ULOGU ZA SADA !!!
		System.out.println("\n ApprovedSciencePaperService...");
		String id = sciencePaperData.get("sciencePaperId").toString();
		SciencePaper paper = sciencePaperService.findById(Long.parseLong(id));
		//postaviti edeitroa ako treba

		System.out.println("Slanje mejla notifikacija recenzenta o dodeljenom radu");
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("camundaMailTester@gmail.com");
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("UPP Aceppted and Reviewer notification ");


		String msg = "Aceppted and Reviewer notification about assigned science paper";

		mail.setText(msg);
		javaMailSender.send(mail);

	}

}
