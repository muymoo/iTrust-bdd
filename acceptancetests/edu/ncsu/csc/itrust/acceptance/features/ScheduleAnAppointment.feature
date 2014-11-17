Feature: UC22 - Appointment Management

  Scenario: Add an appointment type
    Given Admin "9000000001" has authenticated successfully
    When Admin clicks the "Edit Appointment Types" link under the "Edit" menu subheading
    And Admin chooses to add the appointment type named "Immunization" with a duration of 30 minutes
    And Admin clicks submit to save the appointment type
    Then the "Immunization" appointment type is now included in the list of appointment types, with duration of 30 minutes

  Scenario: Edit an appointment type duration
    Given Admin "9000000001" has authenticated successfully
    When Admin clicks the "Edit Appointment Types" link under the "Edit" menu subheading
    And Admin chooses to edit the appointment type named "Physical" with a duration of 45 minutes
    And Admin clicks submit to update the appointment type
    Then the "Physical" appointment type is now included in the list of appointment types, with updated duration of 45 minutes

  Scenario: Schedule an appointment
    Given HCP 1 has authenticated successfully
    When HCP clicks the "Schedule Appointment" link under the "Appointments" menu subheading
    And HCP chooses to schedule a new appointment with: Patient: 1, type:  "General Checkup" at "9:00AM July 6, 2015" with comment "This is the next checkup for your blood pressure medication."
    And HCP clicks submit to save the new appointment
    Then HCP clicks the "View My Appointments" link under the "Appointments" menu subheading
    And The newly scheduled appointment is saved successfully as "General Checkup" with "Random Person" for "9:00AM July 6, 2015", for 45 minutes with comment "This is the next checkup for your blood pressure medication."
