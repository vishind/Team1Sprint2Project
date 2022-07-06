Feature: End-to-end Authorization of Create Token
Given I have the base URL

Scenario: Create Token
When I fill credentials
|admin|password123|
Then Token is generated