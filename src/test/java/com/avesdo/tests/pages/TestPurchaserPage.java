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
import com.avesdo.utils.ConfigurationReader;

/**
 * @author Anil
 *
 */
public class TestPurchaserPage extends BaseTest{
	
	public TestPurchaserPage(){
		
	}
	
	public TestPurchaserPage(WebDriver driver, ConfigurationReader configurationReader, String browserName){
		this.driver = driver;
		this.configurationReader = configurationReader;
		this.browserName = browserName;
	}
	
	@Test
	public boolean addPurchaser() throws Exception{
		startTest("Add Purchaser in browser " + this.browserName,"Add Purchaser");
		boolean status = true;
		try{
			PurchaserPage purchaserPage = new PurchaserPage(driver,configurationReader);
			status = purchaserPage.performPurchaserAction();
		}catch(Exception e){
			status = false;
			handleException(e);
		}
		return status;
	}
	

}
