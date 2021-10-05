package com.avesdo.tests.cases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.avesdo.pages.common.LogoutPage;
import com.avesdo.tests.pages.BaseTest;
import com.avesdo.tests.pages.TestBuyerSignPage;
import com.avesdo.tests.pages.TestLoginPage;
import com.avesdo.tests.pages.TestNewDealNavigation;
import com.avesdo.tests.pages.TestPurchaserPage;
import com.avesdo.tests.pages.TestReserveListingPage;
import com.avesdo.tests.pages.TestSelectBuildingPage;


public class TestBuyerSignDeal extends BaseTest {
	

	@Test(priority=0)
	@Parameters("sheet")
	public void login(String sheet) throws Exception{
		System.out.println("TestBuyerSignDeal " + sheet);
		TestLoginPage testLoginPage = new TestLoginPage(driver,configurationReader,browserName,"common.xlsx",sheet);
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
	public void toVerify() throws Exception{
		TestBuyerSignPage testBuyerSignPage = new TestBuyerSignPage(driver,configurationReader,browserName);
		boolean status = testBuyerSignPage.toSign();
		handleAssert(status);
	}
	
	@Test(priority=4, dependsOnMethods={"toVerify"})
	public void logout() throws Exception{
		LogoutPage logoutPage = new LogoutPage(driver,configurationReader);
		boolean status = logoutPage.performLogoutAction();
		handleAssert(status);
	}
	


	
}
