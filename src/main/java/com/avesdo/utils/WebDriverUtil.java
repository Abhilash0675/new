package com.avesdo.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtil
{

	public static final String IDENTIFIER_TYPE_XPATH = "xpath";
	public static final String IDENTIFIER_TYPE_ID = "id";
	public static final String IDENTIFIER_TYPE_NAME = "name";
	public static final String IDENTIFIER_TYPE_TAG_NAME = "tag_name";
	public static final String IDENTIFIER_TYPE_CLASS_NAME = "class_name";
	public static final String IDENTIFIER_TYPE_CSS_SELECTOR = "css_selector";
	public static final String IDENTIFIER_TYPE_LINK_TEXT = "link_text";
	public static final String IDENTIFIER_TYPE_PARTIAL_LINK_TEXT = "partial_link_text";
	
	
	public static By getByElement(String identifierType, String identifier)
	{	
		By by = null;
		if(IDENTIFIER_TYPE_XPATH.equalsIgnoreCase(identifierType)){
			by = By.xpath(identifier);
		}else if(IDENTIFIER_TYPE_ID.equalsIgnoreCase(identifierType)){
			by = By.id(identifier);
		}else if(IDENTIFIER_TYPE_NAME.equalsIgnoreCase(identifierType)){
			by = By.name(identifier);
		}else if(IDENTIFIER_TYPE_TAG_NAME.equalsIgnoreCase(identifierType)){
			by = By.tagName(identifier);
		}else if(IDENTIFIER_TYPE_CLASS_NAME.equalsIgnoreCase(identifierType)){
			by = By.className(identifier);
		}else if(IDENTIFIER_TYPE_CSS_SELECTOR.equalsIgnoreCase(identifierType)){
			by = By.cssSelector(identifier);
		}else if(IDENTIFIER_TYPE_LINK_TEXT.equalsIgnoreCase(identifierType)){
			by = By.linkText(identifier);
		}else if(IDENTIFIER_TYPE_PARTIAL_LINK_TEXT.equalsIgnoreCase(identifierType)){
			by = By.partialLinkText(identifier);
		}
		return by;
		
	}

}
