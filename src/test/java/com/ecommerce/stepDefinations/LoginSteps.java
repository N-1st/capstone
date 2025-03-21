package com.ecommerce.stepDefinations;


import java.io.ByteArrayInputStream;
import java.time.Duration;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import com.ecommerce.pages.AccountCreationPage;
import com.ecommerce.pages.CartPage;
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

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;

public class LoginSteps {
	WebDriver driver;



	@Before
	public void setUpDriver() {
		//		System.setProperty("webdriver.chrome.driver", "F:\\selinium\\chrome.exe\\chromedriver-win64\\chromedriver.exe");
		//		driver=new ChromeDriver();
		driver = WebDriverManager.getDriver();

		register=new RegistrationPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}
	public void takeScreenshot(String fileName) {
		byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		Allure.addAttachment(fileName, new ByteArrayInputStream(screenshot));
	}

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
	PaymentPage paymentpage;




	@Given("User is on the homepage")
	public void user_is_on_the_homepage() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		register.gotowebsite();
		Thread.sleep(5000);
		//	    throw new io.cucumber.java.PendingException();
	}

	@When("User clicks on Signup Login button")
	public void user_clicks_on_signup_login_button() {
		// Write code here that turns the phrase above into concrete actions
		signup = register.navigateToSignUpPage();

		//	    throw new io.cucumber.java.PendingException();
	}
	@Then("Verify New User Signup is visible")
	public void verify_new_user_signup_is_visible() {
		// Write code here that turns the phrase above into concrete actions
		if(!signup.isSignUpVisible()) {
			takeScreenshot("sign up is not visible");

		}
		Assert.assertTrue(signup.isSignUpVisible(),"It is not visible");
		//	    throw new io.cucumber.java.PendingException();
	}
	@When("User enters name {string} and email {string}")
	public void user_enters_name_and_email(String Name,String Email) {
		// Write code here that turns the phrase above into concrete actions
		signup.signUpWithDetails(Name, Email);
		//	    throw new io.cucumber.java.PendingException();
	}

	@When("User clicks Signup button")
	public void user_clicks_signup_button() {
		// Write code here that turns the phrase above into concrete actions
		acp=signup.signingUp();
		//	    throw new io.cucumber.java.PendingException();
	}

	@Then("Verify ENTER ACCOUNT INFORMATION is visible")
	public void verify_enter_account_information_is_visible() {
		// Write code here that turns the phrase above into concrete actions
		String text = acp.textIsVisible();
		System.out.println(text);
		Assert.assertEquals(text,"ENTER ACCOUNT INFORMATION");
		//	    throw new io.cucumber.java.PendingException();
	}

	@When("User fills account information")
	public void user_fills_account_information() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		acp.accountInformation("niranjan", 3,11, "2002");
		//	    throw new io.cucumber.java.PendingException();
	}

	@When("User selects newsletter and special offers")
	public void user_selects_newsletter_and_special_offers() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		//		acp.newsletter();
		//	    throw new io.cucumber.java.PendingException();
	}

	@When("User fills address information")
	public void user_fills_address_information() {
		// Write code here that turns the phrase above into concrete actions
		acp. allInformation("Niranjan", "reddy","", "1/68,gopa peta","India","AndhraPradesh", "Kurnool","518010","8309887959");
		//	    throw new io.cucumber.java.PendingException();
	}
	@When("User clicks Create Account button")
	public void user_clicks_create_account_button() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		createdpage = acp.createAccount();
		//	    throw new io.cucumber.java.PendingException();
	}

	@Then("Verify ACCOUNT CREATED is visible")
	public void verify_account_created_is_visible() {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(createdpage.isAccountCreatedIsVisible(),"Not Created");
		//	    throw new io.cucumber.java.PendingException();
	}

	@When("User clicks Continue button to create")
	public void user_clicks_continue_button() {
		// Write code here that turns the phrase above into concrete actions
		createdpage.clickOnContinue();
		//        throw new io.cucumber.java.PendingException();
	}
	@Then("Verify Logged in as username is visible")
	public void verify_logged_in_as_username_is_visible() {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(createdpage.isUserLoggedIn());
		//        throw new io.cucumber.java.PendingException();
	}

	@When("User clicks Delete Account button")
	public void user_clicks_delete_account_button() {
		// Write code here that turns the phrase above into concrete actions
		createdpage.deleteAccount();
		deletedpage = new DeletedPage(driver);
		//	    throw new io.cucumber.java.PendingException();
	}

	@Then("Verify ACCOUNT DELETED is visible")
	public void verify_account_deleted_is_visible() {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(deletedpage.isAccountDeletedVisible());
		//        throw new io.cucumber.java.PendingException();
	}

	@Then("User click Continue button")
	public void user_click_continue_button() {
		// Write code here that turns the phrase above into concrete actions
		deletedpage.clickOnContinue();
		//	    throw new io.cucumber.java.PendingException();
	}

	@Then("Verify Login form is visible")
	public void verify_login_form_is_visible() {
		Assert.assertTrue(signup.isLoginFormVisible(), "Login form is not visible");
	}

	@When("User enters valid email {string} and password {string}")
	public void user_enters_valid_email_and_password(String email, String password) {
		signup.loginWithCredentials(email, password);
	}

	@When("User clicks Login button")
	public void user_clicks_login_button() {
		login = signup.submitLogin();
	}
	@Then("Verify Logged in as username is visible after correct details")
	public void verify_logged_in_as_username_is_visible_after_correct_details() {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(login.isUserLoggedIn());
		//        throw new io.cucumber.java.PendingException();
	}


	@When("User enters invalid email {string} and password {string}")
	public  void user_enters_invalid_email_and_password(String email,String password) {
		signup.loginWithWrongCredentials(email, password);

	}
	@Then ("Verify error message Your email or password is incorrect! is visible")
	public void verify_error_message_is_visible() {
		Assert.assertTrue(signup.visibilityOfErrorText());

	}

	@Then ("User return to home page")
	public void user_return_to_home_page() {
		login.goToHome();  

	}
	@When("User click on logout")
	public void user_click_on_logout() {
		// Write code here that turns the phrase above into concrete actions
		login.logout();

		//        throw new io.cucumber.java.PendingException();
	}


	@Then ("Verify error Email Address already exist! is visible with valid credentials")
	public void verify_error_email_address_already_exist_is_visible_with_valid_credentials() {
		Assert.assertTrue(signup.isEmailAlreadyExistsErrorVisible());

	}

	@When("Click on Contact Us button")
	public void click_on_contact_us_button() {
		// Write code here that turns the phrase above into concrete actions
		contactpage = register.navigateToContactPage();
		//        throw new io.cucumber.java.PendingException();
	}

	@Then("Verify GET IN TOUCH is visible")
	public void verify_get_in_touch_is_visible() {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(contactpage.getInTouch(),"Not Found");
		//        throw new io.cucumber.java.PendingException();
	}

	@When("User Enter {string} and {string} and {string} and {string} and {string}")
	public void user_enter_niru_and_and_and(String string,String string1, String string2, String string3,String string4) {
		// Write code here that turns the phrase above into concrete actions
		contactpage.uploadDetails(string, string1, string2, string3,string4);

		//        throw new io.cucumber.java.PendingException();
	}
	@When("user Click Submit button")
	public void user_click_submit_button() {
		// Write code here that turns the phrase above into concrete actions
		contactpage.submit();
		//        throw new io.cucumber.java.PendingException();
	}
	@When("user click Ok button")
	public void user_click_ok_button() {
		contactfeedback = contactpage.clickOk();
	}
	@Then("Verify success message 'Success! Your details have been submitted successfully.' is visible")
	public void verify_sucess_message_is_visible() {
		Assert.assertEquals(contactfeedback.sucessTextMessage(),"Success! Your details have been submitted successfully.");
	}
	@Then("Click Home button and verify that landed to home page successfully")
	public void click_home_button_and_verify_that_landed_to_home_page_sucessfully() {
		contactfeedback.goToHome();
	}
	@When ("user click on TestCases button")
	public void user_click_on_testcases_button() {
		testcasepage =register.navigateToTestCasePage();
	}
	@Then("verify user is navigated to test cases page sucessfully")
	public void verify_user_is_navigated_to_test_cases_page_sucessfully() {
		// Write code here that turns the phrase above into concrete actions
		//        throw new io.cucumber.java.PendingException();
		Assert.assertEquals(testcasepage.visibilityOfTestCases(), "TEST CASES");
	}
	@When("Click on Products button")
	public void click_on_products_button() {
		productpage =register.navigateToProdutsPage();
	}
	@Then("Verify user is navigated to ALL PRODUCTS page successfully")
	public void verify_user_is_navigated_to_all_products_page_sucessfully() {
		Assert.assertTrue(productpage.isProdutsTextDisplayed());
	}
	@Then("Verify products list is visible")
	public void verify_products_list_is_visible() {
		Assert.assertTrue(productpage.isProdutsDisplayed());
	}
	@When("Click on View Product of first product")
	public void click_on_view_product_of_first_product() {
		// Write code here that turns the phrase above into concrete actions
		productdetailpage =productpage.clickOnFirstProduct();
		//        throw new io.cucumber.java.PendingException();
	}
	@Then("User is landed to product detail page")
	public void user_is_landed_to_product_detail_page() {
		// Write code here that turns the phrase above into concrete actions
		//        throw new io.cucumber.java.PendingException();
		Assert.assertTrue(productdetailpage.isLandedOnProductDetailPage(),"Not on the detail page");;
	}

	@Then("Verify that detail detail is visible: product name, category, price, availability, condition, brand")
	public void verify_that_detail_detail_is_visible_product_name_category_price_availability_condition_brand() {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(productdetailpage.isProdutNameDisplayed(),"NO Data");
		Assert.assertTrue(productdetailpage.isProdutCategoryDisplayed(),"NO Data");
		Assert.assertTrue(productdetailpage.isProdutPrizeDisplayed(),"NO Data");
		Assert.assertTrue(productdetailpage.isProdutsAvailabilityDisplayed(),"NO Data");
		Assert.assertTrue(productdetailpage.isProdutConditionDisplayed(),"NO Data");
		Assert.assertTrue(productdetailpage.isProdutBrandDisplayed(),"NO Data");


		//        throw new io.cucumber.java.PendingException();
	}
	@When ("Enter product name {string} in search input and click search button")
	public void enter_product_name_in_search_input_and_click_search_button(String pName) {
		productpage.enterTheProductName(pName);
		searchedproductpage = productpage.clickOnSearch();
	}

	@Then("Verify SEARCHED PRODUCTS is visible")
	public void verify_searched_products_is_visible() {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(searchedproductpage.searchedProducts()); 
		//        throw new io.cucumber.java.PendingException();
	}

	@When("the user scrolls down to the footer")
	public void click_button_and_scroll_down_to_footer() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		register.goToLast();
		//        throw new io.cucumber.java.PendingException();
	}

	@Then("Verify text SUBSCRIPTION")
	public void verify_text_subscription() {
		Assert.assertEquals(register.verifySubscriptionText(),"SUBSCRIPTION"); 
	}

	@When("Enter email address {string} in input and click arrow button")
	public void enter_email_address_in_input_and_click_arrow_button(String string) {
		// Write code here that turns the phrase above into concrete actions
		register.enterMail(string);
		register.clickArrow();
		//        throw new io.cucumber.java.PendingException();
	}


	@Then("Verify success message You have been successfully {string} is visible")
	public void verify_success_message_you_have_been_successfully_is_visible(String string) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		if (driver.getPageSource().contains(string)) {
			System.out.println("Message found: " + string);
		} else {
			System.out.println(" Expected message not found: " + string);
		}
		Thread.sleep(5000);
		//        throw new io.cucumber.java.PendingException();
	}
	@When("the user scrolls down to the footer in cart")
	public void click_button_and_scroll_down_to_footer_in_cart() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		cartpage.goToLast();
		//        throw new io.cucumber.java.PendingException();
	}

	@Then("Verify text SUBSCRIPTION  in cart")
	public void verify_text_subscription_in_cart() {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(register.verifySubscriptionText(),"SUBSCRIPTION");
		//        throw new io.cucumber.java.PendingException();
	}

	@When("Enter email address {string} in input and click arrow button in cart")
	public void enter_email_address_in_input_and_click_arrow_button_in_cart(String string) {
		// Write code here that turns the phrase above into concrete actions
		cartpage.enterMail(string);
		cartpage.clickArrow();
		//        throw new io.cucumber.java.PendingException();
	}
	@Then("Verify that page is scrolled up and {string} text is visible on screen")
	public void verify_that_page_is_scrolled_up_and_text_is_visible_on_screen(String string) {
	    // Write code here that turns the phrase above into concrete actions
		try {
			WebElement homePageElement = driver.findElement(By.xpath("//h2[contains(text(),'Full-Fledged practice website for Automation Engineers')]"));
			 String actual=homePageElement.getText();
			 System.out.println(actual);
			 String expected="Full-Fledged practice website for Automation Engineers";
			if(actual==expected)
			System.out.println(" Home page is visible successfully");
           
		} catch (Exception e) {
			System.out.println(" Exception occurred while verifying home page: " + e.getMessage());
		}
//	    throw new io.cucumber.java.PendingException();
	}




	@Then("Verify success message You have been successfully {string} is visible incart")
	public void verify_success_message_you_have_been_successfully_is_visible_incart(String string) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// Write code here that turns the phrase above into concrete actions
		if (driver.getPageSource().contains(string)) {
			System.out.println("Message found: " + string);
		} else {
			System.out.println(" Expected message not found: " + string);
		}
		Thread.sleep(5000);
		//        throw new io.cucumber.java.PendingException();
	}
	@When("user goes to cart page")
	public void user_goes_to_cart_page() {
		cartpage = register.navigateToCartPage();
		driver.navigate().refresh();
	}

	@When ("user increases quantity to {string}")
	public void user_increases_quantity_to(String num) {
		productdetailpage.increase_quantity(num);
		productdetailpage.viewCart();
	}

	@Then("the product should be displayed in the cart with exact quantity {string}")
	public void the_product_should_be_displayed_in_the_cart_with_exact_quantity(String string) {
		// Write code here that turns the phrase above into concrete actions
		if(cartpage.check_corr_quant(string))
			System.out.println("Correct quantity selected");
		else
			System.out.println("Error in selecting quantity");
		//        throw new io.cucumber.java.PendingException();
	}
	@Then("Verify {string} is visible for review")
	public void verify_is_visible_for_review(String string) {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(productdetailpage.isWriteReviewIsDisplayed());
		//        throw new io.cucumber.java.PendingException();
	}
	@Then("Enter name {string} and email {string} and review {string}")
	public void enter_name_and_email_and_review(String name,String mail,String msg) {
		// Write code here that turns the phrase above into concrete actions
		productdetailpage.fillTheReviewDetails(name, mail, msg);
		//        throw new io.cucumber.java.PendingException();
	}
	@Then("Click Submit button for review")
	public void click_submit_button_for_review() {
		// Write code here that turns the phrase above into concrete actions
		paymentpage = productdetailpage.submit();
		//        throw new io.cucumber.java.PendingException();
	}
	@Then("Verify success message {string} in")
	public void verify_success_message(String string) {
		// Write code here that turns the phrase above into concrete actions
		paymentpage.verifyMessage(string);
		//	    throw new io.cucumber.java.PendingException();
	}
	@When("Scroll to bottom of page for review")
	public void user_scrolls_down_to_footer() throws InterruptedException {
		register.user_scrolls_down_to_footer();      
	}
	@Then("Verify {string} are visible for review")
	public void verify_are_visible_for_review(String message) throws InterruptedException {
		register.isRecommendedDisplayed(message);

	}
	@When("Click on Add To Cart on Recommended product")
	public void click_on_add_to_cart_on_recommended_product() {
		register.addRecommendedProduct();

	}
	@When("Click on View Cart button for recommended")
	public void click_on_view_cart_button_for_recommended(){
		productpage = register.viewCartForRecommended();

	}
	@When ("Click on arrow at bottom right side to move upward")
	public void click_on_arrow_at_bottom() {
		register.goToTop();
	}
	@When("Scroll down without arrow or functionality")
	public void scroll_d() throws InterruptedException {
		register.scrollDown();
	}
	@When("Scroll up without arrow or functionality")
	public void scroll_u() {
		register.scrollUp();

	}

	@After
	public void DriverClose() {
		driver.close();

	}


}

