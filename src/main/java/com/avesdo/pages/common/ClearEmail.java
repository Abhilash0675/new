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
public class ClearEmail extends AbstractPage {
	
	private static final Logger log = LogManager.getLogger(ClearEmail.class);
	
	public ClearEmail(WebDriver driver, ConfigurationReader configurationReader){
		this.driver = driver;
		this.configurationReader = configurationReader;
		scriptFile = "common.xlsx";
		sheetName = "Clear Inbox";
		log.info("ClearEmail page with keywords from " + scriptFile + " sheet " + sheetName);
	}
	
	public boolean performClearEmailAction() throws Exception{
		log.info("ClearEmail performClearEmailAction ");
		return performOperation();
	}

}
