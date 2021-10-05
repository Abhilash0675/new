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
public class RealtorPage extends AbstractPage {
	
	private static final Logger log = LogManager.getLogger(RealtorPage.class);
	
	public RealtorPage(WebDriver driver, ConfigurationReader configurationReader){
		this.driver = driver;
		this.configurationReader = configurationReader;
		scriptFile = "Contracts.xlsx";
		sheetName = "Add Existing Realtor";
		log.info("Realtor page with keywords from " + scriptFile + " sheet " + sheetName);
	}
	
	public boolean performRealtorAction() throws Exception{
		log.info("Realtor performAction ");
		return performOperation();
	}

}
