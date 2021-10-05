package com.avesdo.tests.cases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.avesdo.pages.common.LogoutPage;
import com.avesdo.tests.pages.BaseTest;
import com.avesdo.tests.pages.TestLoginPage;
import com.avesdo.tests.pages.TestNewDealNavigation;
import com.avesdo.tests.pages.TestPurchaserPage;
import com.avesdo.tests.pages.TestRealtorPage;
import com.avesdo.tests.pages.TestReserveListingPage;
import com.avesdo.tests.pages.TestSelectBuildingPage;


public class TestCreateNewDeal extends BaseTest {
	
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
	
	@Test(priority=2, dependsOnMethods={"selectBuilding"})
	public void newDealNavigation() throws Exception{
		TestNewDealNavigation testNewDealNavigation = new TestNewDealNavigation(driver,configurationReader,browserName);
		boolean status = testNewDealNavigation.selectNewDealNavigation();
		handleAssert(status);
	}
	
	@Test(priority=3, dependsOnMethods={"newDealNavigation"})
	public void reserveListing() throws Exception{
		TestReserveListingPage testReserveListing = new TestReserveListingPage(driver,configurationReader,browserName);
		boolean status = testReserveListing.reserveListing();
		handleAssert(status);
	}
	

	@Test(priority=4, dependsOnMethods={"reserveListing"})
	public void addPurchaser() throws Exception{
		TestPurchaserPage testPurchaserPage = new TestPurchaserPage(driver,configurationReader,browserName);
		boolean status = testPurchaserPage.addPurchaser();
		handleAssert(status);
	}
	
	@Test(priority=5, dependsOnMethods={"addPurchaser"})
	public void logout() throws Exception{
		LogoutPage logoutPage = new LogoutPage(driver,configurationReader);
		boolean status = logoutPage.performLogoutAction();
		handleAssert(status);
	}

	
}
