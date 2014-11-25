Feature: UC28 - View HCP's Patients

  Scenario: View HCP's Patients
    Given HCP 1 has authenticated successfully
    When HCP clicks the "All Patients" link under the "Patient Info" menu subheading
    Then the following should be displayed: "Andy Programmer", "344 Bob Street Raleigh NC 27607", "2009-09-14"
    And the following should be displayed: "Care Needs", "1247 Noname Dr Suite 106 Raleigh NC 27606", "2005-10-10"
    And the following should be displayed: "Random Person", "1247 Noname Dr Suite 106 Raleigh NC 27606", "2008-10-10"
	