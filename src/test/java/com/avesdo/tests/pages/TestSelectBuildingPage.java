package com.avesdo.tests.pages;

import static com.avesdo.tests.utils.reports.ExtentTestManager.startTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.avesdo.pages.common.SelectBuildingPage;
import com.avesdo.utils.ConfigurationReader;

public class TestSelectBuildingPage extends BaseTest {
	
	public TestSelectBuildingPage(){
		
	}
	
	public TestSelectBuildingPage(WebDriver driver, ConfigurationReader configurationReader, String browserName){
		this.driver = driver;
		this.configurationReader = configurationReader;
		this.browserName = browserName;
	}
	
	@Test
	public boolean selectBuilding() throws Exception{
		startTest("Select Building in browser " + this.browserName, "Select the building from the list" );
		boolean status = true;
		try{
			SelectBuildingPage selectBuildingPage = new SelectBuildingPage(driver,configurationReader);
			status = selectBuildingPage.performSelectBuilding();
		}catch(Exception e){
			status = false;
			handleException(e);
		}
		return status;
		
	}

}
