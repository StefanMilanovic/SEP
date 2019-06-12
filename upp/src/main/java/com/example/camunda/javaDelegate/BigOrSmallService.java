package com.example.camunda.javaDelegate;

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
public class BigOrSmallService implements JavaDelegate {
	//DiscardSciencePaperService
//EditorFinalDecision

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private Environment env;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		@SuppressWarnings("unchecked")
		HashMap<String, Object> sciencePaperData = (HashMap<String, Object>) execution.getVariable("sciencePaperData");
		System.out.println("\n CheckTopicSciencePaperService");

		String bigChange = sciencePaperData.get("bigChange").toString();
		String smallChange = sciencePaperData.get("smallChange").toString();


		System.out.println("Slanje mejla MailSmallOrBigChange");
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("camundaMailTester@gmail.com");
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("UPP Small or big change  ");


		String msg = "Small or big change";

		mail.setText(msg);
		javaMailSender.send(mail);

		if(bigChange.equals("yes")) {
			execution.setVariable("bigChange", true);
			System.out.println("\n Rad je za veliku izmenu");
		} else {
			execution.setVariable("bigChange", false);
			System.out.println("\nRad je za  malu izmenu");
		}
	}

}
