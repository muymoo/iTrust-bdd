Feature: UC30 Sort Inbox by Sender

  Scenario: 
    Given HCP 1 has authenticated successfully
    When HCP clicks the "Message Inbox" link under the "Messaging" menu subheading
    When HCP chooses to sort their inbox by sender name in ascending order
	Then the inbox contains messages with these authors in this order:
    |Random Person|
    |Andy Programmer|
    |Baby Programmer|