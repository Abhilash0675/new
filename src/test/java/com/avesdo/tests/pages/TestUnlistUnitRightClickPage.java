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
import com.avesdo.pages.common.ListUnitPrivateUsingRightClick;
import com.avesdo.pages.common.ListUnitPublicUsingRightClick;
import com.avesdo.pages.common.LoginPage;
import com.avesdo.pages.common.PurchaserPage;
import com.avesdo.pages.common.RealtorSignDeal;
import com.avesdo.utils.ConfigurationReader;

/**
 * @author Anil
 *
 */
public class TestUnlistUnitRightClickPage extends BaseTest{
	
	public TestUnlistUnitRightClickPage(){
		
	}
	
	public TestUnlistUnitRightClickPage(WebDriver driver, ConfigurationReader configurationReader, String browserName){
		this.driver = driver;
		this.configurationReader = configurationReader;
		this.browserName = browserName;
	}
	
	@Test
	public boolean toListPrivate() throws Exception{
		startTest("Unlist unit using Right click in browser " + this.browserName,"Unlist unit using right click");
		boolean status = true;
		try{
			ListUnitPrivateUsingRightClick listUnitPrivateUsingRightClick = new ListUnitPrivateUsingRightClick(driver,configurationReader);
			status = listUnitPrivateUsingRightClick.performListPrivateAction();
		}catch(Exception e){
			status = false;
			handleException(e);
		}
		return status;
	}
	

}
