Feature: UC34 Add Patients to Monitor

  Scenario: 
    Given HCP 1 has authenticated successfully
    When HCP clicks the "Edit Patient List" link under the "Telemedicine" menu subheading
    When HCP searches and selects 2
    When HCP confirms that he or she wishes to add Andy Programmer to the remote monitoring patient list
    When HCP specifies that Andy Programmer will report blood pressure, weight, and pedometer readings
    Then Andy Programmer has been successfully added to the list of patients for remote monitoring