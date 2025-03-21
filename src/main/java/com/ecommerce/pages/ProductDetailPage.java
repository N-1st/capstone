package com.ecommerce.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage {
	WebDriver driver;
	public ProductDetailPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(css="div[class='product-information'] h2")
	private WebElement productName;

	@FindBy(xpath="//section/div/div/div[2]/div[2]/div[2]/div/p[1]")
	private WebElement productCategory;

	@FindBy(css="div[class='product-information'] span span")
	private WebElement productPrize;
	@FindBy(xpath="//b[normalize-space()='Availability:']")
	private WebElement productAvailability;
	@FindBy(xpath="//div[@class='product-details']//p[3]")
	private WebElement productCondition;
	@FindBy(xpath="//div[@class='product-details']//p[4]")
	private WebElement productBrand;
	@FindBy(css="button[type='button']")
	private WebElement cart;
	@FindBy(id = "quantity")
	private WebElement quantityInput;

	@FindBy(css = "button[class='btn btn-default cart']")
	private WebElement addToCartButton;

	@FindBy(css = "a[href='/view_cart'] u")
	private WebElement viewCartButton;

	@FindBy(css = "a[href='#reviews']")
	private WebElement writeYourReview;

	@FindBy(id = "name")
	private WebElement yourNameInput;

	@FindBy(id = "email")
	private WebElement emailAddress;

	@FindBy(id = "review")
	private WebElement addReviewHere;

	@FindBy(id = "button-review")
	private WebElement submitButton;
	@FindBy(xpath="//u[normalize-space()='View Cart']")
	private WebElement viewCart;

	@FindBy(css = "div[class='alert-success alert'] span")
	private WebElement successMessage;
	@FindBy(css="a[href='#reviews']")
	private WebElement writeReview;
	@FindBy(id="name")
	private WebElement rName;
	@FindBy(id="email")
	private WebElement rMail;
	@FindBy(id="review")
	private WebElement rReview;
	@FindBy(id="button-review")
	private WebElement submit;

	public boolean isProdutNameDisplayed() {
		return productName.isDisplayed();
	}
	public boolean isProdutCategoryDisplayed() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productCategory.isDisplayed();
	}
	public boolean isProdutPrizeDisplayed() {
		return productPrize.isDisplayed();
	}
	public boolean isProdutsAvailabilityDisplayed() {
		return productAvailability.isDisplayed();
	}
	public boolean isProdutConditionDisplayed() {
		return productCondition.isDisplayed();
	}
	public boolean isProdutBrandDisplayed() {
		return productBrand.isDisplayed();
	}
	public boolean isLandedOnProductDetailPage() {
		return cart.isDisplayed();
	}
	public void increase_quantity(String  n) {
		quantityInput.clear();

		quantityInput.sendKeys(n);
	}
	public void viewCart() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", viewCart);
	}
	public boolean isWriteReviewIsDisplayed() {
		return writeReview.isDisplayed();
	}
	public void fillTheReviewDetails(String name,String email,String msg) {
		rName.sendKeys(name);
		rMail.sendKeys(email);
		rReview.sendKeys(msg);
		
	}
	public PaymentPage submit() {
		submit.click();
		return new PaymentPage(driver);
		
	}


}
