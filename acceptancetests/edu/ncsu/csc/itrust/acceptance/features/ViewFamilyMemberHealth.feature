Feature: UC9 View Family Member Health Summary

  Scenario: 
    Given Patient 2 has authenticated successfully
    When Patient clicks the "View My Records" link under the "Records" menu subheading
    Then the Family Medical History table is displayed with 5 rows.
    Then FMH Row 1 should be Random Person. Parent.Diabetes
    Then FMH Row 2 should be Care Needs. Sibling.