Feature: Request a quotation
Scenario Outline: Successfully requested a quotation
Given User launches Request Quotation page
When User enters Quotation details
|No cover|Car hit|OD02AT0001|35 kmpl|150000|Public Place|2016|February|15|
And User clicks Calculate Premium gets premium details
Then User clicks Save Quotation gets quotation details