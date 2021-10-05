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
public class AllocateUsingRightClick extends AbstractPage {
	
	private static final Logger log = LogManager.getLogger(BuyerSignDeal.class);
	
	public AllocateUsingRightClick(WebDriver driver, ConfigurationReader configurationReader){
		this.driver = driver;
		this.configurationReader = configurationReader;
		scriptFile = "Sales.xlsx";
		sheetName = "Right Click Allocate";
		log.info("Right Click Allocate page with keywords from " + scriptFile + " sheet " + sheetName);
	}
	
	public boolean performAllocateAction() throws Exception{
		log.info("Perform Allocate Action ");
		return performOperation();
	}

}
