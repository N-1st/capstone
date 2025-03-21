Feature: Ecommerce Website Automation

Background:
    
    Given User is on the homepage
   
 
@TestCase1
Scenario: Register a new user
    When User clicks on Signup Login button
    Then Verify New User Signup is visible
    When User enters name "<name>" and email "<email>"
    And User clicks Signup button
    Then Verify ENTER ACCOUNT INFORMATION is visible
    When User fills account information
    #And User selects newsletter and special offers
    And User fills address information
    And User clicks Create Account button
    Then Verify ACCOUNT CREATED is visible
    When User clicks Continue button to create
    Then Verify Logged in as username is visible
    When User clicks Delete Account button
    Then Verify ACCOUNT DELETED is visible
    And User click Continue button
    Examples:
      | name |      email               |
      | Niru | nirasguygnjanramuuu@gmail.com |
@TestCase2  
Scenario: Successful Login to Automation Exercise
    When User clicks on Signup Login button
    When Verify Login form is visible
    When User enters valid email "<email>" and password "<password>"
    And User clicks Login button
    Then Verify Logged in as username is visible after correct details
    Examples:
      |      email               |password |
      | niranjan830988@gmail.com |niru     |
@TestCase3 
Scenario: Login User with incorrect email and password
    When User clicks on Signup Login button
    Then Verify Login form is visible
    When User enters invalid email "<email>" and password "<password>"
    And User clicks Login button
    Then Verify error message Your email or password is incorrect! is visible
    Examples:
      |      email     |password |
      | babu@gmail.com |oisjdoi  |
@TestCase4
Scenario: Logout from Automation Exercise
    When User clicks on Signup Login button
    Then Verify Login form is visible
    When User enters valid email "<email>" and password "<password>"
    And User clicks Login button
    Then Verify Logged in as username is visible after correct details
    When User click on logout
    Then User return to home page
     Examples:
      |      email               |password |
      | niranjan830988@gmail.com |niru     |
@TestCase5
Scenario: Register User with existing email
    When User clicks on Signup Login button
    Then Verify New User Signup is visible	
    When User enters name "<name>" and email "<email>"
    And User clicks Signup button
    Then Verify error Email Address already exist! is visible with valid credentials
    Examples:
      | name |      email               |
      | Niru | niranjan830988@gmail.com |


    



   
     
 
 
