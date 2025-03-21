package com.ecommerce.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ecommerce.abastractcomponent.AbstractComponent;

import io.netty.handler.timeout.TimeoutException;

public class CartPage extends AbstractComponent {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver= driver;	
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css = ".btn.btn-default.check_out")
	private WebElement checkOutBtn;

	@FindBy(css="a[href='/product_details/1']")
	private WebElement firstProduct;
	
	@FindBy(css="a[href='/product_details/2']")
	private WebElement secondProduct;
	@FindBy(xpath="//u[normalize-space()='Register / Login']")
	private WebElement clickToRegister;

	private By prod_in_cart=By.xpath("//*[@id=\"cart_items\"]");
	private  By prod_price=By.xpath("//td[@class='cart_price']/p");
	private By prod_quant=By.cssSelector(".disabled");
//    By prod_quant=By.xpath("//td[@class='cart_quantity']/button");
	private By prod_total=By.xpath("//td[@class='cart_total']/p");
	private By remove=By.xpath("//*[@id=\"product-1\"]/td[6]/a/i");
	private  By productRow = By.xpath("//tr[@class='cart_item']");
	
	
	public boolean isFirstProductDisplayed() {
		return firstProduct.isDisplayed();
	}
	public boolean isSecondProductDisplayed() {
		return secondProduct.isDisplayed();
	}
	
	public CheckOutPage goToCheckOut() {
		checkOutBtn.click();
		
        return new CheckOutPage(driver);
       
		
	}
	public void clickToRegister() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", clickToRegister);
	}
	
    

	public boolean check_cart_details() {
    	String price1 = driver.findElements(prod_price).get(0).getText();
        String price2 = driver.findElements(prod_price).get(1).getText();
        String quantity1 = driver.findElements(prod_quant).get(0).getText();
        String quantity2 = driver.findElements(prod_quant).get(1).getText();
        String total1 = driver.findElements(prod_total).get(0).getText();
        String total2 = driver.findElements(prod_total).get(1).getText();
        System.out.println("Price1: " + price1 + " | Quantity1: " + quantity1 + " | Total1: " + total1);
        System.out.println("Price2: " + price2 + " | Quantity2: " + quantity2 + " | Total2: " + total2);

        return !price1.isEmpty() && !price2.isEmpty() &&
                !quantity1.isEmpty() && !quantity2.isEmpty() &&
                !total1.isEmpty() && !total2.isEmpty();


    	
    }
	public boolean check_corr_quant(String s) {
		try {
			List<WebElement> quantities = driver.findElements(prod_quant);
			if (!quantities.isEmpty()) {
				String quantity = quantities.get(0).getText();
				return quantity.equals(s); // Use equals for String comparison
			}
			return false;
		} catch (Exception e) {
			System.out.println("Failed to verify quantity: " + e.getMessage());
			return false;
		}
		
	}
	public void remove_from_cart() {
		driver.findElement(remove).click();
	}
	public boolean remove_verify() throws TimeoutException {
		invisibleWaitLocator(productRow);
		return true;
	}

}
