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
import com.avesdo.pages.common.AdminVerifyDeal;
import com.avesdo.pages.common.BuyerSignDeal;
import com.avesdo.pages.common.LoginPage;
import com.avesdo.pages.common.PurchaserPage;
import com.avesdo.utils.ConfigurationReader;

/**
 * @author Anil
 *
 */
public class TestAdminVerifyPage extends BaseTest{
	
	public TestAdminVerifyPage(){
		
	}
	
	public TestAdminVerifyPage(WebDriver driver, ConfigurationReader configurationReader, String browserName){
		this.driver = driver;
		this.configurationReader = configurationReader;
		this.browserName = browserName;
	}
	
	@Test
	public boolean toVerify() throws Exception{
		startTest("Admin verify deal in browser " + this.browserName,"Admin Verify");
		boolean status = true;
		try{
			AdminVerifyDeal adminVerifyDeal = new AdminVerifyDeal(driver,configurationReader);
			status = adminVerifyDeal.performVerifyAction();
		}catch(Exception e){
			status = false;
			handleException(e);
		}
		return status;
	}
	

}
