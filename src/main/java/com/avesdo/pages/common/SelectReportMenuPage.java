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
public class SelectReportMenuPage extends AbstractPage{

	private static final Logger log = LogManager.getLogger(SelectBuildingPage.class);
	
	
	public SelectReportMenuPage(WebDriver driver, ConfigurationReader configurationReader){
		this.driver = driver;
		this.configurationReader = configurationReader;
		scriptFile = "Contracts.xlsx";
		sheetName = "Master Report";
		log.info("Report Menu page with keywords from " + scriptFile + " sheet " + sheetName);
		
	}
	
	public boolean performSelectMasterReportMenu() throws Exception{
		log.info("Login performSelectMasterReportMenu ");
		return performOperation();
	}
}
