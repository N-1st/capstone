package com.ecommerce.abastractcomponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.ecommerce.utils.WebDriverManager;


public class AbstractComponent {
	
	WebDriver driver ;
	
	public AbstractComponent(WebDriver driver) {
		this.driver =WebDriverManager.getDriver();
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(css="a[href='/products']")
	WebElement products;
	@FindBy(css="header[id='header'] li:nth-child(3) a:nth-child(1)")
	WebElement cart;
	@FindBy(css="header[id='header'] li:nth-child(1) a:nth-child(1)")
	WebElement Home;
	@FindBy(css="header[id='header'] li:nth-child(8)")
	WebElement contactus;
	@FindBy(css="li:nth-child(5) a:nth-child(1)")
	WebElement deleteAccount;
	
	
	public boolean isHomePageIsVisible() {
		return driver.getTitle().equals("Automation Exercise");
		
	}
	
	
	
	public void gotowebsite() {
		driver.get("https://automationexercise.com/");
		
	}
	public void goToHome() {
		Home.click();
	}
	public void deleteAccount() {
		deleteAccount.click();
	}
	public void goToProducts() {
		products.click();
	}
	public void contact() {
		contactus.click();
		
	}
	public void goToCart() {
		cart.click();
	}
	@FindBy(css="div[class='single-widget'] h2")
	WebElement subscription;
	@FindBy(css="#susbscribe_email")
	WebElement sendmail;
	@FindBy(css=".fa.fa-arrow-circle-o-right")
	WebElement arrow;
	public void visibilityWaitForWebElement(WebElement el) {
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(el));
	}
	public void visibilityWaitForlocator(By findBy) {
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(findBy));
		
	}
	public void clickableOfWebElement(WebElement el) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(el));
	}
	public void clickableOfLocator(By el) {
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(el));
	}
	public void invisibleWaitLocator(By loc) {
		new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions.invisibilityOfElementLocated(loc));
	}
	public void goToLast() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);
	}
	public String verifySubscriptionText() {
		String text = subscription.getText();
		return text;
	}
	public void enterMail(String mail) {
		sendmail.sendKeys(mail);
		
	}
	public void clickArrow() {
		arrow.click();
	}
	

}
