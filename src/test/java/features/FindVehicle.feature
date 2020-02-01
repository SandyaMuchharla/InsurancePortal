#Author: Sandya.Muchharla@gmail.com
Feature: Vehicle Registration check

@Smoke
Scenario: Verify if vehicle exists
Given Initialize the browser with "chrome"
And Navigate to "https://covercheck.vwfsinsuranceportal.co.uk/" Site
When User enters vehicle registration number "OV12UYY" 
And User click on Find Vehicle button
Then User should be able to see vehicle registration details
And close browser

#http://automationpractice.com/index.php

  @SmokeTest1
  Scenario: Select an element randomly
    Given Initialize the browser with "chrome"
    And Navigate to "http://automationpractice.com/index.php" Site
    When User selects random picture
    Then User should be able to go to next page
    And close browser

  @SmokeTest1
  Scenario: Select an element randomly
    Given Initialize the browser with "chrome"
    And Navigate to "https://edureka.co" Site
    When User selects an element from link
    And close browser