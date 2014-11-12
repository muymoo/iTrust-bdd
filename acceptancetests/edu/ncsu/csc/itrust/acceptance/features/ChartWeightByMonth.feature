Feature: UC10 Chart Weight By Month

  Scenario: 
    Given HCP 1 has authenticated successfully
    When HCP clicks the "Basic Health Information" link under the "Patient Info" menu subheading
    When HCP searches and selects 2
    When HCP chooses "Basic Health History"
    And HCP views the patient's weight chart
    Then there is an error that there is no data in the past years