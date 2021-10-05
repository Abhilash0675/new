package com.avesdo.pages;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.avesdo.utils.ConfigurationReader;
import com.avesdo.utils.StringUtil;
import com.avesdo.utils.WebDriverUtil;
import com.avesdo.utils.XlsUtils;

public abstract class AbstractPage {
	
	public WebDriver driver;
	public ConfigurationReader configurationReader;
	public String sheetName;
	public String scriptFile;
	
	public boolean performOperation() throws Exception{
		Workbook workbook = null;
		Sheet sheet = null;
		Cell cell = null;
		String name = null;
		String identifierType = null;
		String identifier = null;
		String elementType = null;
		String data = null;
		String verifyData = null;
		String verifyXpath = null;
		String clickRequired = null;
		String isCollection = null;
		boolean statusFlag = true;
		String status = "Passed";
		String amount = null;

		workbook = XlsUtils.getWorkbook(configurationReader.getRootDir()+"/scripts/", scriptFile);
		sheet = XlsUtils.getSheet(workbook, sheetName);
		for (int row = 1; row <= sheet.getLastRowNum(); row++) {
			cell = XlsUtils.getCell(sheet, 0, row);
			name = XlsUtils.getCellData(cell).trim();
			cell = XlsUtils.getCell(sheet, 1, row);
			identifierType = XlsUtils.getCellData(cell).trim();
			cell = XlsUtils.getCell(sheet, 2, row);
			identifier = XlsUtils.getCellData(cell).trim();
			cell = XlsUtils.getCell(sheet, 3, row);
			elementType = XlsUtils.getCellData(cell).trim();
			cell = XlsUtils.getCell(sheet, 4, row);
			data = XlsUtils.getCellData(cell).trim();
			cell = XlsUtils.getCell(sheet, 5, row);
			verifyData = XlsUtils.getCellData(cell).trim();
			cell = XlsUtils.getCell(sheet, 6, row);
			verifyXpath = XlsUtils.getCellData(cell).trim();
			cell = XlsUtils.getCell(sheet, 7, row);
			clickRequired = XlsUtils.getCellData(cell).trim();
			cell = XlsUtils.getCell(sheet, 8, row);
			isCollection = XlsUtils.getCellData(cell).trim();
			
			if(!"Read".equalsIgnoreCase(elementType)){
				data = updateDynamicData(data);
			}
			
			if("0".equalsIgnoreCase(identifierType) || "0".equalsIgnoreCase(identifier)){
				continue;
			}
			if("0".equalsIgnoreCase(verifyXpath)){
				verifyXpath = "";
			}

			if(StringUtil.hasValue(identifierType) && "URL".equalsIgnoreCase(identifierType) 
					&& StringUtil.hasValue(elementType) && "URL".equalsIgnoreCase(elementType) && StringUtil.hasValue(data) ){
				String url = data;
				if("baseURL".equalsIgnoreCase(data)){
					url = configurationReader.getDynamicValueMap().get("baseURL");
				}else if("currentURL".equalsIgnoreCase(data)){
					url = configurationReader.getDynamicValueMap().get("currentURL");
				}
				String currentURL = driver.getCurrentUrl();
				configurationReader.getDynamicValueMap().put("currentURL",currentURL);
				driver.get(url);
				Thread.sleep(3000);
				continue;
			}
			
			if (StringUtil.hasValue(identifierType) && StringUtil.hasValue(identifier) && StringUtil.hasValue(elementType)) {
				if(identifier.contains("~")){
					identifier = updateIdentifier(identifier);
					//System.out.println("Updated identifier " + identifier);
				}
				
				By by = WebDriverUtil.getByElement(identifierType, identifier);
				boolean isCollectionFlag = false;
				int collectionIndex = 0;
				if(isCollection.toLowerCase().startsWith("yes")){
					isCollectionFlag = true;
					if(isCollection.contains("(") && isCollection.contains(")")){
						String indexstr = isCollection.substring(isCollection.indexOf("(")+1,isCollection.indexOf(")"));
						collectionIndex = Integer.parseInt(indexstr)-1;
					}
				}

				WebElement webElement;
				try {
					waitForElementPresent(driver, identifierType, identifier);
					driver.findElement(by);
					webElement = getWebElement(by, isCollectionFlag, collectionIndex);
				} catch (Exception e) {
					System.out.println("ERROR >>>>> " + identifier);
					e.printStackTrace();
					status = "Failed";
					statusFlag = false;
					throw e;
				}
				 

				if ("InputText".equalsIgnoreCase(elementType) && StringUtil.hasValue(data)) {
					webElement.clear();
					webElement.sendKeys(data);
					//webElement.sendKeys(Keys.TAB);
				} else if ("InputTextRead".equalsIgnoreCase(elementType) && StringUtil.hasValue(data)) {
					System.out.println("elementType " + elementType);
					String value = webElement.getAttribute("value");
					System.out.println("InputTextRead " + value);
					configurationReader.getDynamicValueMap().put(data,value);
					System.out.println(configurationReader.getDynamicValueMap().toString());
					//webElement.sendKeys(Keys.TAB);
				} else if("InputText2".equalsIgnoreCase(elementType) && StringUtil.hasValue(data)){
					webElement.clear();
					webElement.sendKeys(data);
					webElement.click();
					webElement.sendKeys(Keys.TAB);
				}else if ("InputSubmit".equalsIgnoreCase(elementType)) {
					webElement.click();					
					waitForPageToLoad(driver);
					if (StringUtil.hasValue(verifyXpath) && StringUtil.hasValue(verifyData)) {
						statusFlag = verifyText(verifyXpath, verifyData);
					}
				} else if ("InputSubmit2".equalsIgnoreCase(elementType)) {
					Thread.sleep(2000);
					JavascriptExecutor executor = (JavascriptExecutor)driver;
					executor.executeScript("arguments[0].click();", webElement);
				} else if("Read".equalsIgnoreCase(elementType) && StringUtil.hasValue(data)) {					
					String str = webElement.getText();
					System.out.println(str);
					configurationReader.getDynamicValueMap().put(data, str);
					System.out.println(configurationReader.getDynamicValueMap().toString());
				}else if ("InputSelect".equalsIgnoreCase(elementType) && StringUtil.hasValue(data)) {
					select(webElement, data);
					if (StringUtil.hasValue(verifyXpath) && StringUtil.hasValue(verifyData)) {
						statusFlag = verifyText(verifyXpath, verifyData);
					}
				}else if ("Scroll".equalsIgnoreCase(elementType)) {
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].scrollIntoView(true);", webElement);
					Thread.sleep(500);
					Actions a = new Actions(driver);
				    a.moveToElement(webElement);
				    a.perform();
					
				} else if ("InputSelectDiv".equalsIgnoreCase(elementType)) {
					// dropDownElement.click();
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", webElement);

					Thread.sleep(500);


					if (StringUtil.hasValue(verifyXpath) && StringUtil.hasValue(verifyData)) {
						statusFlag = verifyText(verifyXpath, verifyData);
					}
				} else if ("Slider".equalsIgnoreCase(elementType) && StringUtil.hasValue(data) && StringUtil.isNumeric(data)) {
					action(webElement, data, row);
					waitForPageToLoad(driver);
				} else if ("Anchor".equalsIgnoreCase(elementType)) {
					webElement.click();
					waitForPageToLoad(driver);
					if (StringUtil.hasValue(verifyXpath) && StringUtil.hasValue(verifyData)) {
						statusFlag = verifyText(verifyXpath, verifyData);
					}
				} else if ("Anchor1".equalsIgnoreCase(elementType)) {
					webElement.click();
					waitForPageToLoad(driver);
					// verifyimage(verifyData);
				} else if ("InputCheckbox".equalsIgnoreCase(elementType)) {
					webElement.click();
				} else if ("InputRadiobox".equalsIgnoreCase(elementType)) {
					webElement.click();
				} else if ("TextFetch".equalsIgnoreCase(elementType)) {

					amount = driver.findElement(By.xpath(identifier)).getText().substring(Integer.parseInt(data));
					System.out.println(amount);
				} else if ("InputTextFill".equalsIgnoreCase(elementType)) {
					webElement.sendKeys(amount);
				} else if ("AlertPopUp".equalsIgnoreCase(elementType)) {
					webElement.click();
					acceptAlert();

				} else if ("MouseOver".equalsIgnoreCase(elementType)) {

					Actions builder = new Actions(driver);
					builder.moveToElement(webElement).build().perform();

				} else if ("InputTextTab".equalsIgnoreCase(elementType) && StringUtil.hasValue(data)) {
					webElement.sendKeys(data);
					webElement.sendKeys(Keys.TAB);
				} else if ("Tab".equalsIgnoreCase(elementType)) {
					webElement.sendKeys(Keys.TAB);
				} else if ("ContextMenu".equalsIgnoreCase(elementType)) {
					Actions action = new Actions(driver).contextClick(driver.findElement(By.xpath(identifier)));
					action.build().perform();
				} else if ("WaitforElement".equalsIgnoreCase(elementType)) {
					WebDriverWait wait = new WebDriverWait(driver, 5);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(identifier)));
				}

			} else if (StringUtil.hasValue(elementType)) {
				if ("ClosePopUp".equalsIgnoreCase(elementType)) {

					String winHandleBefore = driver.getWindowHandle();
					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle);
					}
					driver.close();

					driver.switchTo().window(winHandleBefore);

				} else if ("Wait".equalsIgnoreCase(elementType) && StringUtil.hasValue(data)) {
					Thread.sleep(Long.parseLong(data) * 1000);
				}else if("Wait".equalsIgnoreCase(elementType)){
					Thread.sleep(5 * 1000);
				}

			}

			if (!statusFlag) {
				status = "Failed";
			} else if (StringUtil.hasValue(verifyData) && !(verifyData.equals("0"))) {
				status = "Passed";
			}

		}
		return statusFlag;		
	}
	
	private WebElement getWebElement(By by, boolean isCollectionFlag, int index){
		if(isCollectionFlag){
			return driver.findElements(by).get(index);
			
		}else{
			return driver.findElement(by);
		}
	}
	
	private String updateDynamicData(String data){
		String s1 = data.substring(data.indexOf("~")+1);
		if(s1.contains("~")){
			String key = "~"+s1.substring(0,s1.indexOf("~"))+"~";
			if(configurationReader.getDynamicValueMap().containsKey(key)){
				String val = configurationReader.getDynamicValueMap().get(key);
				data = data.replaceAll(key, val);
				System.out.println("Data " + data);
			}
		}
		return data;
	}
	
	private String updateIdentifier(String identifier){
		String s1 = identifier.substring(identifier.indexOf("~")+1);
		if(s1.contains("~")){
			String key = "~"+s1.substring(0,s1.indexOf("~"))+"~";
			if(configurationReader.getDynamicValueMap().containsKey(key)){
				String val = configurationReader.getDynamicValueMap().get(key);
				identifier = identifier.replaceAll(key, val);
				System.out.println("Identifier " + identifier);
			}			
		}
		
		return identifier;
	}
	
	public void waitForElementPresent(WebDriver driver, String identifierType, String identifier){
		try{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(WebDriverUtil.getByElement(identifierType, identifier)));

		}catch(Exception e){
			System.out.println(identifierType + " +++ " + identifier);
			System.out.println(e.getMessage());
			throw e;
		}
	}
	
	public static void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
	}

	public void scroll() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, 250)");
	}

	public void actionBuilder(WebElement obj) {
		Actions builder = new Actions(driver);
		builder.moveToElement(obj).click(obj).build().perform();

	}

	public void action(WebElement obj, String data, int parseInt) {
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(obj, Integer.parseInt(data), 0).build().perform();
	}

	public void select(WebElement obj, String data) {
		Select sel = new Select(obj);
		sel.selectByVisibleText(data);
	}

	public void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void cancelAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public void moveToElement(WebElement obj) {
		Actions buider = new Actions(driver);
		buider.moveToElement(obj).perform();
	}

	public  void clickJavaScriptExecutor(WebElement obj) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", obj);
	}

	public int countWindowHandels() {
		Set<String> windows = driver.getWindowHandles();
		int windowCount = windows.size();
		return windowCount;

	}

	public boolean verifyText(String verifyXpath, String verifyData) {
		try {
			String actText = driver.findElement(By.xpath(verifyXpath))
					.getText().trim();

			if (verifyData.equals(actText.substring(0, verifyData.length()))) {
				return true;
			} else {
				return false;

			}
		} catch (Exception e) {
			return false;
		}
	}


	public boolean verifyImage(String obj) {
		List<WebElement> list = driver.findElements(By.xpath(obj));
		boolean status = true;
		if (list.size() > 0) {
			for (WebElement object : list) {
				if (object.isDisplayed()) {
				} else {
					status = false;
					break;
				}
			}
		} else {
			status = false;
		}
		return status;
	}

	public void waitforProcessing(int seconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, seconds);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("//div[contains(@id,'connection')][@class='iceOutConStatInactv']")));
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
