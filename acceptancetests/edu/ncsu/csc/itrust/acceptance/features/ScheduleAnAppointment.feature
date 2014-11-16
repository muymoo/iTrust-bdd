Feature: UC22 - Schedule an Appointment

  Scenario: Add an appointment
    Given Admin "9000000001" has authenticated successfully
    When Admin clicks the "Edit Appointment Types" link under the "Edit" menu subheading
    And Admin chooses to add the appointment type named "Immunization" with a duration of 30 minutes
    And Admin clicks submit to save the appointment type
    Then the "Immunization" appointment type is now included in the list of appointment types, with duration of 30 minutes

  Scenario: Edit an appointment duration
    Given Admin "9000000001" has authenticated successfully
    When Admin clicks the "Edit Appointment Types" link under the "Edit" menu subheading
    And Admin chooses to edit the appointment type named "Physical" with a duration of 45 minutes
    And Admin clicks submit to update the appointment type
    Then the "Physical" appointment type is now included in the list of appointment types, with updated duration of 45 minutes

    