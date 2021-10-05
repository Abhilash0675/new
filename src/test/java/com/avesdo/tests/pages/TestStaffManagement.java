/**
 * 
 */
package com.avesdo.tests.pages;

import static com.avesdo.tests.utils.reports.ExtentTestManager.startTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.avesdo.pages.common.LoginPage;
import com.avesdo.pages.common.StaffManagement;
import com.avesdo.utils.ConfigurationReader;

/**
 * @author Anil
 *
 */
public class TestStaffManagement extends BaseTest{
	
	public TestStaffManagement(){
		
	}
	
	public TestStaffManagement(WebDriver driver, ConfigurationReader configurationReader){
		this.driver = driver;
		this.configurationReader = configurationReader;
	}
	
	@Test
	public boolean staffManagement() throws Exception{
		startTest("Staff Management", "Manage Staff");
		boolean status = true;
		try{
			StaffManagement staffManagement = new StaffManagement(driver,configurationReader);
			status = staffManagement.performStaffManagementAction();
		}catch(Exception e){
			status = false;
			handleException(e);
		}
		return status;
	}

}
