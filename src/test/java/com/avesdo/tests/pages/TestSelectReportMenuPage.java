package com.avesdo.tests.pages;

import static com.avesdo.tests.utils.reports.ExtentTestManager.startTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.avesdo.pages.common.SelectBuildingPage;
import com.avesdo.pages.common.SelectReportMenuPage;
import com.avesdo.pages.common.SelectSalesMenuPage;
import com.avesdo.utils.ConfigurationReader;

public class TestSelectReportMenuPage extends BaseTest {
	
	public TestSelectReportMenuPage(){
		
	}
	
	public TestSelectReportMenuPage(WebDriver driver, ConfigurationReader configurationReader, String browserName){
		this.driver = driver;
		this.configurationReader = configurationReader;
		this.browserName = browserName;
	}
	
	@Test
	public boolean selectMasterReport() throws Exception{
		startTest("Select Report Menu in browser " + this.browserName, "Select the report menu from the list" );
		boolean status = true;
		try{
			SelectReportMenuPage selectReportMenuPage = new SelectReportMenuPage(driver,configurationReader);
			status = selectReportMenuPage.performSelectMasterReportMenu();
		}catch(Exception e){
			status = false;
			handleException(e);
		}
		return status;
		
	}

}
