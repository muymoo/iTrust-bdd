Feature: UC30 Patient Send Reply

  Scenario: 
	Given HCP 1 sent a message to Patient 2 with subject "Office Visit Updated" and message "I just updated your office visit."
    Given Patient 2 has authenticated successfully
    When Patient clicks the "Message Inbox" link under the "Messaging" menu subheading
    When Patient clicks the "Read" link beside the message with subject "Office Visit Updated"
    When Patient clicks the "Reply" link above the message text
    When Patient enters message "Which office visit did you update?" and clicks the send button
	Then a message is in Patient 2's outbox with the subject "RE: Office Visit Updated" recipient Kelly Doctor and correct timestamp
	Then a bolded row for the message now appears in HCP 1's inbox with the subject "RE: Office Visit Updated" sender Andy Programmer and correct timestamp
	Then a fake email has been sent to HCP 1 informing them that they now have a message waiting