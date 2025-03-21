package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.abastractcomponent.AbstractComponent;

public class LoginPage extends AbstractComponent{
	private WebDriver driver;
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(css="header[id='header'] li:nth-child(4)")
	private WebElement logoutButton;
//	@FindBy(css="li:nth-child(10) a:nth-child(1)")
//	@FindBy(xpath="//header[@id='header']//li[10]//a[1]")
	@FindBy(xpath="//li[10]//a[1]")
	private WebElement loggedText;
	
	public void logout() {
		logoutButton.click();
		return ;
	}
	public boolean   isUserLoggedIn() {
		return loggedText.isDisplayed();
		
		
		
	}
	
	

}
