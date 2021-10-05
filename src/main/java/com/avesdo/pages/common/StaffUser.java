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
public class StaffUser extends AbstractPage {
	
	private static final Logger log = LogManager.getLogger(StaffUser.class);
	
	public StaffUser(WebDriver driver, ConfigurationReader configurationReader){
		this.driver = driver;
		this.configurationReader = configurationReader;
		scriptFile = "Sales.xlsx";
		sheetName = "Add Admin or developer";
		log.info("StaffUser page with keywords from " + scriptFile + " sheet " + sheetName);
	}
	
	public boolean performAddStaffUserAction() throws Exception{
		log.info("Login performAddStaffUserAction ");
		return performOperation();
	}

}
