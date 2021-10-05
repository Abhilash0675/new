/**
 * 
 */
package com.avesdo.pages.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.avesdo.pages.AbstractPage;
import com.avesdo.utils.ConfigurationReader;

/**
 * @author Anil
 *
 */
public class CreateContact extends AbstractPage {
	
	private static final Logger log = LogManager.getLogger(CreateContact.class);
	
	public CreateContact(WebDriver driver, ConfigurationReader configurationReader){
		this.driver = driver;
		this.configurationReader = configurationReader;
		scriptFile = "Leads.xlsx";
		sheetName = "Create Contact";
		log.info("Create Contact page with keywords from " + scriptFile + " sheet " + sheetName);
	}
	
	public boolean performCreateContact() throws Exception{
		log.info("Perform Create Contact Action ");
		return performOperation();
	}

}
