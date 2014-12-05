Feature: UC34 UAP Add Patients to Monitor

  Scenario: 
    Given UAP has authenticated successfully
    When UAP clicks the "Edit Patient List" link under the "Telemedicine" menu subheading
    When UAP searches and selects 2
    When UAP confirms that he or she wishes to add Andy Programmer to the remote monitoring patient list
    Then Andy Programmer has been successfully added to the list of patients for remote monitoring