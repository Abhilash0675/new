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
public class ReserveListingPage extends AbstractPage {
	
	private static final Logger log = LogManager.getLogger(ReserveListingPage.class);
	
	public ReserveListingPage(WebDriver driver, ConfigurationReader configurationReader){
		this.driver = driver;
		this.configurationReader = configurationReader;
		scriptFile = "Contracts.xlsx";
		sheetName = "Reserve Listing";
		log.info("Reserve Listing page with keywords from " + scriptFile + " sheet " + sheetName);
	}
	
	public boolean performReserveListingAction() throws Exception{
		log.info("Reserve Listing performAction ");
		return performOperation();
	}

}
