Feature: UC19 View Prescription Report

  Scenario: 
    Given Patient 2 has authenticated successfully
    When Patient clicks the "My Expired Prescription Reports" link under the "View" menu subheading
    Then the prescription table is displayed with 2 rows:
    |Tetracycline|
    |Tetracycline|