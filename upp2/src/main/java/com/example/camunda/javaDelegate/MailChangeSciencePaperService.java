package com.example.camunda.javaDelegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MailChangeSciencePaperService implements JavaDelegate {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private Environment env;
	

	@Async
	@Override
	public void execute(DelegateExecution execution) throws Exception {


		System.out.println("Slanje mejla cekanje izmene rada");
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("camundaMailTester@gmail.com");
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("UPP Bad formatted science paper waitnig for change  ");


		String msg = "Bad formatted science paper waitnig for change";
		
		mail.setText(msg);
		javaMailSender.send(mail);
	}

}
