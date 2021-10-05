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
public class AdminVerifyDeal extends AbstractPage {
	
	private static final Logger log = LogManager.getLogger(AdminVerifyDeal.class);
	
	public AdminVerifyDeal(WebDriver driver, ConfigurationReader configurationReader){
		this.driver = driver;
		this.configurationReader = configurationReader;
		scriptFile = "Contracts.xlsx";
		sheetName = "Admin Verify";
		log.info("Admin verifyn page with keywords from " + scriptFile + " sheet " + sheetName);
	}
	
	public boolean performVerifyAction() throws Exception{
		log.info("Perform Verify Action ");
		return performOperation();
	}

}
