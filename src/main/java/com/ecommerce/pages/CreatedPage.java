package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.ecommerce.abastractcomponent.AbstractComponent;

public class CreatedPage extends AbstractComponent {
	WebDriver driver;
	
	
	public CreatedPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(css="h2[data-qa='account-created'] b")
	private WebElement createdText;
	
	@FindBy(css=".btn.btn-primary")
	private WebElement continueButton;
	
	@FindBy(css="li:nth-child(5) a:nth-child(1)")
	private WebElement deleteAccount;
	@FindBy(css="li:nth-child(10) a:nth-child(1)")
	private WebElement loggedText;
	
	
	public boolean isAccountCreatedIsVisible() {
		return createdText.isDisplayed();
	}
	public void clickOnContinue() {
		continueButton.click();
		
	}
	public boolean   isUserLoggedIn() {
		return loggedText.isDisplayed();
		
		
		
	}
	
	

}
