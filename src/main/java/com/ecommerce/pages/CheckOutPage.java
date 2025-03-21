package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.abastractcomponent.AbstractComponent;

public class CheckOutPage extends AbstractComponent {
WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver= driver;	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="ul[id='address_delivery'] li[class='address_firstname address_lastname']")
	private WebElement nameVerify;
	@FindBy(css="textarea[name='message']")
	private WebElement description;
	@FindBy(css=".btn.btn-default.check_out")
	private WebElement placeBtn;
	@FindBy(css="//u[normalize-space()='Register / Login']")
	private WebElement register;
	
	public String verifyNameOnAddress() {
		String name = nameVerify.getText();
		return name;
		
	}
	public void enteringDescription() {
		description.sendKeys("Take my order with in Time");
		
		
		
	}
	public PaymentPage PlacingOrder() {
		
		placeBtn.click();
		PaymentPage paymentpage = new PaymentPage(driver);
		return paymentpage;
		
		
	}
	
	public SignUp clickOnRegisterOrLogin() {
		register.click();
		return new SignUp(driver);
	}

}
