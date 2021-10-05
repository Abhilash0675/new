package com.avesdo.tests.pages;

import static com.avesdo.tests.utils.reports.ExtentManager.getExtentReports;
import static com.avesdo.tests.utils.reports.ExtentTestManager.getTest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.Status;
import com.avesdo.factory.BrowserFactory;
import com.avesdo.utils.ConfigurationReader;
import com.avesdo.utils.EmailUtils;

public class BaseTest {
	
	private static final Logger log = LogManager.getLogger(BaseTest.class);
	public WebDriver driver;
	public ConfigurationReader configurationReader;
	public String browserName = "";
	public String execution = "Mandatory";
	public String sheetName = null;
	public String scriptFile = null;
	
	public static Map<String,Boolean> executionStatusMap = new HashMap<String,Boolean>();
	
	@BeforeClass
	@Parameters({"browser", "execution"})
	public void initialize(String browser, String executionParam) throws IOException {
		System.out.println("browser " + browser);
		System.out.println("executionParam " + executionParam);
		this.browserName = browser;
		this.execution = executionParam;

		executionStatusMap.put(this.browserName, true);
		BrowserFactory browserFactory = new BrowserFactory(browser);
		driver = browserFactory.getDriver();
		configurationReader = browserFactory.getConfigurationReader();
		driver.get(configurationReader.getClientURL());		

	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		System.out.println("Automation_QA_Execution_Status = " + executionStatusMap.get(this.browserName));
		updateStatus();
	}
	
	@AfterSuite
	public void email() {
		try {
			EmailUtils emailUtils = new EmailUtils();
			emailUtils.sendEmailWithAttachment();
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public WebDriver getDriver(){
		return driver;
	}

	private void updateStatus(){
		try{
			//String str = this.getClass().getResource("../../../../status.txt").getPath().toString();
			String str = configurationReader.getRootDir()+"/Resources/status.txt";
			File file = new File(str);
			
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(""+executionStatusMap.get(this.browserName).toString().toUpperCase());
			fileWriter.close();

			
		}catch(Exception e){
			e.printStackTrace();
			log.error(e);
		}
	}
	public void handleException(Exception e){
		log.error(e);
		e.printStackTrace();
		/*System.out.println("handleException execution " + execution);
		System.out.println("handleException " + executionStatusMap.get(this.browserName));
		if("Mandatory".equalsIgnoreCase(execution)){
			boolean status = executionStatusMap.get(this.browserName) && false;
			System.out.println("handleException status " + status);
			executionStatusMap.put(this.browserName, status);
		}*/
        String base64Screenshot =
                "data:image/png;base64," + ((TakesScreenshot) Objects.requireNonNull(driver)).getScreenshotAs(OutputType.BASE64);
		getTest().log(Status.FAIL, "Test Failed",e,
		        getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));
        getExtentReports().flush();
	}
	
	public void handleAssert(boolean status) throws AssertionError{
		try{
			Assert.assertEquals(status, true);
		}catch(AssertionError e){
			System.out.println("handleAssert execution " + execution);
			System.out.println("handleAssert " + executionStatusMap.get(this.browserName));
			if("Mandatory".equalsIgnoreCase(execution)){
				boolean statusFlag = executionStatusMap.get(this.browserName) && false;
				System.out.println("handleAssert statusFlag " + statusFlag);
				executionStatusMap.put(this.browserName, statusFlag);
			}
			throw e;
		}
	}

}
