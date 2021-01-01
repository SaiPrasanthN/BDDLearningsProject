package com.learnings.utils;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.testng.ITestContext;

public class EmailUtils {
	public void sendEmail(ITestContext context) throws EmailException {
		MultiPartEmail email=new MultiPartEmail();
		email.setAuthentication("saiprasanth257@gmail.com","");
		email.setHostName("smtp.gmail.com");
		email.setStartTLSEnabled(true);
		email.setSmtpPort(587);
		email.setFrom("saiprasanth257@gmail.com","Individual");
		email.setSubject("Results for Project");

		email.addTo("saiprasanth257@gmail.com");
		email.setMsg("");
		EmailAttachment emailAttachment=new EmailAttachment();
		emailAttachment.setPath(System.getProperty("user.dir")+"\\test-output\\ExtentReport.html");
		email.attach(emailAttachment);
		email.send();
			}

}
