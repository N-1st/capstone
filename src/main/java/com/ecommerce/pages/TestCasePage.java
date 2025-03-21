package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCasePage {
	private WebDriver driver ;
	public TestCasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//b[normalize-space()='Test Cases']")
	private WebElement testCase;
	
	public String visibilityOfTestCases() {
		return testCase.getText();
		
	}

}
