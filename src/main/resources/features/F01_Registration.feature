@smoke
Feature: Guest users could create new Accounts
  Scenario: User could Create new accounts with valid data
    Given User Go to Register Page
    When user select genderType
    And User enter "Mai" and "Rostom"
    And user select Birthdate
    And User write the email
    And user enter "P@ssw0rd" Password and Confirm password
    And user click on Register
    Then user Registered in successfully