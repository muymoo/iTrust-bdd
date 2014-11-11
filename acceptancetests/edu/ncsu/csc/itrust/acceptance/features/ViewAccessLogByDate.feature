Feature: UC8 View Access Log By Date

  Scenario: 
    Given Patient 2 has authenticated successfully
    When Patient clicks the "Access Log" link
    And Patient enters Start Date: "3/1/2008" and End Date: "12/1/2008"
    And Patient chooses to view log sorted by date
    Then a list should be displayed
    Then Row 1 should be Justin Time. ER. 11/14/2008 9:32AM. Transaction Code 22
	Then Row 2 should be Kelly Doctor (with a link to Kelly Doctor's personal information). LHCP. 9/7/2008 4:30PM. Transaction Code 39.
	Then Row 3 should be Gandalf Stormcrow (with a link to Gandalf Stormcrow's personal information). LHCP. 7/15/2008 1:13PM. View. Transaction Code 19.
	Then Row 4 should be Kelly Doctor (with a link to Kelly Doctor's personal information). LHCP. 3/4/2008 10:15AM. Transaction Code 14.