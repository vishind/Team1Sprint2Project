Feature: End-to-end Authorization of Create Token
Given I have the base URL

Scenario: Unsuccessfully Create Token
When I fill invalid credentials
|@@@@|$%$%|
Then Token is not generated