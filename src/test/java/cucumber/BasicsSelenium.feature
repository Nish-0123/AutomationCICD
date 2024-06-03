
@tag
Feature: Purchase the order from online app
  I want to purchase the order fromt he app

Background:
Given: I landed on online app page


  @tag2
  Scenario Outline: happy flow of placing the order
    Given I want login with the user name <name> and password<password>
    When I add the  <productname> to cart
    And checkout <productname> and submit
    Then "THANKYOU FOR THE ORDER" message should display

    Examples: 
      | name  					| password | productname  |
      | John1@gmail.com |John@1234 | ZARA COAT 3 |
   
