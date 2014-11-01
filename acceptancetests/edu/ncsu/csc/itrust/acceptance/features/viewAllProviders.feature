Feature: UC6 View HCP; Designate/Undesignate Designated Licensed Health Care Professional Use Case

  Scenario: View All of My Providers
    Given LHCP 9000000000, 9000000003, 9000000004 and Patient 2 are in the database
    And Office Visits 902-911 are in the database.
    And Patient 2 has specified that HCP 9000000003 and 9000000004 are DLHCP's for him
    And Patient 2 has authenticated successfully
    When Patient clicks "My Providers" link
    Then The first result is Jason Frankenstein, surgeon, 333 Dark Lane Raleigh NC 27603, 2008-05-01, Is DLHCP
