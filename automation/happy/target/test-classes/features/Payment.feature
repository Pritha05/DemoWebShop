@PaymentFeature
Feature: Payment

  Scenario: Payment Process
    #Given User Launch Chrome browser
    Given User opens URL "https://demowebshop.tricentis.com/"
    And User enters Email as "bikramde14@gmail.com" and Password as "Shashpur@852"
    And User Clicks on Login
    Then Page Title should be "Demo Web Shop"
    Then User choose "Books" Catagory
    Then User select one product from Catagory
    And User Go to Shopping Cart
    And Verify the shopping Cart