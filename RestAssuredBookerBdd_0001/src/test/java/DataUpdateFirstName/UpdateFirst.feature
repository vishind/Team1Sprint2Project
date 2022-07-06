Feature: End-to-end Scenario of UpdateFirstname
Given I have the base URL

Scenario: Update Firstname
When Update a user detail
|Subha|barik|
Then The user details get updated