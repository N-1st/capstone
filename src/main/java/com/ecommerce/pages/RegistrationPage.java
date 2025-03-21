package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.ecommerce.abastractcomponent.AbstractComponent;

public class RegistrationPage extends AbstractComponent  {
	private WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		super(driver);
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(css="a[href='/login']")
	private WebElement signuporLoginButton;
	@FindBy(css="a[href='/contact_us']")
	private WebElement contactform;
	@FindBy(css="a[href='/test_cases']")
	private WebElement testcase;
	@FindBy(css="a[href='/products']")
	private WebElement products;
	@FindBy(css="header[id='header'] li:nth-child(3) a:nth-child(1)")
	private WebElement cart;
	@FindBy(css="#scrollUp")
	private WebElement scrollup;
	
	
	
	public SignUp navigateToSignUpPage() {
		clickableOfWebElement(signuporLoginButton);
		signuporLoginButton.click();
		SignUp signup = new SignUp(driver);
		return signup;
	}
	public ContactPage navigateToContactPage() {
		contactform.click();
		ContactPage contactpage = new ContactPage(driver);
		return contactpage;
		
	}
	
	public TestCasePage navigateToTestCasePage() {
		testcase.click();
		TestCasePage testcasepage = new TestCasePage(driver);
		return testcasepage;
		
	}
	public ProductPage navigateToProdutsPage() {
		products.click();
		ProductPage productpage = new ProductPage(driver);
		return productpage;
		
	}
	public CartPage navigateToCartPage() {
		cart.click();
		CartPage cartpage = new CartPage(driver);
		return cartpage;
		
	
	}
	public ProductPage isRecommendedDisplayed(String message) throws InterruptedException {
    	if (driver.getPageSource().contains(message)) {
			System.out.println("Message found: " + message);
		} else {
			System.out.println(" Expected message not found: " + message);
		}
		Thread.sleep(5000);
		return new ProductPage(driver);
    }
	public void addRecommendedProduct() {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	WebElement add_to_cart= driver.findElement(By.xpath("//*[@id=\"recommended-item-carousel\"]/div/div[2]/div[1]/div/div/div/a"));
    	js.executeScript("arguments[0].click();", add_to_cart);
    }
	public ProductPage viewCartForRecommended() {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	WebElement view_cart= driver.findElement(By.tagName("u"));
    	js.executeScript("arguments[0].click();", view_cart);
    	driver.navigate().refresh();
    	return new ProductPage(driver);

    }
	public void scrollDown() throws InterruptedException {
		Actions actions = new Actions(driver);
		 actions.scrollByAmount(0, 7000).perform(); 
		 Thread.sleep(3000);
	}
	public void scrollUp() {
		 Actions actions = new Actions(driver);
		 actions.scrollByAmount(0, -7000).perform();
	}
	 public void user_scrolls_down_to_footer() throws InterruptedException {
   	  JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
         Thread.sleep(2000);
     }
	 public void goToTop() {
		 scrollup.click();
	 }
	
	

}
