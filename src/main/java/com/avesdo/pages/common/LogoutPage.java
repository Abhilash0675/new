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
public class LogoutPage extends AbstractPage {
	
	private static final Logger log = LogManager.getLogger(LogoutPage.class);
	
	public LogoutPage(WebDriver driver, ConfigurationReader configurationReader){
		this.driver = driver;
		this.configurationReader = configurationReader;
		scriptFile = "common.xlsx";
		sheetName = "Logout";
		log.info("Logout page with keywords from " + scriptFile + " sheet " + sheetName);
	}
	
	public boolean performLogoutAction() throws Exception{
		log.info("Logout performLogoutAction ");
		return performOperation();
	}

}
