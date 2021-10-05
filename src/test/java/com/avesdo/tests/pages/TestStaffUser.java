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
import com.avesdo.pages.common.StaffUser;
import com.avesdo.utils.ConfigurationReader;

/**
 * @author Anil
 *
 */
public class TestStaffUser extends BaseTest{
	
	public TestStaffUser(){
		
	}
	
	public TestStaffUser(WebDriver driver, ConfigurationReader configurationReader){
		this.driver = driver;
		this.configurationReader = configurationReader;
	}
	
	@Test
	public boolean addStaffUser() throws Exception{
		startTest("Add staff", "Add Staff");
		boolean status = true;
		try{
			StaffUser staffUser = new StaffUser(driver,configurationReader);
			status = staffUser.performAddStaffUserAction();
		}catch(Exception e){
			status = false;
			handleException(e);
		}
		return status;
	}

}
