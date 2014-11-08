Feature: Add Public Health Agent

  Scenario: 
    Given Admin 9000000001 has authenticated successfully.
    When Admin clicks the "Add PHA" link under the "Add" menu subheading.
    And Admin enters: first name: Tim last name: Agent email: pha@timagent.com
    And Admin clicks the "Continue to PHA information" link.
    And Admin enters: Address: 98765 Oak Hills Drive City: Capitol City State: North Carolina Zip: 28700-0458 Phone: 555-877-5100
    And Admin clicks the "Edit PHA Record" button.
    Then A new Public Health Agent is added with the following information: First Name: Tim Last Name: Agent Address: 98765 Oak Hills DriveCity: Capitol City State: North Carolina Zip: 28700-0458 Phone: 555-877-5100 Email: pha@timagent.com
