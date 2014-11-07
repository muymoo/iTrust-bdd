Feature: UC6 View HCP; Designate/Undesignate Designated Licensed Health Care Professional Use Case

  Scenario: View All of My Providers
    Given LHCP 9000000000, 9000000003, 9000000004 and Patient 2 are in the database
    And Office Visits 902-911 are in the database.
    And Patient 2 has specified that HCP 9000000003 and 9000000004 are DLHCP's for him
    And Patient 2 has authenticated successfully
    When Patient clicks "My Providers" link
    Then The first result is "Gandalf Stormcrow", "none", "4321 My Road St PO BOX 2 New York, NY 10453", "09/14/2009", "true"
