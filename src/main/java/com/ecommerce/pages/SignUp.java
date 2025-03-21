package com.ecommerce.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUp {
	private WebDriver driver;
	
	public SignUp(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(css="div[class='signup-form'] h2")
	private WebElement signUp;
	@FindBy(css="input[data-qa='signup-name']")
	private WebElement customerName;
	@FindBy(css="input[data-qa='signup-email']")
	private WebElement customerEmail;
	@FindBy(css="button[data-qa='signup-button']")
	private WebElement signUpButton;
	@FindBy(xpath="//h2[normalize-space()='Login to your account']")
	private WebElement login;
	@FindBy(css="input[data-qa='login-email']")
	private WebElement lcustomerName;
	@FindBy(css="input[placeholder='Password']")
	private WebElement lcustomerPassword;
	@FindBy(css="button[data-qa='login-button']")
	private WebElement loginButton;
	@FindBy(xpath="//p[normalize-space()='Your email or password is incorrect!']")
	private WebElement errorText;
	@FindBy(xpath="//p[contains(text(),'Email Address already exist!')]")
	private WebElement errorEmail;
	
	
	public boolean isSignUpVisible() {
		WebElement ele=new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(signUp));
		return ele.isDisplayed();
	}
	public void signUpWithDetails(String name,String email) {
		customerName.sendKeys(name);
		customerEmail.sendKeys(email);
		
		
		
	}
	public AccountCreationPage signingUp() {
		signUpButton.click();
		AccountCreationPage acp = new AccountCreationPage(driver);
		return acp;
		
	}
	public boolean isLoginFormVisible() {
		
		return login.isDisplayed();
	}
	public void loginWithCredentials(String email, String password) {
		lcustomerName.sendKeys(email);
		lcustomerPassword.sendKeys(password);		
		
	}
	public LoginPage submitLogin() {
		loginButton.click();
		LoginPage login = new LoginPage(driver);
		return login;
	}
	public void loginWithWrongCredentials(String email,String Password) {
		lcustomerName.sendKeys(email);
		lcustomerPassword.sendKeys(Password);
	}
	public boolean visibilityOfErrorText() {
		return errorText.isDisplayed();
	}
	public boolean isEmailAlreadyExistsErrorVisible() {
	    
	    return errorEmail.isDisplayed();
	}


}
