Feature: UC22 - Schedule an Appointment

  Scenario: 
    Given Admin "9000000001" has authenticated successfully
    When Admin clicks the "Edit Appointment Types" link under the "Edit" menu subheading
    And Admin chooses to add a new appointment type named "Immunization" with a duration of 30 minutes
    And Admin clicks submit to save the new appointment type
    Then The new "Immunization" appointment type is now included in the list of appointment types, with duration of 30 minutes

    