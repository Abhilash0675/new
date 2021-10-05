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
public class NewDealNavigation extends AbstractPage{

	private static final Logger log = LogManager.getLogger(NewDealNavigation.class);
	
	
	public NewDealNavigation(WebDriver driver, ConfigurationReader configurationReader){
		this.driver = driver;
		this.configurationReader = configurationReader;
		scriptFile = "Contracts.xlsx";
		sheetName = "New Deal menu";
		log.info("Select New Deal menu  with keywords from " + scriptFile + " sheet " + sheetName);
		
	}
	
	public boolean performNewDealNavigation() throws Exception{
		log.info("Login performNewDealNavigation ");
		return performOperation();
	}
}
