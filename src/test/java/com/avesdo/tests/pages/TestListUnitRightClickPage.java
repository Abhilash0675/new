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
import com.avesdo.pages.common.ListUnitPublicUsingRightClick;
import com.avesdo.pages.common.LoginPage;
import com.avesdo.pages.common.PurchaserPage;
import com.avesdo.pages.common.RealtorSignDeal;
import com.avesdo.utils.ConfigurationReader;

/**
 * @author Anil
 *
 */
public class TestListUnitRightClickPage extends BaseTest{
	
	public TestListUnitRightClickPage(){
		
	}
	
	public TestListUnitRightClickPage(WebDriver driver, ConfigurationReader configurationReader, String browserName){
		this.driver = driver;
		this.configurationReader = configurationReader;
		this.browserName = browserName;
	}
	
	@Test
	public boolean toListPublic() throws Exception{
		startTest("List unit using Right click in browser " + this.browserName,"List unit using right click");
		boolean status = true;
		try{
			ListUnitPublicUsingRightClick listUnitPublicUsingRightClick = new ListUnitPublicUsingRightClick(driver,configurationReader);
			status = listUnitPublicUsingRightClick.performListPublicAction();
		}catch(Exception e){
			status = false;
			handleException(e);
		}
		return status;
	}
	

}
