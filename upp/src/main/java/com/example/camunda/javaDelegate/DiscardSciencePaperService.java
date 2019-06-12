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
public class DiscardSciencePaperService implements JavaDelegate {
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
		System.out.println("\n Brisanje SERVICE");
		String id = sciencePaperData.get("sciencePaperId").toString();

		SciencePaper paper = sciencePaperService.findById(Long.parseLong(id));
		this.sciencePaperService.delete(paper.getId());
		this.storageService.delete(paper.getLocationOnDrive());

		System.out.println("Slanje mejla za odbijanje");
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("camundaMailTester@gmail.com");
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("UPP Discard science paper topic ");


		String msg = "Discard science paper topic";

		mail.setText(msg);
		javaMailSender.send(mail);
	}

}
