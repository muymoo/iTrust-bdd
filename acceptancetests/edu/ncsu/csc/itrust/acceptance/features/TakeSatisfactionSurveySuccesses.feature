Feature: UC24 Take Satisfaction Survey Successes

  Scenario: All Inputs
  	Given Patient 2 visited the office on 11/21/2014
    Given Patient 2 has authenticated successfully
    When Patient clicks the "View My Records" link under the "Records" menu subheading
    When Patient clicks a link next to his office visit on Nov 21, 2014 to take satisfaction survey
	When Patient inputs the following information and submits: 15 minutes, 10 minutes, 3, 5
	Then the survey answers are stored and the event is logged
	
  Scenario: Not All Inputs
  	Given Patient 2 visited the office on 11/21/2014
    Given Patient 2 has authenticated successfully
    When Patient clicks the "View My Records" link under the "Records" menu subheading
    When Patient clicks a link next to his office visit on Nov 21, 2014 to take satisfaction survey
	When Patient inputs the following information and submits: [none] minutes, 10 minutes, 1, [none]
	Then the survey answers are stored and the event is logged