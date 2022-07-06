Feature: End-to-end functionality
Given I have the base URL

Scenario Outline: Delete a user
When I delete a user
Then The user gets deleted
