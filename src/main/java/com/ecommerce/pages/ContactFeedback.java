package com.ecommerce.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.abastractcomponent.AbstractComponent;
public class ContactFeedback extends AbstractComponent{
	private WebDriver driver;
	
	public ContactFeedback(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css=".status.alert.alert-success")
	private WebElement  sucessTxt;
	
	public String sucessTextMessage() {
		return sucessTxt.getText();
	}
	
	
	
	
	
}