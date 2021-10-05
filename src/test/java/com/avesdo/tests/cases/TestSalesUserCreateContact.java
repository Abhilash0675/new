package com.avesdo.tests.cases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.avesdo.pages.common.LogoutPage;
import com.avesdo.tests.pages.BaseTest;
import com.avesdo.tests.pages.TestBuyerSignPage;
import com.avesdo.tests.pages.TestCreateContactPage;
import com.avesdo.tests.pages.TestLoginPage;
import com.avesdo.tests.pages.TestNewDealNavigation;
import com.avesdo.tests.pages.TestPurchaserPage;
import com.avesdo.tests.pages.TestReserveListingPage;
import com.avesdo.tests.pages.TestSelectBuildingPage;


public class TestSalesUserCreateContact extends BaseTest {
	
	@Test(priority=0)
	public void login() throws Exception{
		TestLoginPage testLoginPage = new TestLoginPage(driver,configurationReader,browserName,"common.xlsx","Login Sales Rep");
		boolean status = testLoginPage.login();
		handleAssert(status);
	}
	
	@Test(priority=1, dependsOnMethods={"login"})
	public void selectBuilding() throws Exception{
		TestSelectBuildingPage testSelectBuildingPage = new TestSelectBuildingPage(driver,configurationReader, browserName);
		boolean status = testSelectBuildingPage.selectBuilding();
		handleAssert(status);
	}
	
	@Test(priority=3, dependsOnMethods={"selectBuilding"})
	public void createContact() throws Exception{
		TestCreateContactPage testCreateContactPage = new TestCreateContactPage(driver,configurationReader,browserName);
		boolean status = testCreateContactPage.createContact();
		handleAssert(status);
	}
	
	@Test(priority=4, dependsOnMethods={"createContact"})
	public void logout() throws Exception{
		LogoutPage logoutPage = new LogoutPage(driver,configurationReader);
		boolean status = logoutPage.performLogoutAction();
		handleAssert(status);
	}
	


	
}
