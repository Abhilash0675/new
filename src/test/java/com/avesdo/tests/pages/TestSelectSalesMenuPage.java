package com.avesdo.tests.pages;

import static com.avesdo.tests.utils.reports.ExtentTestManager.startTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.avesdo.pages.common.SelectBuildingPage;
import com.avesdo.pages.common.SelectSalesMenuPage;
import com.avesdo.utils.ConfigurationReader;

public class TestSelectSalesMenuPage extends BaseTest {
	
	public TestSelectSalesMenuPage(){
		
	}
	
	public TestSelectSalesMenuPage(WebDriver driver, ConfigurationReader configurationReader, String browserName){
		this.driver = driver;
		this.configurationReader = configurationReader;
		this.browserName = browserName;
	}
	
	@Test
	public boolean selectBuilding() throws Exception{
		startTest("Select Sales Menu in browser " + this.browserName, "Select the sales menu from the list" );
		boolean status = true;
		try{
			SelectSalesMenuPage selectSalesMenuPage = new SelectSalesMenuPage(driver,configurationReader);
			status = selectSalesMenuPage.performSelectSalesMenu();
		}catch(Exception e){
			status = false;
			handleException(e);
		}
		return status;
		
	}

}
