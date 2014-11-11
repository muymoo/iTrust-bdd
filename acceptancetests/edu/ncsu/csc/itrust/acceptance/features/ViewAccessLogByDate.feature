Feature: UC8 View Access Log By Date

  Scenario: 
    Given Patient 2 has authenticated successfully
    When Patient clicks the "Access Log" link under the "View" menu subheading
    And Patient enters Start Date: "3/1/2008" and End Date: "12/1/2008"
    And Patient chooses to view log sorted by date
    Then a list should be displayed
    Then AL Row 1 should be Justin Time. Emergency Responder. View emergency report.
	Then AL Row 2 should be Kelly Doctor. LHCP. Edit Office Visits.
	Then AL Row 3 should be Kelly Doctor. LHCP. View risk factors.