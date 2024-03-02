
@tag
Feature: Purchase the order from Ecommerce website
  I want to use this template for my feature file
  
  Background: 
  Given I landed on Ecommerce Page

  @Regression
  Scenario Outline: Positive test of Submitting the order
    Given Logged in with Username <name> and Paswword <password>
    When I add product <productname> from Cart
    And Checkout <productname> and submit the order
    Then "THANKYOU FOR THE ORDER." is displayed on ConfirmationPage
    Examples: 
      | name               |password  | productname |
      | pigu2587@gmaail.com|Pr@jyot02 | ZARA COAT 3 |
     
