/**
 * 
 */
package com.avesdo.tests.utils.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


/**
 * @author Anil
 *
 */
public class ExtentManager {
	
	private static final ExtentReports extentReports = new ExtentReports();
	
    public synchronized static ExtentReports getExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter(".\\Extent_Reports\\Avesdo_Extent_Report.html");
        reporter.config().setReportName("Avesdo Extent Report");
        extentReports.attachReporter(reporter);
        /*extentReports.setSystemInfo("Name", "Avesdo Automation");
        extentReports.setSystemInfo("Author", "QA Avesdo");*/

        return extentReports;
    }

}
