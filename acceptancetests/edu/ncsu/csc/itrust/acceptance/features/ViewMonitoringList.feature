Feature: UC34 View Monitoring List

  Scenario: 
    Given Patient 1 is currently being monitored by HCP 1 for blood pressure and glucose levels
    Given Patient 5 is currently being monitored by HCP 1 for glucose levels
    Given Patient 2 is a representative for Patient 1
    Given Patient 1 has self-reported Systolic: 90; Diastolic: 60; and glucose: 80
    Given UAP has reported Systolic: 100; Diastolic: 70; and glucose: 90 for Patient 1
    Given Patient 2 has reported Systolic: 160; Diastolic: 110; and glucose: 60 for Patient 1
    Given HCP 1 has authenticated successfully
    When HCP clicks the "Monitor Patients" link under the "Telemedicine" menu subheading
    Then a list of reported information is displayed for the current date. The following information is displayed:
		| Random Person (MID 1)   || 160 | 110 | 60 | Andy Programmer |
		| Random Person (MID 1)   || 100 | 70  | 90 | FirstUAP LastUAP |
		| Random Person (MID 1)   || 90  | 60  | 80 | Random Person |