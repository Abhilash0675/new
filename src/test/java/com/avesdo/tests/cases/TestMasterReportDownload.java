package com.avesdo.tests.cases;

import org.testng.annotations.Test;

import com.avesdo.pages.common.LogoutPage;
import com.avesdo.tests.pages.BaseTest;
import com.avesdo.tests.pages.TestAllocateLeftClickPage;
import com.avesdo.tests.pages.TestClearEmail;
import com.avesdo.tests.pages.TestLoginPage;
import com.avesdo.tests.pages.TestRealtorSignPage;
import com.avesdo.tests.pages.TestSelectBuildingPage;
import com.avesdo.tests.pages.TestSelectReportMenuPage;
import com.avesdo.tests.pages.TestSelectSalesMenuPage;
import com.avesdo.tests.pages.TestUnAllocateRightClickPage;


public class TestMasterReportDownload extends BaseTest {
	
	/*@Test
	public void clearEmail() throws Exception{
		TestClearEmail testClearEmail = new TestClearEmail(driver,configurationReader, browserName);
		boolean status = testClearEmail.clearEmail();
		handleAssert(status);
	}*/
	
	@Test
	public void login() throws Exception{
		TestLoginPage testLoginPage = new TestLoginPage(driver,configurationReader,browserName,"common.xlsx","Login Sales Admin");
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
	public void selectReportsMenu() throws Exception{
		TestSelectReportMenuPage testSelectReportMenuPage = new TestSelectReportMenuPage(driver,configurationReader, browserName);
		boolean status = testSelectReportMenuPage.selectMasterReport();
		handleAssert(status);
	}	

	@Test(dependsOnMethods={"selectReportsMenu"})
	public void logout() throws Exception{
		LogoutPage logoutPage = new LogoutPage(driver,configurationReader);
		boolean status = logoutPage.performLogoutAction();
		handleAssert(status);
	}
	


	
}
