Feature: Register and Login page
Scenario Outline: Successful Login to Insurance Broker System
    Given User launches Insurance Broker System Page
    When User Register and login on page
    |Mr|Vishal|Shinde|9856859685|1992|December|11|Academic|MgRoad|Pune|India|411005|vis1@gmail.com|vishal5678|vishal5678|vis1@gmail.com|vishal5678|
    Then User login successfully
    
    