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
public class RealtorSignDeal extends AbstractPage {
	
	private static final Logger log = LogManager.getLogger(BuyerSignDeal.class);
	
	public RealtorSignDeal(WebDriver driver, ConfigurationReader configurationReader){
		this.driver = driver;
		this.configurationReader = configurationReader;
		scriptFile = "Contracts.xlsx";
		sheetName = "Realtor Verify";
		log.info("Buyer Sign page with keywords from " + scriptFile + " sheet " + sheetName);
	}
	
	public boolean performSignAction() throws Exception{
		log.info("Perform Sign Action ");
		return performOperation();
	}

}
