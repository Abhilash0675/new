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
public class LoginPage extends AbstractPage {
	
	private static final Logger log = LogManager.getLogger(LoginPage.class);
	
	public LoginPage(WebDriver driver, ConfigurationReader configurationReader){
		this.driver = driver;
		this.configurationReader = configurationReader;
		scriptFile = "common.xlsx";
		sheetName = "Login";
		log.info("Login page with keywords from " + scriptFile + " sheet " + sheetName);
	}
	
	public LoginPage(WebDriver driver, ConfigurationReader configurationReader, String scriptFile, String sheetName){
		this.driver = driver;
		this.configurationReader = configurationReader;
		this.scriptFile = scriptFile;
		this.sheetName = sheetName;
		log.info("Login page with keywords from " + scriptFile + " sheet " + sheetName);
	}
	
	public boolean performLoginAction() throws Exception{
		log.info("Login performLoginAction ");
		return performOperation();
	}

}
