package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ecommerce.abastractcomponent.AbstractComponent;

public class ProductPage extends AbstractComponent{
	private WebDriver driver;
	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="header[id='header'] li:nth-child(3) a:nth-child(1)")
	private WebElement cart;
	@FindBy(css=".title.text-center")
	private WebElement productText;
	@FindBy(css=".col-sm-4")
	private WebElement products;
	@FindBy(css="a[href='/product_details/1']")
	private WebElement firstProduct;
	@FindBy(css="a[href='/product_details/2']")
	private WebElement secondProduct;
	@FindBy(css="#search_product")
	private WebElement searchBar;
	@FindBy(css="#submit_search")
	private WebElement searchButton;
	@FindBy(xpath="//a[@data-product-id='1']")
	private WebElement addToCart1;
	@FindBy(xpath="//a[@data-product-id='2']")
	private WebElement addToCart2;
	@FindBy(xpath="//button[normalize-space()='Continue Shopping']")
	private WebElement contiButton;
	@FindBy(xpath="//u[normalize-space()='View Cart']")
	private WebElement viewCart;
	@FindBy(xpath="(//span[@class='badge pull-right'])[1]")
	private WebElement womenCar;
	@FindBy(xpath="//a[normalize-space()='Men']")
	private WebElement menCar;
	@FindBy(css="a[href='/category_products/1']")
	private WebElement womenDress;
	@FindBy(css="a[href='/category_products/3']")
	private WebElement tshirts;
	@FindBy(css="a[href='/brand_products/Polo']")
	private WebElement polo;
	@FindBy(css="a[href='/brand_products/H&M']")
	private WebElement hm;
	
    public boolean isProdutsTextDisplayed() {
    	return productText.isDisplayed();
    }
    public boolean isProdutsDisplayed() {
    	return products.isDisplayed();
    }
    public ProductDetailPage clickOnFirstProduct() {
    	

    	clickableOfWebElement(firstProduct);
    	
//    	firstProduct.click();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].click();", firstProduct);

    	ProductDetailPage productdetailpage = new ProductDetailPage(driver);
    	return productdetailpage;
    }
    public void  addingFirstItemToCart() {
    	Actions action = new Actions(driver);
    	action.moveToElement(firstProduct).perform();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].click();", addToCart1);
    	js.executeScript("arguments[0].click();", contiButton);
    	driver.navigate().refresh();
    	

    	


//    	clickableOfWebElement(addToCart1);
//    	addToCart1.click();
//    	contiButton.click();
    }
    public void  addingSecondItemToCart() {
    	Actions action = new Actions(driver);
    	action.moveToElement(secondProduct).perform();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].click();", addToCart2);
//    	js.executeScript("arguments[0].click();", contiButton);
    	js.executeScript("arguments[0].click();", viewCart);

//    	clickableOfWebElement(addToCart2);
//    	addToCart2.click();
//    	contiButton.click();
    }
    public void enterTheProductName(String pName) {
    	searchBar.sendKeys(pName);
    }
    public SearchedProductPage clickOnSearch() {
    	searchButton.click();
    	SearchedProductPage searchedproductpage = new SearchedProductPage(driver);
    	return searchedproductpage;
    }
    public void  navigateToCartPage() {
    	cart.click();
    	
        
    }
    
    public void click_women_cate() {
         womenCar.click();
    }
    public void click_dress_under_women_cate() {
         womenDress.click();
    }
    public void click_men_cate() {
    	menCar.click();
    }
    public void click_tshirts_under_men_cate() {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].click();",tshirts);
    }
    public void click_one_brand() {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	WebElement poloBrand = driver.findElement(By.xpath("//a[text()='Polo']"));
    	js.executeScript("arguments[0].click();", poloBrand);

    }
    public void click_other_brand() {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	WebElement hmBrand = driver.findElement(By.xpath("//a[text()='H&M']"));
    	js.executeScript("arguments[0].click();", hmBrand);


    }
   
    
    
    
}
