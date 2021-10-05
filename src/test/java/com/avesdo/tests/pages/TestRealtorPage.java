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
import com.avesdo.pages.common.PurchaserPage;
import com.avesdo.pages.common.RealtorPage;
import com.avesdo.utils.ConfigurationReader;

/**
 * @author Anil
 *
 */
public class TestRealtorPage extends BaseTest{
	
	public TestRealtorPage(){
		
	}
	
	public TestRealtorPage(WebDriver driver, ConfigurationReader configurationReader, String browserName){
		this.driver = driver;
		this.configurationReader = configurationReader;
		this.browserName = browserName;
	}
	
	@Test
	public boolean addRealtor() throws Exception{
		startTest("Add Realtor in browser " + this.browserName,"Add Realtor");
		boolean status = true;
		try{
			RealtorPage realtorPage = new RealtorPage(driver,configurationReader);
			status = realtorPage.performRealtorAction();
		}catch(Exception e){
			status = false;
			handleException(e);
		}
		return status;
	}
	

}
