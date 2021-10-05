/**
 * 
 */
package com.avesdo.tests.utils.listeners;

import static com.avesdo.tests.utils.reports.ExtentManager.getExtentReports;
import static com.avesdo.tests.utils.reports.ExtentTestManager.getTest;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.avesdo.tests.pages.BaseTest;

/**
 * @author Anil
 *
 */
public class TestListener extends BaseTest implements ITestListener {
	
	private static final Logger log = LogManager.getLogger(TestListener.class);
	
	private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
    @Override
    public void onStart(ITestContext iTestContext) {
        log.info("Enter onStart method " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", this.driver);
    }
    @Override
    public void onFinish(ITestContext iTestContext) {
        log.info("Enter onFinish method " + iTestContext.getName());
		getExtentReports().flush();
    }
    @Override
    public void onTestStart(ITestResult iTestResult) {
        log.info(getTestMethodName(iTestResult) + " test is starting." + this.browserName);
    }
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info(getTestMethodName(iTestResult) + " test is succeed.");
        //ExtentReports log operation for passed tests.
        getTest().log(Status.PASS, "Test passed");
        getExtentReports().flush();
    }
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.info(getTestMethodName(iTestResult) + " test is failed.");
        Object testClass = iTestResult.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriver();
        String base64Screenshot =
            "data:image/png;base64," + ((TakesScreenshot) Objects.requireNonNull(driver)).getScreenshotAs(OutputType.BASE64);
        getTest().log(Status.FAIL, "Test Failed",
        getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));
        getExtentReports().flush();
    }
    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log.info(getTestMethodName(iTestResult) + " test is skipped.");
        getTest().log(Status.SKIP, "Test Skipped");
        getExtentReports().flush();
    }
    
}
