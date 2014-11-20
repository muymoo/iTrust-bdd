Feature: View My Diagnoses

  Scenario: 
    Given Patient 1 has authenticated successfully
    When Patient clicks the "My Diagnoses" link under the "View" menu subheading
    Then displays "Osteoarthrosis, generalized, multiple sites(715.09)"
    And displays "Acute Lycanthropy(250.00)"
