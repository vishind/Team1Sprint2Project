Feature: Edit Profile Using DataTable
@ParameterizedTest @PositiveTest
Scenario Outline: Edit profile 
    Given User launches login page
    When User Enter all details
    |Miss|Majjiga|Pavani|9876543201|1954|February|11|10|Actor|Marathahalli|banglore|india|560037|
    And the profile edited successfully
    And User click on logout
   	Then User successfully logout from editprofile page    
