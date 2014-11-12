Feature: UC2 Add Public Health Agent

  Scenario: 
    Given Admin 9000000001 has authenticated successfully
    When Admin clicks the "Add PHA" link under the "Add" menu subheading
    And Admin enters: first name: Frank last name: Sinatra email: frankie@gmail.com
    And Admin clicks the "Continue to PHA information" link.
    And Admin enters: Address: 123 Oak Hills Drive City: Capitol City State: North Carolina Zip: 28700-0458 Phone: 555-877-5105
    And Admin clicks the "Edit PHA Record" button.
    Then A new Public Health Agent is added