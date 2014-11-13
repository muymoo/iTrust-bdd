Feature: Maintain Standards List

  Scenario: Admin Enter New ICD Code
    Given Admin "9000000001" has authenticated successfully
    When Admin clicks the "Edit ICD Codes" link under the "Edit" menu subheading
    And Enter the following information into the form: Code: "99.3" Description: "Tintinnabulum Bovi Deficiency" Chronic: "true"
    And Click the "Add Code" button
	Then The current ICD Codes contain: Code: "99.3" Description: "Tintinnabulum Bovi Deficiency" Chronic: "true"