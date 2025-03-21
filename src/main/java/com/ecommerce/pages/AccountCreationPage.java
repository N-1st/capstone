package com.ecommerce.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ecommerce.abastractcomponent.AbstractComponent;

public class AccountCreationPage extends AbstractComponent {
private WebDriver driver;
	
	public AccountCreationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(id="id_gender1")
	private WebElement gender;
	@FindBy(id="password")
	private WebElement password;
	@FindBy(id="days")
	private WebElement days;
	@FindBy(id="months")
	private WebElement months;
	@FindBy(id="years")
	private WebElement years;
	@FindBy(id="first_name")
	private WebElement firstName;
	@FindBy(id="last_name")
	private WebElement lastName;
	@FindBy(id="company")
	private WebElement company;
	@FindBy(id="address1")
	private WebElement address1;
	@FindBy(id="country")
	private WebElement countries;
	@FindBy(id="state")
	private WebElement state;
	@FindBy(id="city")
	private WebElement city;
	@FindBy(id="zipcode")
	private WebElement zipcode;
	@FindBy(id="mobile_number")
	private WebElement mobile_number;
	@FindBy(css=".btn.btn-default")
	private WebElement createAccount;
	@FindBy(id="newsletter")
	private WebElement select1;
	@FindBy(id="optin")
	private WebElement select2;
	@FindBy(css="body > section:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > h2:nth-child(1) > b:nth-child(1)\r\n")
	private WebElement text;
	
	public String textIsVisible() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > section:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > h2:nth-child(1) > b:nth-child(1)\r\n"
				+ "")));

		return text.getText();
	}
	
	public void accountInformation(String passwordInput,int nindex,int mvalue,String myear) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement gender = wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));
		gender.click();
		password.sendKeys(passwordInput);
		Select day = new Select(days);
		day.selectByIndex(nindex);
		Select month = new Select(months);
		month.selectByIndex(mvalue);
		Select year = new Select(years);
		year.selectByValue(myear);
	}
	public void newsletter() throws InterruptedException {
		
		clickableOfWebElement(select1);
		clickableOfWebElement(select2);
		select1.click();
		select2.click();
	}
	public void allInformation(String FirstName,String LastName,String companyName,String Address,String cvalue,String State,String City,String ZipCode,String MobileNumber) {
		
		
		firstName.sendKeys(FirstName);
		lastName.sendKeys(LastName);
		company.sendKeys(companyName);
		address1.sendKeys(Address);
		Select country = new Select(countries);
		country.selectByValue(cvalue);
		state.sendKeys(State);
		city.sendKeys(City);
		zipcode.sendKeys(ZipCode);
		mobile_number.sendKeys(MobileNumber);
		
		
		
	}
	public CreatedPage createAccount() throws InterruptedException {
		Thread.sleep(2000);
		createAccount.click();
		CreatedPage createdpage = new CreatedPage(driver);
		return createdpage;
	}

}
