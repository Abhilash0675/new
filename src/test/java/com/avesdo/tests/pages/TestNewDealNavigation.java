package com.avesdo.tests.pages;

import static com.avesdo.tests.utils.reports.ExtentTestManager.startTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.avesdo.pages.common.NewDealNavigation;
import com.avesdo.pages.common.SelectBuildingPage;
import com.avesdo.utils.ConfigurationReader;

public class TestNewDealNavigation extends BaseTest {
	
	public TestNewDealNavigation(){
		
	}
	
	public TestNewDealNavigation(WebDriver driver, ConfigurationReader configurationReader, String browserName){
		this.driver = driver;
		this.configurationReader = configurationReader;
		this.browserName = browserName;
	}
	
	@Test
	public boolean selectNewDealNavigation() throws Exception{
		startTest("Select New Deal Navigation in browser " + this.browserName, "Select the New Deal Navigation" );
		boolean status = true;
		try{
			NewDealNavigation newDealNavigation = new NewDealNavigation(driver,configurationReader);
			status = newDealNavigation.performNewDealNavigation();
		}catch(Exception e){
			status = false;
			handleException(e);
		}
		return status;
	}

}
