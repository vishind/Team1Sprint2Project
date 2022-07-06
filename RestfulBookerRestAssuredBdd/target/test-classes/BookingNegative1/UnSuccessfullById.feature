Feature: Unsuccessful GetBooking by id
Given I have the base URL

Scenario: Update id
When  Update a user with invalid id
Then I get invalid response
