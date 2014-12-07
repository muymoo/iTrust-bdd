Feature: UC34 Report Patient Status

  Scenario: 
    Given Patient 1 is currently being monitored by HCP 1 for blood pressure and glucose levels
    Given Patient 1 has authenticated successfully
    When Patient clicks the "Report Telemedicine Status" link under the "Telemedicine" menu subheading
    When Patient enters their systolic blood pressure: 100, diastolic blood pressure: 75, and glucose level: 120
    When Patient clicks the "Report" button
    Then Patient 1's blood pressure and glucose level are successfully reported