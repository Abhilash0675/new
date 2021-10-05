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
public class ListUnitPublicUsingRightClick extends AbstractPage {
	
	private static final Logger log = LogManager.getLogger(BuyerSignDeal.class);
	
	public ListUnitPublicUsingRightClick(WebDriver driver, ConfigurationReader configurationReader){
		this.driver = driver;
		this.configurationReader = configurationReader;
		scriptFile = "Sales.xlsx";
		sheetName = "Right Click List Public";
		log.info("Right Click List Public page with keywords from " + scriptFile + " sheet " + sheetName);
	}
	
	public boolean performListPublicAction() throws Exception{
		log.info("Perform List Public Action ");
		return performOperation();
	}

}
