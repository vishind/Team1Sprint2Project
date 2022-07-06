Feature: End-to-end UpdateBooking
Given I have the base URL

Scenario: Update booking successfully
When I update details for booking
Then the booking is updated successfully