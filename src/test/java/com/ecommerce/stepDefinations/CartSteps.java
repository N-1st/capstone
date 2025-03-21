package com.ecommerce.stepDefinations;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import com.ecommerce.pages.AccountCreationPage;
import com.ecommerce.pages.CartPage;
import com.ecommerce.pages.CheckOutPage;
import com.ecommerce.pages.ContactFeedback;
import com.ecommerce.pages.ContactPage;
import com.ecommerce.pages.CreatedPage;
import com.ecommerce.pages.DeletedPage;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.PaymentPage;
import com.ecommerce.pages.ProductDetailPage;
import com.ecommerce.pages.ProductPage;
import com.ecommerce.pages.RegistrationPage;
import com.ecommerce.pages.SearchedProductPage;
import com.ecommerce.pages.SignUp;
import com.ecommerce.pages.TestCasePage;
import com.ecommerce.utils.WebDriverManager;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartSteps {
	WebDriver driver;

	RegistrationPage register;
	SignUp signup;
	AccountCreationPage acp;
	CreatedPage createdpage;
	DeletedPage deletedpage;
	LoginPage login;
	ContactPage contactpage;
	ContactFeedback contactfeedback;
	TestCasePage testcasepage;
	ProductPage productpage;
	ProductDetailPage productdetailpage;
	SearchedProductPage searchedproductpage;
	CartPage cartpage;
	CheckOutPage checkout;
	PaymentPage paymentpage;



	@Before
	public void setUpDriver() {
//		System.setProperty("webdriver.chrome.driver", "F:\\selinium\\chrome.exe\\chromedriver-win64\\chromedriver.exe");
//		driver=new ChromeDriver();
//		register=new RegistrationPage(driver);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver = WebDriverManager.getDriver();
	    register=new RegistrationPage(driver);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		register = new RegistrationPage(driver);
		signup = new SignUp(driver);
		acp = new AccountCreationPage(driver);
		createdpage = new CreatedPage(driver);
		deletedpage = new DeletedPage(driver);
		login = new LoginPage(driver);
		contactpage = new ContactPage(driver);
		contactfeedback = new ContactFeedback(driver);
		testcasepage = new TestCasePage(driver);
		productpage = new ProductPage(driver);
		productdetailpage = new ProductDetailPage(driver);
		searchedproductpage = new SearchedProductPage(driver);
		cartpage = new CartPage(driver);



	}
	

	@When("User clicks on Signup Login button in cart")
	public void user_clicks_on_signup_login_button_in_cart() {
	    // Write code here that turns the phrase above into concrete actions
		
		signup = register.navigateToSignUpPage();
//	    throw new io.cucumber.java.PendingException();
	}



	@Given("User is on the homepage for cart")
	public void user_is_on_the_homepage() {
		// Write code here that turns the phrase above into concrete actions
		driver.get("https://automationexercise.com");
		//		register.gotowebsite();
		//	    throw new io.cucumber.java.PendingException();
	}
	@Then("Verify New User Signup is visible in cart")
	public void verify_new_user_signup_is_visible() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(signup.isSignUpVisible(),"It is not visible");
//	    throw new io.cucumber.java.PendingException();
	}
	@When("User clicks Signup button in cart")
	public void user_clicks_signup_button() {
	    // Write code here that turns the phrase above into concrete actions
		acp=signup.signingUp();
//	    throw new io.cucumber.java.PendingException();
	}


	@Then("Verify ENTER ACCOUNT INFORMATION is visible in cart")
	public void verify_enter_account_information_is_visible() {
	    // Write code here that turns the phrase above into concrete actions
		String text = acp.textIsVisible();
		System.out.println(text);
		Assert.assertEquals(text,"ENTER ACCOUNT INFORMATION");
//	    throw new io.cucumber.java.PendingException();
	}

	@When("User fills account information in cart")
	public void user_fills_account_information() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		acp.accountInformation("niranjan", 3,11, "2002");
//	    throw new io.cucumber.java.PendingException();
	}

	@When("User selects newsletter and special offers in cart")
	public void user_selects_newsletter_and_special_offers() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		acp.newsletter();
//	    throw new io.cucumber.java.PendingException();
	}

	@When("User fills address information in cart")
	public void user_fills_address_information() {
	    // Write code here that turns the phrase above into concrete actions
		acp. allInformation("Niranjan", "reddy","", "1/68,gopa peta","India","AndhraPradesh", "Kurnool","518010","8309887959");
//	    throw new io.cucumber.java.PendingException();
	}
	@When("User clicks Create Account button in cart")
	public void user_clicks_create_account_button() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		createdpage = acp.createAccount();
//	    throw new io.cucumber.java.PendingException();
	}

	@Then("Verify ACCOUNT CREATED is visible in cart")
	public void verify_account_created_is_visible() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(createdpage.isAccountCreatedIsVisible(),"Not Created");
//	    throw new io.cucumber.java.PendingException();
	}

    @When("User clicks Continue button to create in cart")
    public void user_clicks_continue_button() {
        // Write code here that turns the phrase above into concrete actions
    	createdpage.clickOnContinue();
//        throw new io.cucumber.java.PendingException();
    }
    @Then("Verify Logged in as username is visible in cart")
    public void verify_logged_in_as_username_is_visible() {
        // Write code here that turns the phrase above into concrete actions
    	Assert.assertTrue(createdpage.isUserLoggedIn());
//        throw new io.cucumber.java.PendingException();
    }
    @When("User clicks Delete Account button in cart")
	public void user_clicks_delete_account_button() {
	    // Write code here that turns the phrase above into concrete actions
		createdpage.deleteAccount();
		deletedpage = new DeletedPage(driver);
//	    throw new io.cucumber.java.PendingException();
	}

    @Then("Verify ACCOUNT DELETED is visible in cart")
    public void verify_account_deleted_is_visible() {
        // Write code here that turns the phrase above into concrete actions
    	Assert.assertTrue(deletedpage.isAccountDeletedVisible());
//        throw new io.cucumber.java.PendingException();
    }

	@Then("User click Continue button in cart")
	public void user_click_continue_button() {
	    // Write code here that turns the phrase above into concrete actions
		deletedpage.clickOnContinue();
//	    throw new io.cucumber.java.PendingException();
	}
    
	@Then("Verify Login form is visible in cart")
	public void verify_login_form_is_visible() {
	    Assert.assertTrue(signup.isLoginFormVisible(), "Login form is not visible");
	}

	@When("User enters valid email {string} and password {string} in cart")
	public void user_enters_valid_email_and_password(String email, String password) {
	    signup.loginWithCredentials(email, password);
	}

	@When("User clicks Login button in cart")
	public void user_clicks_login_button() {
	    login = signup.submitLogin();
	}
    @Then("Verify Logged in as username is visible after correct details in cart")
    public void verify_logged_in_as_username_is_visible_after_correct_details() {
        // Write code here that turns the phrase above into concrete actions
    	Assert.assertTrue(login.isUserLoggedIn());
//        throw new io.cucumber.java.PendingException();
    }
	@When("Click Products button in cart")
	public void click_products_button() {
		productpage =register.navigateToProdutsPage();
	}
	@When("Hover over first product and click Add to cart and Click Continue Shopping button")
	public void Hover_over_first_product_and_click_Add_to_cart_and_Click_Continue_Shopping_button(){
		productpage.addingFirstItemToCart();



	}
	@When("User enters name {string} and email {string} in cart")
	public void user_enters_name_and_email(String Name,String Email) {
	    // Write code here that turns the phrase above into concrete actions
		signup.signUpWithDetails(Name, Email);
//	    throw new io.cucumber.java.PendingException();
	}

	@When("Hover over second product and click Add to cart and Click View Cart button")
	public void hover_over_second_product_and_click_add_to_cart_and_click_view_cart_button() {
	    // Write code here that turns the phrase above into concrete actions
		productpage.addingSecondItemToCart();
//		cartpage = register.navigateToCartPage();
//	    throw new io.cucumber.java.PendingException();
	}
	@When("user goes to cart page in cart")
    public void user_goes_to_cart_page() {
    	cartpage = register.navigateToCartPage();
    }
	@Then("Verify both products are added to Cart")
	public void verify_both_products_are_added_to_cart() {
		Assert.assertTrue(cartpage.isFirstProductDisplayed(),"not displayed");
		Assert.assertTrue(cartpage.isSecondProductDisplayed(),"not displayed");


	}
	@Then("Verify their prices, quantity and total price")
	public void verify_their_prices_quantity_and_total_price() {
		cartpage.check_cart_details();

	}
	

	@When("Click Proceed To Checkout button in cart")
	public void click_proceed_to_checkout_button() {
		checkout = cartpage.goToCheckOut();
	}
	@When ("user click to register")
	public void user_click_to_register() {
		cartpage.clickToRegister();
	}
	@Then("Verify Address Details and Review Your Order")
	public void verify_address_details_and_review_your_order() {
		Assert.assertEquals(checkout.verifyNameOnAddress(), "Mr. Niranjan reddy");
	}
	@When("Enter description in comment text area and click Place Order")
	public void enter_description_in_comment_text_area_and_click_Place_Order() {
		checkout.enteringDescription();
		paymentpage = checkout.PlacingOrder();
	}

	@When("Enter payment details: Name on Card, Card Number, CVC, Expiration date")
	public void enter_payment_details_name_on_card_card_number_cvc_expiration_date() {
	    // Write code here that turns the phrase above into concrete actions
		paymentpage.addAllDetails();
//	    throw new io.cucumber.java.PendingException();
	}
	@When("Click Pay and Confirm Order button")
	public void click_pay_and_confirm_order_button() {
		paymentpage.submitOrder();
	}

	@Then("Verify success message {string}")
	public void verify_success_message(String string) {
	    // Write code here that turns the phrase above into concrete actions
		paymentpage.verifyMessage(string);
//	    throw new io.cucumber.java.PendingException();
	}
	@When("Click x button corresponding to particular product")
	public void click_x_button_corresponding_to_particular_product() {
	    // Write code here that turns the phrase above into concrete actions
		cartpage.remove_from_cart();
//	    throw new io.cucumber.java.PendingException();
	}
	@Then("Verify that product is removed from the cart")
	public void verify_that_product_is_removed_from_the_cart() {
	    // Write code here that turns the phrase above into concrete actions
		cartpage.remove_verify();
//	    throw new io.cucumber.java.PendingException();
	}
	@When("user clicks on women category")
	public void user_clicks_on_women_category() {
	    // Write code here that turns the phrase above into concrete actions
		productpage.click_women_cate();
		
		
//	    throw new io.cucumber.java.PendingException();
	}
	@And("user selects dress category under that")
	public void user_selects_dress_category_under_that() {
	    // Write code here that turns the phrase above into concrete actions
		productpage.click_dress_under_women_cate();
//	    throw new io.cucumber.java.PendingException();
	}
	@Then("check {string} is visible or not")
	public void check_women_dress_products_is_visible_or_not(String str) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		 if (driver.getPageSource().contains(str)) {
				System.out.println("Message found: " + str);
			} else {
				System.out.println(" Expected message not found: " + str);
			}
		 Thread.sleep(5000);


		
//	    throw new io.cucumber.java.PendingException();
	}


	@When("user selects men category")
	public void user_selects_men_category() {
	    // Write code here that turns the phrase above into concrete actions
		productpage.click_men_cate();
//	    throw new io.cucumber.java.PendingException();
	}
	@And("user selects tshirts category under that")
	public void user_selects_jeans_category_under_that() {
	    // Write code here that turns the phrase above into concrete actions
		productpage.click_tshirts_under_men_cate();
//	    throw new io.cucumber.java.PendingException();
	}
	@When("user clicks on any brand")
	public void user_clicks_on_any_brand() {
	    // Write code here that turns the phrase above into concrete actions
		productpage.click_one_brand();
//	    throw new io.cucumber.java.PendingException();
	}
	@When("user selects other brand")
	public void user_selects_other_brand() {
	    // Write code here that turns the phrase above into concrete actions
		productpage.click_other_brand();
//	    throw new io.cucumber.java.PendingException();
	}
//	@Then("check {string} is visible or not")
//	public void check_is_visible_or_not(String string) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
	@When("Verify that the delivery address is same address filled at the time registration of account")
	public void verify_delivery_addr() {
		String expectedAddress = "YOUR DELIVERY ADDRESS\r\n"
				+ "Mr. Niranjan reddy\r\n"
				+ "1/68,gopa peta\r\n"
				+ "Kurnool AndhraPradesh 518010\r\n"
				+ "India\r\n"
				+ "8309887959";
		expectedAddress = expectedAddress.replaceAll("[\r\n]+", " ").trim();

        WebElement deliveryAddressElement = driver.findElement(By.id("address_delivery"));
        String deliveryAddress =deliveryAddressElement.getText().replaceAll("\\s+", " ").trim();

        Assert.assertEquals(deliveryAddress, expectedAddress, " Delivery address does not match signup details.");
	}
	
	@When("Verify that the billing address is same address filled at the time registration of account")
	public void verify_billing_addr() {
		String expectedAddress = "YOUR BILLING ADDRESS\r\n"
				+ "Mr. Niranjan reddy\r\n"
				+ "1/68,gopa peta\r\n"
				+ "Kurnool AndhraPradesh 518010\r\n"
				+ "India\r\n"
				+ "8309887959";
		expectedAddress = expectedAddress.replaceAll("[\r\n]+", " ").trim();

        WebElement deliveryAddressElement = driver.findElement(By.id("address_invoice"));
        String billingAddress =deliveryAddressElement.getText().replaceAll("\\s+", " ").trim();

        Assert.assertEquals(billingAddress, expectedAddress, " billing address does not match signup details.");
	}
	@When ("Click Download Invoice button and verify invoice is downloaded successfully")
	public void invoice_download() {
		paymentpage.invoice();
		String downloadPath = System.getProperty("user.home") + "\\Downloads\\invoice.pdf";

        // Check if the file exists
        File file = new File(downloadPath);

        if (file.exists()) {
            System.out.println("Invoice downloaded successfully!");
            // Optional: Delete the file after checking
            file.delete();
        } else {
            Assert.fail(" Invoice was not downloaded.");
        }

	}
	@When("Click Continue button")
	public void click_on_continue() {
		paymentpage.continu();
	}
	@When ("Enter product name {string} in search input and click search button in cart")
	public void enter_product_name_in_search_input_and_click_search_button(String pName) {
		productpage.enterTheProductName(pName);
		searchedproductpage = productpage.clickOnSearch();
	}
	@Then("Verify products list is visible in cart")
	public void verify_products_list_is_visible() {
		Assert.assertTrue(productpage.isProdutsDisplayed());
	}

	@Then("Verify SEARCHED PRODUCTS is visible in cart")
	public void verify_searched_products_is_visible() {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(searchedproductpage.searchedProducts()); 
		//        throw new io.cucumber.java.PendingException();
	}
	

			



}
