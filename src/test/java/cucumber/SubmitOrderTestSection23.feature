@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file
  
  Background:                                        //Background is used as before method-it runs with each test - pre-requisit
  Given I landed on Ecommerce Page
  
  @Regression
  Scenario Outline: Positive Test of Submitting the order
  
    Given Logged in with username <name> and password <password>
    When I add product <productName> to cart 
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage
    
    Examples:
| name            | password  | productName |   
| ved18@gmail.com | User@1234 | ZARA COAT 3 |
| atestuser1@gmail.com | User@1234 | ZARA COAT 3 |          
