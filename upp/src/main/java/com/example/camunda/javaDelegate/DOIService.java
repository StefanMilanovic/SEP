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
//MailTimeReviwer
@Service
@Transactional
public class DOIService implements JavaDelegate {
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
		System.out.println("\n  DOI is set...");
		System.out.println("Aceppted Science Paper");
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("camundaMailTester@gmail.com");
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("UPP Aceppted Science Paper ");


		String msg = "Aceppted Science Paper";

		mail.setText(msg);
		javaMailSender.send(mail);

	}

}
