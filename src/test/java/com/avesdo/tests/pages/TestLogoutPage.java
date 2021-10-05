/**
 * 
 */
package com.avesdo.tests.pages;

import static com.avesdo.tests.utils.reports.ExtentTestManager.startTest;

import java.util.Objects;

import static com.avesdo.tests.utils.reports.ExtentManager.getExtentReports;
import static com.avesdo.tests.utils.reports.ExtentTestManager.getTest;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.avesdo.pages.common.LoginPage;
import com.avesdo.utils.ConfigurationReader;

/**
 * @author Anil
 *
 */
public class TestLogoutPage extends BaseTest{
	
	public TestLogoutPage(){
		
	}
	
	public TestLogoutPage(WebDriver driver, ConfigurationReader configurationReader, String browserName){
		this.driver = driver;
		this.configurationReader = configurationReader;
		this.browserName = browserName;
	}
	
	@Test
	public boolean logout() throws Exception{
		startTest("Logout in browser " + this.browserName,"Validate logout");
		boolean status = true;
		try{
			LoginPage loginPage = new LoginPage(driver,configurationReader);
			status = loginPage.performLoginAction();
		}catch(Exception e){
			status = false;
			handleException(e);
		}
		return status;
	}
	

}
