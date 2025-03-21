Feature: Ecommerce Website Automation

Background:
    
    Given User is on the homepage


@TestCase6
Scenario: Contact Us Form
    When Click on Contact Us button
    Then Verify GET IN TOUCH is visible
    When User Enter "<name>" and "<email>" and "<subject>" and "<message>" and "<path>"
    When user Click Submit button
    When user click Ok button
    Examples:
      | name |      email               |   subject   | message                      |path         |
      | Niru | niranjanramuuu@gmail.com |having issue |website i sunder maintainence |F:\\doc1.txt |