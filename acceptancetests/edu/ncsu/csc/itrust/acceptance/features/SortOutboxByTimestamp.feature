Feature: UC30 Sort Outbox by Timestamp

  Scenario: 
    Given Patient 1 has authenticated successfully
    When Patient clicks the "Message Outbox" link under the "Messaging" menu subheading
    When Patient chooses to sort their outbox by timestamp in descending order
	Then the outbox contains messages with these subjects in this order:
    |RE: Appointment|
    |Telemedicine|
    |Appointment Reschedule|
    |Missed Appointment|
    |Aspirin Side Effects|
	|Old Medicine|