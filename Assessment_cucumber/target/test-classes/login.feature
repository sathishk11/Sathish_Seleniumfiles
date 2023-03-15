Feature: Login Functionality of Web Tours Application

Scenario: Valid login with valid credentials
  Given User is on the login page of the Web Tours Application
  When User enters valid username and password
  And Clicks on Login button
  Then User should be redirected to the home page of the application

Scenario: Invalid login with invalid credentials
  Given User is on the login page of the Web Tours Application
  When User enters invalid username and password
  And Clicks on Login button
  Then User should see an error message on the page