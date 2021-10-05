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
public class SelectBuildingPage extends AbstractPage{

	private static final Logger log = LogManager.getLogger(SelectBuildingPage.class);
	
	
	public SelectBuildingPage(WebDriver driver, ConfigurationReader configurationReader){
		this.driver = driver;
		this.configurationReader = configurationReader;
		scriptFile = "common.xlsx";
		sheetName = "Select building";
		log.info("Select Building page with keywords from " + scriptFile + " sheet " + sheetName);
		
	}
	
	public boolean performSelectBuilding() throws Exception{
		log.info("Login performSelectBuilding ");
		return performOperation();
	}
}
