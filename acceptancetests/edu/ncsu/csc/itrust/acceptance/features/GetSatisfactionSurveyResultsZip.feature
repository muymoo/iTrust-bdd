Feature: UC25 Get Satisfaction Survey Results Zip

  Scenario: 
    Given Patient 2 has authenticated successfully
    When Patient clicks the "Satisfaction Survey Results" link under the "Other" menu subheading
	When Patient inputs Surgeon for physician type and zip code 10453 and submits
	Then the LHCP Search Results table is displayed with:
    	| Kelly Doctor | 15.00 | 10.00 | 2.00 | 5.00 |