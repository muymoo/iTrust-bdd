Feature: UC 31 Expired Prescriptions

  Scenario: View a List of Expired Prescriptions
    Given Patient 2 has authenticated successfully
    When Patient clicks the "My Expired Prescription Reports" link under the "View" menu subheading
    Then A report should appear with title "Andy Programmer"
    And The following information is displayed:
      | 00904-2407 | Tetracycline | 10/10/2006 to 10/11/2006 | Kelly Doctor |
      | 00904-2407 | Tetracycline | 10/10/2006 to 10/11/2006 | Kelly Doctor |
