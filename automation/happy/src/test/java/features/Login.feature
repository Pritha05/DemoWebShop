
@LoginFeature
Feature: Login

  Scenario: Successful Login with Valid Credentials
    Given User Launch Chrome browser
    When User opens URL "https://demowebshop.tricentis.com/"
    And User enters Email as "bikramde14@gmail.com" and Password as "Shashpur@852"
    And User Clicks on Login
    Then Page Title should be "Demo Web Shop"
    # When User clicks on Log out link
    And close browser
