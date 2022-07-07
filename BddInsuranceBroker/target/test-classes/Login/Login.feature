Feature: Login page
@ParameterizedTest
Scenario Outline: Successful Login with Insurance Broker System
    Given User is on Insurance Broker System Page
    When User enters details for Login
    |vis1@gmail.com|vishal5678|
    Then User is login successfully
    
    