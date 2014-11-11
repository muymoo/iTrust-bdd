Feature: UC6 View HCP; Designate/Undesignate Designated Licensed Health Care Professional Use Case

  Scenario: View All of My Providers
    Given Patient 2 has authenticated successfully
    When Patient clicks the "My Providers" link under the "View" menu subheading
    Then Row 1 result is "Gandalf Stormcrow", "none", "4321 My Road St PO BOX 2 New York, NY 10453", "09/14/2009", "true"
    And Row 2 result is "Kelly Doctor", "surgeon", "4321 My Road St PO BOX 2 New York, NY 10453", "06/10/2007", "false"

  @hcp
  Scenario: 
    Given Patient 2 has authenticated successfully
    When Patient clicks the "My Providers" link under the "View" menu subheading
    And Patient clicks checkbox to change Kelly Doctor from undesignated to designated
    Then Row 1 result is "Gandalf Stormcrow", "none", "4321 My Road St PO BOX 2 New York, NY 10453", "09/14/2009", "true"
    And Row 2 result is "Kelly Doctor", "surgeon", "4321 My Road St PO BOX 2 New York, NY 10453", "06/10/2007", "true"
