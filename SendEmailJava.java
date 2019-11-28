package com.jbk;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import java.io.IOException;
import org.apache.commons.mail.EmailException;

public class SendEmailJava{
	public static void email() throws EmailException{

	
	Email email = new SimpleEmail();
	email.setHostName("smtp.email.com");
	email.setSmtpPort(465);
	// email.setAuthenticator(new DefaultAuthenticator("mamta@gmail.com", "destination23"));
	email.setSSLOnConnect(true);
	email.setFrom("deogadelikhita@gmail.com");
	email.setSubject("Selenium Test Report");
	email.setMsg("This is a test mail ... :-)");
	email.addTo("foo@bar.com");
	email.send();	
	
	
	
	
	
	
	
}
}
