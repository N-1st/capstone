package com.ecommerce.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.abastractcomponent.AbstractComponent;

public class ContactPage extends AbstractComponent {
	private WebDriver driver;
	
	public ContactPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(css="div[class='contact-form'] h2[class='title text-center']")
	private WebElement getText;
	@FindBy(css="input[placeholder='Name']")
	private WebElement name;
	@FindBy(css="input[placeholder='Email']")
	private WebElement email;
	@FindBy(css="input[placeholder='Subject']")
	private WebElement subject;
	@FindBy(id="message")
	private WebElement message;
	@FindBy(css="input[value='Submit']")
	private WebElement submit;
	@FindBy(css="input[name='upload_file']")
	private WebElement  choosefile;
	
	public boolean getInTouch() {
		return getText.isDisplayed();
	}
	public void uploadDetails(String Name,String Email,String Subject,String Message,String path) {
		name.sendKeys(Name);
		email.sendKeys(Email);
		subject.sendKeys(Subject);
		message.sendKeys(Message);
		choosefile.sendKeys(path);
		
		
	}
	public void submit() {
		clickableOfWebElement(submit);
		submit.click();
		
	}
	public ContactFeedback clickOk() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		ContactFeedback contactfeedback = new ContactFeedback(driver);
		return contactfeedback;
	}

}
