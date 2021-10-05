package com.avesdo.tests.cases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.avesdo.pages.common.LogoutPage;
import com.avesdo.tests.pages.BaseTest;
import com.avesdo.tests.pages.TestLoginPage;
import com.avesdo.tests.pages.TestSelectBuildingPage;
import com.avesdo.tests.pages.TestStaffManagement;
import com.avesdo.tests.pages.TestStaffUser;

public class TestAddStaff extends BaseTest {
	
	@Test(priority=0)
	public void login() throws Exception{
		TestLoginPage testLoginPage = new TestLoginPage(driver,configurationReader,browserName,"common.xlsx","Login Sales Admin");
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
	public void staffManagement() throws Exception{
		TestStaffManagement testStaffManagement = new TestStaffManagement(driver,configurationReader);
		boolean status = testStaffManagement.staffManagement();
		handleAssert(status);
	}
	
	@Test(priority=3, dependsOnMethods={"staffManagement"})
	public void addStaffUser() throws Exception{
		TestStaffUser testStaffUser = new TestStaffUser(driver,configurationReader);
		boolean status = testStaffUser.addStaffUser();
		handleAssert(status);
	}
	
	@Test(priority=4, dependsOnMethods={"addStaffUser"})
	public void logout() throws Exception{
		LogoutPage logoutPage = new LogoutPage(driver,configurationReader);
		boolean status = logoutPage.performLogoutAction();
		handleAssert(status);
	}
	
	@Test(priority=5)
	public void loginSalesUser() throws Exception{
		TestLoginPage testLoginPage = new TestLoginPage(driver,configurationReader,browserName, "Sales.xlsx", "Login Sales User");
		boolean status = testLoginPage.login();
		handleAssert(status);
	}
	
	@Test(priority=6, dependsOnMethods={"loginSalesUser"})
	public void selectBuildingSales() throws Exception{
		TestSelectBuildingPage testSelectBuildingPage = new TestSelectBuildingPage(driver,configurationReader, browserName);
		boolean status = testSelectBuildingPage.selectBuilding();
		handleAssert(status);
	}
	
	/*@Test(priority=7, dependsOnMethods={"selectBuildingSales"})
	public void logoutSalesUser() throws Exception{
		LogoutPage logoutPage = new LogoutPage(driver,configurationReader);
		boolean status = logoutPage.performLogoutAction();
		handleAssert(status);
	}
	*/
	
	
}
