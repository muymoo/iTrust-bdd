Feature: UC21 View Emergency Reports

  Scenario: View Emergency Report
    Given ER "9000000006" has authenticated successfully
	When Patient clicks the "Emergency Patient Report" link under the "Add" menu subheading    
    Then Enter MID 2 into the form
    And Submit it
    And Clicks on MID button
    Then Content contains: Name: "Andy Programmer", Age: 30, Gender: "Male"