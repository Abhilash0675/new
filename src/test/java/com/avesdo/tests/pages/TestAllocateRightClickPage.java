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
import com.avesdo.pages.common.AllocateUsingLeftClick;
import com.avesdo.pages.common.AllocateUsingRightClick;
import com.avesdo.pages.common.BuyerSignDeal;
import com.avesdo.pages.common.LoginPage;
import com.avesdo.pages.common.PurchaserPage;
import com.avesdo.pages.common.RealtorSignDeal;
import com.avesdo.utils.ConfigurationReader;

/**
 * @author Anil
 *
 */
public class TestAllocateRightClickPage extends BaseTest{
	
	public TestAllocateRightClickPage(){
		
	}
	
	public TestAllocateRightClickPage(WebDriver driver, ConfigurationReader configurationReader, String browserName){
		this.driver = driver;
		this.configurationReader = configurationReader;
		this.browserName = browserName;
	}
	
	@Test
	public boolean toAllocate() throws Exception{
		startTest("Allocate using Right click in browser " + this.browserName,"Allocate using right click");
		boolean status = true;
		try{
			AllocateUsingRightClick allocateUsingRightClick = new AllocateUsingRightClick(driver,configurationReader);
			status = allocateUsingRightClick.performAllocateAction();
		}catch(Exception e){
			status = false;
			handleException(e);
		}
		return status;
	}
	

}
