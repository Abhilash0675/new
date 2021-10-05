/**
 * 
 */
package com.avesdo.tests.pages;

import static com.avesdo.tests.utils.reports.ExtentTestManager.startTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.avesdo.pages.common.ClearEmail;
import com.avesdo.pages.common.LoginPage;
import com.avesdo.pages.common.StaffManagement;
import com.avesdo.pages.common.StaffUser;
import com.avesdo.utils.ConfigurationReader;

/**
 * @author Anil
 *
 */
public class TestClearEmail extends BaseTest{
	
	public TestClearEmail(){
		
	}
	
	public TestClearEmail(WebDriver driver, ConfigurationReader configurationReader, String browserName){
		this.driver = driver;
		this.configurationReader = configurationReader;
		this.browserName = browserName;
	}
	
	@Test
	public boolean clearEmail() throws Exception{
		startTest("Clear Email", "Clear Email");
		boolean status = true;
		try{
			ClearEmail clearEmail = new ClearEmail(driver,configurationReader);
			status = clearEmail.performClearEmailAction();
		}catch(Exception e){
			status = false;
			handleException(e);
		}
		return status;
	}

}
