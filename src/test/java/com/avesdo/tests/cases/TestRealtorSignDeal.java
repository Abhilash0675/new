package com.avesdo.tests.cases;

import org.testng.annotations.Test;

import com.avesdo.pages.common.LogoutPage;
import com.avesdo.tests.pages.BaseTest;
import com.avesdo.tests.pages.TestLoginPage;
import com.avesdo.tests.pages.TestRealtorSignPage;
import com.avesdo.tests.pages.TestSelectBuildingPage;


public class TestRealtorSignDeal extends BaseTest {
	
	@Test(priority=0)
	public void login() throws Exception{
		TestLoginPage testLoginPage = new TestLoginPage(driver,configurationReader,browserName,"common.xlsx","Login Realtor");
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
		TestRealtorSignPage testRealtorSignPage = new TestRealtorSignPage(driver,configurationReader,browserName);
		boolean status = testRealtorSignPage.toSign();
		handleAssert(status);
	}
	
	@Test(priority=4, dependsOnMethods={"toVerify"})
	public void logout() throws Exception{
		LogoutPage logoutPage = new LogoutPage(driver,configurationReader);
		boolean status = logoutPage.performLogoutAction();
		handleAssert(status);
	}
	


	
}
