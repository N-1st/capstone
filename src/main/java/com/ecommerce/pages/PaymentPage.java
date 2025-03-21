package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.abastractcomponent.AbstractComponent;

public class PaymentPage extends AbstractComponent {
	WebDriver driver;

	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver= driver;	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[name='name_on_card']")
	private WebElement cardName;
	@FindBy(css="input[name='card_number']")
	private WebElement cardNumber;
	@FindBy(css="input[placeholder='ex. 311']")
	private WebElement cvc;
	@FindBy(css="input[placeholder='MM']")
	private WebElement mm;
	@FindBy(css="input[placeholder='YYYY']")
	private WebElement year;
	@FindBy(id="submit")
	private WebElement confirmOrder;
	@FindBy(css=".btn.btn-default.check_out")
	private WebElement invoi;
	@FindBy(css=".btn.btn-primary")
	private WebElement continueBtn;
	
	
	public void addAllDetails() {
		cardName.sendKeys("IndianBank");
		cardNumber.sendKeys("896556232145");
		cvc.sendKeys("654");
		mm.sendKeys("06");
		year.sendKeys("2028");
		
	}
	public void submitOrder() {
		confirmOrder.click();
	}
	public void verifyMessage(String message) {
		if(driver.getPageSource().contains(message)) {
			System.out.println("message found :"+message);
			
		}else {
			System.out.println("message Not Found");
		}
		
	}
	public void invoice() {
		invoi.click();
	}
	public void continu() {
		continueBtn.click();
	}


}
