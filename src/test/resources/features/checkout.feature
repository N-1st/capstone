Feature: Ecommerce Website Automation
Background:
    
    Given User is on the homepage for cart


@TestCase14
Scenario: Place Order: Register while Checkout
    When Click Products button in cart
    When Hover over first product and click Add to cart and Click Continue Shopping button   
    When Hover over second product and click Add to cart and Click View Cart button
    When user goes to cart page in cart
    When Click Proceed To Checkout button in cart  
    When user click to register
    When User enters name "<name>" and email "<email>" in cart
    And User clicks Signup button in cart
    #Then Verify ENTER ACCOUNT INFORMATION is visible in cart
    When User fills account information in cart
    #And User selects newsletter and special offers in cart
    And User fills address information in cart
    And User clicks Create Account button in cart
    Then Verify ACCOUNT CREATED is visible in cart
    When User clicks Continue button to create in cart
    Then Verify Logged in as username is visible in cart
    When user goes to cart page in cart
    When Click Proceed To Checkout button in cart
    Then Verify Address Details and Review Your Order
    When Enter description in comment text area and click Place Order
    When Enter payment details: Name on Card, Card Number, CVC, Expiration date
    When Click Pay and Confirm Order button
    Then Verify success message "<message>"
    When User clicks Delete Account button in cart
    Then Verify ACCOUNT DELETED is visible in cart
    And User click Continue button in cart
    Examples:
    |    name   |     email      |    message                                     |
    | Niranjan  |nirunjsdfean@gmail.com  | Congratulations Your order has been confirmed  |
    
    
@TestCase15
Scenario: Place Order: Register before Checkout
    When User clicks on Signup Login button in cart
    Then Verify New User Signup is visible in cart
    When User enters name "<name>" and email "<email>" in cart
    And User clicks Signup button in cart
    #Then Verify ENTER ACCOUNT INFORMATION is visible in cart
    When User fills account information in cart
    #And User selects newsletter and special offers in cart
    And User fills address information in cart
    And User clicks Create Account button in cart
    Then Verify ACCOUNT CREATED is visible in cart
    When User clicks Continue button to create in cart
    #Then Verify Logged in as username is visible in cart
    When Click Products button in cart
    When Hover over first product and click Add to cart and Click Continue Shopping button   
    When Hover over second product and click Add to cart and Click View Cart button    
    When user goes to cart page in cart
    When Click Proceed To Checkout button in cart
    Then Verify Address Details and Review Your Order
    When Enter description in comment text area and click Place Order
    When Enter payment details: Name on Card, Card Number, CVC, Expiration date
    When Click Pay and Confirm Order button
    Then Verify success message "<message>"
    When User clicks Delete Account button in cart
    Then Verify ACCOUNT DELETED is visible in cart
    And User click Continue button in cart
    Examples:
    |    name   |     email             |    message                                     |
    | Niranjan  |nigganjandsdran@gmail.com  | Congratulations Your order has been confirmed  |
@TestCase16
Scenario: Place Order: login before Checkout
    When User clicks on Signup Login button in cart
    When Verify Login form is visible in cart
    When User enters valid email "<email>" and password "<password>" in cart
    And User clicks Login button in cart
    #Then Verify Logged in as username is visible after correct details in cart
    When Click Products button in cart
    When Hover over first product and click Add to cart and Click Continue Shopping button   
    When Hover over second product and click Add to cart and Click View Cart button   
    When user goes to cart page in cart
    When Click Proceed To Checkout button in cart
    Then Verify Address Details and Review Your Order
    When Enter description in comment text area and click Place Order
    When Enter payment details: Name on Card, Card Number, CVC, Expiration date
    When Click Pay and Confirm Order button
    Then Verify success message "<message>"
    Examples:
    |     email                 |    password            |    message                                     |
    | niranjan830988@gmail.com  |  niru                  | Congratulations Your order has been confirmed  |
    
 @TestCase23   
 Scenario: Verify address details in checkout page
    When User clicks on Signup Login button in cart
    Then Verify New User Signup is visible in cart
    When User enters name "<name>" and email "<email>" in cart
    And User clicks Signup button in cart
    #Then Verify ENTER ACCOUNT INFORMATION is visible in cart
    When User fills account information in cart
    #And User selects newsletter and special offers in cart
    And User fills address information in cart
    And User clicks Create Account button in cart
    Then Verify ACCOUNT CREATED is visible in cart
    When User clicks Continue button to create in cart
    Then Verify Logged in as username is visible in cart
    When Click Products button in cart
    When Hover over first product and click Add to cart and Click Continue Shopping button   
    When Hover over second product and click Add to cart and Click View Cart button    
    When user goes to cart page in cart
    When Click Proceed To Checkout button in cart
    And Verify that the billing address is same address filled at the time registration of account
    And Verify that the delivery address is same address filled at the time registration of account
    When User clicks Delete Account button in cart
    Then Verify ACCOUNT DELETED is visible in cart
    Examples:
    |    name   |     email      |    message                                     |
    | Niranjan  |manojnirfanjan@gmail.com  | Congratulations Your order has been confirmed  |  
    
    
    
    
 @TestCase24
 Scenario: Download Invoice after purchase order
    When Click Products button in cart
    When Hover over first product and click Add to cart and Click Continue Shopping button   
    When Hover over second product and click Add to cart and Click View Cart button
    

    When Click Proceed To Checkout button in cart  
    When user click to register
    When User enters name "<name>" and email "<email>" in cart
    And User clicks Signup button in cart
    #Then Verify ENTER ACCOUNT INFORMATION is visible in cart
    When User fills account information in cart
    #And User selects newsletter and special offers in cart
    And User fills address information in cart
    And User clicks Create Account button in cart
    Then Verify ACCOUNT CREATED is visible in cart
    When User clicks Continue button to create in cart
    Then Verify Logged in as username is visible in cart
    When user goes to cart page in cart
    When Click Proceed To Checkout button in cart
    Then Verify Address Details and Review Your Order
    When Enter description in comment text area and click Place Order
    When Enter payment details: Name on Card, Card Number, CVC, Expiration date
    When Click Pay and Confirm Order button
    Then Verify success message "<message>"
    When Click Download Invoice button and verify invoice is downloaded successfully
    When Click Continue button
    When User clicks Delete Account button in cart
    Then Verify ACCOUNT DELETED is visible in cart
    And User click Continue button in cart
    Examples:
    |    name   |     email           |    message                                     |
    | Niranjan  |nmaadhdvvanu@gmail.com  | Congratulations Your order has been confirmed  |