package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeletedPage {
	private WebDriver driver;
	
	public DeletedPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="h2[class='title text-center'] b")
	private WebElement accountDeletedText;
	@FindBy(css="a[data-qa='continue-button']")
	private WebElement continueClick;
	
	
	public boolean isAccountDeletedVisible() {
		return accountDeletedText.isDisplayed();
		
	}
	public void clickOnContinue() {
		continueClick.click();
		
	}

}
