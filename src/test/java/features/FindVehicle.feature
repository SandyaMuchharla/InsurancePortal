#Author: Sandya.Muchharla@gmail.com
Feature: Vehicle Registration check

Scenario: Verify if vehicle exists
Given Initialize the browser with "chrome"
And Navigate to "https://covercheck.vwfsinsuranceportal.co.uk/" Site
When User enters vehicle registration number "OV12UYY" 
And User click on Find Vehicle button
Then User should be able to see vehicle registration details
And close browser

