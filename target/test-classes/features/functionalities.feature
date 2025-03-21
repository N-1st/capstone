Feature: Ecommerce Website Automation

Background:
    
    Given User is on the homepage

 
 
@TestCase21
Scenario:Add review on product
    When Click on Products button
    Then Verify user is navigated to ALL PRODUCTS page successfully
    Then Verify products list is visible
    When Click on View Product of first product
    Then User is landed to product detail page
    Then Verify "<review>" is visible for review
    And Enter name "<name>" and email "<email>" and review "<revie>"
    Then Click Submit button for review
    Then Verify success message "<message>" in
    Examples:
      |      review     |name     |    email        |  revie        |      message               |
      |Write Your Review|niranjan |niran@gmail.com  |super product  |Thank you for your review.  |
@TestCase22
Scenario:  Add to cart from Recommended items
     When Scroll to bottom of page for review
     Then Verify 'recommended items' are visible for review
     When  Click on Add To Cart on Recommended product
     When Click on View Cart button for recommended
     Then Verify products list is visible
@TestCase25

 Scenario: Verify Scroll Up using Arrow button and Scroll Down functionality
     When Scroll to bottom of page for review
     Then Verify text SUBSCRIPTION
     When Click on arrow at bottom right side to move upward
     Then Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
@TestCase26
Scenario: Verify Scroll Up without 'Arrow' button and Scroll Down functionality
     When Scroll to bottom of page for review
     Then Verify text SUBSCRIPTION
     When Scroll down without arrow or functionality
     When Scroll up without arrow or functionality
@TestCase10    
Scenario: Verify Subscription in home page
    When the user scrolls down to the footer
    Then Verify text SUBSCRIPTION
    When Enter email address "<email>" in input and click arrow button
    Then Verify success message You have been successfully "<subs>" is visible
    Examples:
      |      email               |subs       |
      | niranj1624@gmail.com     |subscribed |
@TestCase11
Scenario: Verify Subscription in Cart page
    When user goes to cart page 
    When the user scrolls down to the footer in cart
    Then Verify text SUBSCRIPTION  in cart
    When Enter email address "<email>" in input and click arrow button in cart
    Then Verify success message You have been successfully "<subsc>" is visible incart
    Examples:
      |      email               |subsc      |
      | niranj1624@gmail.com     |subscribed |
@TestCase7
Scenario: Verify Test Cases Page
    When user click on TestCases button
    Then verify user is navigated to test cases page sucessfully
@TestCase9
Scenario: Search Product
    When Click on Products button
    Then Verify user is navigated to ALL PRODUCTS page successfully
    When Enter product name "<productname>" in search input and click search button    
    Then  Verify SEARCHED PRODUCTS is visible
    Examples:
      |productname|
      |Blue Top   |