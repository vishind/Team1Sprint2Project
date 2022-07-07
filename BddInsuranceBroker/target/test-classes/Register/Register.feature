Feature: Registration with Insurance Broken System Page
@ParameterizedTest
Scenario Outline: Successful Registration with Insurance Broker System
    Given User is on Insurance Broker System Page
    When User enters details for registration
    |Mr|Vishal|Shinde|9856859685|1992|December|11|Academic|MgRoad|Pune|India|411005|vis1@gmail.com|vishal5678|vishal5678|
    Then User is registered successfully
    
    