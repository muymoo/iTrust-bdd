Feature: UC34 Remove Patients to Monitor

  Scenario: 
    Given HCP 1 has authenticated successfully
    When HCP clicks the "Edit Patient List" link under the "Telemedicine" menu subheading
    When HCP searches and selects 1
    When HCP confirms that he or she wishes to remove Random Person from the remote monitoring patient list
    Then Random Person has been successfully removed from the list of patients for remote monitoring