Feature: End-to-end functionality
Given I have the base URL

Scenario: Create Healthcheck Notfound
When I Create a Healthcheck
Then The Healthcheck is not found