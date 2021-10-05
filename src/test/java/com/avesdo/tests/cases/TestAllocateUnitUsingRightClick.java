package com.avesdo.tests.cases;

import org.testng.annotations.Test;

import com.avesdo.pages.common.LogoutPage;
import com.avesdo.tests.pages.BaseTest;
import com.avesdo.tests.pages.TestAllocateLeftClickPage;
import com.avesdo.tests.pages.TestAllocateRightClickPage;
import com.avesdo.tests.pages.TestClearEmail;
import com.avesdo.tests.pages.TestLoginPage;
import com.avesdo.tests.pages.TestRealtorSignPage;
import com.avesdo.tests.pages.TestSelectBuildingPage;
import com.avesdo.tests.pages.TestSelectSalesMenuPage;


public class TestAllocateUnitUsingRightClick extends BaseTest {
	
	/*@Test
	public void clearEmail() throws Exception{
		TestClearEmail testClearEmail = new TestClearEmail(driver,configurationReader, browserName);
		boolean status = testClearEmail.clearEmail();
		handleAssert(status);
	}*/
	
	@Test
	public void login() throws Exception{
		TestLoginPage testLoginPage = new TestLoginPage(driver,configurationReader,browserName,"common.xlsx","Login Sales Rep");
		boolean status = testLoginPage.login();
		handleAssert(status);
	}
	
	@Test(dependsOnMethods={"login"})
	public void selectBuilding() throws Exception{
		TestSelectBuildingPage testSelectBuildingPage = new TestSelectBuildingPage(driver,configurationReader, browserName);
		boolean status = testSelectBuildingPage.selectBuilding();
		handleAssert(status);
	}
	
	@Test(dependsOnMethods={"selectBuilding"})
	public void selectSalesMenu() throws Exception{
		TestSelectSalesMenuPage testSelectBuildingPage = new TestSelectSalesMenuPage(driver,configurationReader, browserName);
		boolean status = testSelectBuildingPage.selectBuilding();
		handleAssert(status);
	}
	
	@Test(dependsOnMethods={"selectSalesMenu"})
	public void toAllocate() throws Exception{
		TestAllocateRightClickPage testAllocateRightClickPage = new TestAllocateRightClickPage(driver,configurationReader,browserName);
		boolean status = testAllocateRightClickPage.toAllocate();
		handleAssert(status);
	}
	
	@Test(dependsOnMethods={"toAllocate"})
	public void logout() throws Exception{
		LogoutPage logoutPage = new LogoutPage(driver,configurationReader);
		boolean status = logoutPage.performLogoutAction();
		handleAssert(status);
	}
	


	
}
