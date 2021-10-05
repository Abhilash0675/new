package com.avesdo.factory;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.avesdo.utils.ConfigurationReader;
import com.paulhammant.ngwebdriver.NgWebDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;


public class BrowserFactory {

	private static final Logger log = LogManager.getLogger(BrowserFactory.class);
	WebDriver driver;
	NgWebDriver ngWebdriver;
	JavascriptExecutor jsDriver;
	ConfigurationReader configurationReader = new ConfigurationReader();
	String browser = "";

	public BrowserFactory(String browser) {
		log.info("Starting BrowserFactory for " + browser);
		this.browser = browser;
	}

	public WebDriver getDriver() {
		if (this.browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", configurationReader.getChromeDriverPath());
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			jsDriver = (JavascriptExecutor) driver;
			ngWebdriver = new NgWebDriver(jsDriver);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		} else if (this.browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", configurationReader.getEdgeDriverPath());
			//WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			jsDriver = (JavascriptExecutor) driver;
			ngWebdriver = new NgWebDriver(jsDriver);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		} else {
			log.error("Unsupported browser " + this.browser);
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		//driver.get(configurationReader.getClientURL());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	/**
	 * @return the configurationReader
	 */
	public ConfigurationReader getConfigurationReader() {
		return configurationReader;
	}

}
