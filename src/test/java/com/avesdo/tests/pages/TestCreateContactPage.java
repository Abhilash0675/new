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
import com.avesdo.pages.common.BuyerSignDeal;
import com.avesdo.pages.common.CreateContact;
import com.avesdo.pages.common.LoginPage;
import com.avesdo.pages.common.PurchaserPage;
import com.avesdo.utils.ConfigurationReader;

/**
 * @author Anil
 *
 */
public class TestCreateContactPage extends BaseTest{
	
	public TestCreateContactPage(){
		
	}
	
	public TestCreateContactPage(WebDriver driver, ConfigurationReader configurationReader, String browserName){
		this.driver = driver;
		this.configurationReader = configurationReader;
		this.browserName = browserName;
	}
	
	@Test
	public boolean createContact() throws Exception{
		startTest("Create conatct in browser " + this.browserName,"Create Contact");
		boolean status = true;
		try{
			CreateContact createContact = new CreateContact(driver,configurationReader);
			status = createContact.performCreateContact();
		}catch(Exception e){
			status = false;
			handleException(e);
		}
		return status;
	}
	

}
