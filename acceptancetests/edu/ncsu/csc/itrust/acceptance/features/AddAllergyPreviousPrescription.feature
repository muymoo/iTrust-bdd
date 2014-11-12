Feature: UC10 Add Allergy Previous Prescription

  Scenario: 
    Given HCP 1 has authenticated successfully
    Given I have a new patient
    When HCP clicks the "Document Office Visit" link under the "Office Visits" menu subheading
    When HCP chooses "Document Office Visit"
    When HCP clicks "Yes, Document Office Visit"
    When HCP enters the date "02/01/2014" and clicks create 
	When HCP selects Prescriptions and enters "664662530 - Penicillin", 60 mg, from "02/01/2012" to "02/01/2014", with instructions "Take once daily." 
	When HCP clicks Add Prescription	    
    When HCP clicks the "PHR Information" link under the "Patient Info" menu subheading
	When HCP selects the Allergy "664662530 - Penicillin" and clicks Add Allergy
    Then the HCP is presented with the following information: Allergy Added