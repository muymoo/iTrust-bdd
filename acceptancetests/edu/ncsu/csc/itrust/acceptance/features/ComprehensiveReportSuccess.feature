Feature: UC23 Comprehensive Report Success

  Scenario: 
    Given HCP 1 has authenticated successfully
    When HCP clicks the "My Report Requests" link under the "Patient Info" menu subheading
    When HCP clicks the "Add a new Report Request" link
    When HCP searches and selects 2
    When HCP views the newly generated comprehensive report for Patient 2
    Then HCP sees the Comprehensive Patient Report for Andy Programmer