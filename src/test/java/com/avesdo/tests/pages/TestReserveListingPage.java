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
import com.avesdo.pages.common.ReserveListingPage;
import com.avesdo.utils.ConfigurationReader;

/**
 * @author Anil
 *
 */
public class TestReserveListingPage extends BaseTest{
	
	public TestReserveListingPage(){
		
	}
	
	public TestReserveListingPage(WebDriver driver, ConfigurationReader configurationReader, String browserName){
		this.driver = driver;
		this.configurationReader = configurationReader;
		this.browserName = browserName;
	}
	
	@Test
	public boolean reserveListing() throws Exception{
		startTest("ReserveListing in browser " + this.browserName,"Reserve Listing");
		boolean status = true;
		try{
			ReserveListingPage reserveListingPage = new ReserveListingPage(driver,configurationReader);
			status = reserveListingPage.performReserveListingAction();
		}catch(Exception e){
			status = false;
			handleException(e);
		}
		return status;
	}
	

}
