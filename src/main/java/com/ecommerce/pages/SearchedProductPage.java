package com.ecommerce.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchedProductPage {
	private WebDriver driver;
	
	public SearchedProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".product-image-wrapper")
	private List<WebElement> searchedProduct;
	
	public boolean searchedProducts() {
		if(searchedProduct.size() > 0) {
			return true;
		}
		else {
			return false;
			
		}
		
	}

}
