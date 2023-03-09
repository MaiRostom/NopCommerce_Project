@smoke
Feature: Check login Functionality

  Background: user opens login page
  Given user opens login page


  Scenario: user login with valid Email and password
     When user enter valid "test@example.com" and "P@ssw0rd"
     And user press remember me
     And user press login
     Then user logged in successfully

    Scenario: user log in with invalid Email and "password"
      When user enter invalid "wrong@example.com" and "12345m"
      And user press login
      Then user don't logged in successfully