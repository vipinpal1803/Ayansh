Feature: BookCart Application tests

  Background: 
    And User clicks on the login button

  @smoke 
  Scenario: login should be success
    And User enter the username as "ortoni"
    And User enter the password as "Pass1234"
    When User click on the login button
    Then Login should be success

  @smoke
  Scenario: login should not be success
    And User enter the username as "vipin"
    And User enter the password as "Pass21"
    When User click on the login button
    But Login should fail
