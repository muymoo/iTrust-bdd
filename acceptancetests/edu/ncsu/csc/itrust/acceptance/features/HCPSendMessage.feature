Feature: UC30 HCP Send Message

  Scenario: 
    Given HCP 1 has authenticated successfully
    When HCP clicks the "Message Outbox" link under the "Messaging" menu subheading
    When HCP clicks Compose a Message
    When HCP searches and selects 2
    When HCP enters subject Visit Request with the message "We really need to have a visit." and clicks the send button
	Then a message is in HCP's outbox with the subject "Visit Request" recipient Andy Programmer and correct timestamp
	Then a bolded row for the message now appears in Patient 2's inbox with the subject "Visit Request" sender Kelly Doctor and correct timestamp
	Then a fake email has been sent to Patient 2 informing them that they now have a message waiting