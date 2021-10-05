/**
 * 
 */
package com.avesdo.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Anil
 *
 */
public class EmailUtils {

	private static final Logger log = LogManager.getLogger(EmailUtils.class);
	
	private Properties mailConfigProperties;
	
	public EmailUtils() throws Exception{
		InputStream in = null;
		try{
			in =  this.getClass().getResourceAsStream("../../../setup.properties");
			mailConfigProperties = new Properties();
			mailConfigProperties.load(in);
		}catch(Exception e){
			throw e;
		}finally{
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}


	public void sendEmailWithAttachment() throws Exception {
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath(".\\Extent_Reports\\Avesdo_Extent_Report.html");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("Avesdo QA Report");
		attachment.setName("QA Report.html");
		
	
		// Create the email message
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName(mailConfigProperties.getProperty("smtphost"));
		// email.setSmtpPort(587);
		// email.setSslSmtpPort("587");

		email.setAuthenticator(new DefaultAuthenticator(mailConfigProperties.getProperty("smtpfrom"), mailConfigProperties.getProperty("smtppassword")));
		email.setSSLOnConnect(true);

		email.addTo(mailConfigProperties.getProperty("smtpto"), mailConfigProperties.getProperty("smtpto"));
		email.setFrom(mailConfigProperties.getProperty("smtpfrom"), mailConfigProperties.getProperty("smtpfrom"));
		email.setSubject("QA Report");
		email.setMsg("Here is the QA Report");

		// add the attachment
		email.attach(attachment);

		// send the email
		email.send();
		log.info("Email sent successfully....");
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		EmailUtils emailUtils = new EmailUtils();
		emailUtils.sendEmailWithAttachment();

	}

}
