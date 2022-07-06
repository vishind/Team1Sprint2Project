Feature: End-to-end Booking By booking Name
Given I have the base URL

Scenario: Create Token
When I fill credentials
|admin|password123|
Then Token is generated

Scenario: Fetch Booking by Name
When I Request For All Booking By Name
Then I get all Booking IDs

Scenario: Fetch Booking 
When I Request For All Booking By Check In and Check Out 
Then I get All Booking Id

Scenario: Fetch Booking 
When I Request For All Booking By Id 
Then I get All Booking

Scenario: Create booking successfully
When I add  a details for booking
Then the booking is created successfully

Scenario: Update booking successfully
When I update details for booking
Then the booking is updated successfully

Scenario: Update Firstname
When  Update a user detail
Then The user details get updated

Scenario Outline: Delete a user
When I delete a user
Then The user gets deleted

Scenario: Create Healthcheck
When I Create a Healthcheck
Then The Healthcheck is Created


