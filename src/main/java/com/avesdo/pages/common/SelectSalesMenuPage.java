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
public class SelectSalesMenuPage extends AbstractPage{

	private static final Logger log = LogManager.getLogger(SelectBuildingPage.class);
	
	
	public SelectSalesMenuPage(WebDriver driver, ConfigurationReader configurationReader){
		this.driver = driver;
		this.configurationReader = configurationReader;
		scriptFile = "Sales.xlsx";
		sheetName = "Sales Menu";
		log.info("Sales Menu page with keywords from " + scriptFile + " sheet " + sheetName);
		
	}
	
	public boolean performSelectSalesMenu() throws Exception{
		log.info("Login performSelectSalesMenu ");
		return performOperation();
	}
}
