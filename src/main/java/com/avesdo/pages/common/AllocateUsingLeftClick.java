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
public class AllocateUsingLeftClick extends AbstractPage {
	
	private static final Logger log = LogManager.getLogger(BuyerSignDeal.class);
	
	public AllocateUsingLeftClick(WebDriver driver, ConfigurationReader configurationReader){
		this.driver = driver;
		this.configurationReader = configurationReader;
		scriptFile = "Sales.xlsx";
		sheetName = "Left Click Allocate";
		log.info("Left Click Allocate page with keywords from " + scriptFile + " sheet " + sheetName);
	}
	
	public boolean performAllocateAction() throws Exception{
		log.info("Perform Allocate Action ");
		return performOperation();
	}

}
