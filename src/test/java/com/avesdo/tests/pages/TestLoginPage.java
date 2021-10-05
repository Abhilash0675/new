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
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.avesdo.pages.common.LoginPage;
import com.avesdo.utils.ConfigurationReader;
import com.avesdo.utils.StringUtil;

/**
 * @author Anil
 *
 */
public class TestLoginPage extends BaseTest{
	
	public TestLoginPage(){
		
	}
	
	public TestLoginPage(WebDriver driver, ConfigurationReader configurationReader, String browserName){
		this.driver = driver;
		this.configurationReader = configurationReader;
		this.browserName = browserName;
	}
	
	public TestLoginPage(WebDriver driver, ConfigurationReader configurationReader, String browserName, String sheetName, String scriptFile){
		this.driver = driver;
		this.configurationReader = configurationReader;
		this.browserName = browserName;
		this.sheetName = sheetName;
		this.scriptFile = scriptFile;
	}
	
	@Test
	public boolean login() throws Exception{
		startTest("Login in browser " + this.browserName,"Validate login");
		boolean status = true;
		try{
			LoginPage loginPage;
			if(StringUtil.hasValue(sheetName) && StringUtil.hasValue(scriptFile)){
				loginPage = new LoginPage(driver,configurationReader, sheetName, scriptFile);
			}else{
				loginPage = new LoginPage(driver,configurationReader);
			}			
			status = loginPage.performLoginAction();
			
		}catch(Exception e){
			status = false;
			handleException(e);
		}
		return status;
	}
	

}
