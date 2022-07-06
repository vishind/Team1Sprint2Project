Feature: End-to-end CreateBooking
Given I have the base URL

Scenario: Create booking successfully
When I add  a details for booking
Then the booking is created successfully