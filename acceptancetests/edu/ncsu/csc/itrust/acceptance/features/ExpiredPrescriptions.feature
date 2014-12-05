Feature: UC 31 Expired Prescriptions

  Scenario: View a List of Expired Prescriptions
    Given Patient 2 has authenticated successfully
    When Patient clicks the "My Expired Prescription Reports" link under the "View" menu subheading
    Then A report should appear with title "Andy Programmer"
    And The following information is displayed:
      | 00904-2407 | Tetracycline | 10/10/2006 to 10/11/2006 | Kelly Doctor |
      | 00904-2407 | Tetracycline | 10/10/2006 to 10/11/2006 | Kelly Doctor |

  Scenario: View the LHCP for an Expired Prescription
    Given Patient 2 has authenticated successfully
    When Patient clicks the "My Expired Prescription Reports" link under the "View" menu subheading
    And Patient clicks the "Kelly Doctor" link
    Then A report should appear with title "Kelly Doctor"
    And The following HCP infomation should be displayed:
      | Specialty: | surgeon                                       |
      | Address:   | 4321 My Road St\nPO BOX 2\nNew York, NY 10453 |
      | Phone:     | 999-888-7777                                  |
      | Email:     | kdoctor@iTrust.org                            |
