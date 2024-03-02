
@tag
Feature:Error validation
  I want to use this template for my feature file


  @Errorvalidation
  Scenario Outline: Title of your scenario outline
    Given I landed on Ecommerce Page
    When Logged in with Username <name> and Paswword <password>
    Then "Incoorect email or password" message is displayed

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
