Feature: UC10 Calculate BMI

  Scenario: 
    Given HCP 1 has authenticated successfully
    When HCP clicks the "Basic Health Information" link under the "Patient Info" menu subheading
    When HCP searches and selects 2
    When HCP chooses "Basic Health History"
    Then the BMI is automatically calculated and displayed as 39.06 for the 2007-06-07 20:33:58.0 recording
	Then the BMI is automatically calculated and displayed as 38.41 for the 2007-06-07 20:34:58.0 recording