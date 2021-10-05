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
public class PurchaserPage extends AbstractPage {
	
	private static final Logger log = LogManager.getLogger(PurchaserPage.class);
	
	public PurchaserPage(WebDriver driver, ConfigurationReader configurationReader){
		this.driver = driver;
		this.configurationReader = configurationReader;
		scriptFile = "Contracts.xlsx";
		sheetName = "Add Existing Purchaser";
		log.info("Purchaser page with keywords from " + scriptFile + " sheet " + sheetName);
	}
	
	public boolean performPurchaserAction() throws Exception{
		log.info("Purchaser performAction ");
		return performOperation();
	}

}
