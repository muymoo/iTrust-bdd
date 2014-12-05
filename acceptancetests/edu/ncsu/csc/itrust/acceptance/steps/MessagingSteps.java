package edu.ncsu.csc.itrust.acceptance.steps;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MessagingSteps {
    private final WebDriver browser;
    private final SharedDriver driver;
    public MessagingSteps(SharedDriver browser)
    {
    	this.driver = browser;
        this.browser = browser;
    }
    
	@When("^HCP clicks Compose a Message$")
	public void hcp_clicks_Compose_a_Message() throws Throwable {
	    WebElement composeMsgLink = browser.findElement(By.linkText("Compose a Message"));
	    composeMsgLink.click();
	}

	private void enterMessage(String msg) {
		WebElement messageInput = browser.findElement(By.cssSelector("textarea[name=\"messageBody\"]"));
	    messageInput.sendKeys(msg);
	}
	
	private void clickSend() {
	    WebElement sendMessage = browser.findElement(By.cssSelector("input[name=\"sendMessage\"]"));
	    sendMessage.click();
	}
	
	@When("^HCP enters subject (.+) with the message \"(.*?)\" and clicks the send button$")
	public void hcpSendsMsg(String subject, String msg) throws Throwable {
	    WebElement subjectInput = browser.findElement(By.cssSelector("input[name=\"subject\"]"));
	    subjectInput.sendKeys(subject);
	    enterMessage(msg);
	    clickSend();
	}
	
	@When("^Patient clicks the \"(.*?)\" link beside the message with subject \"(.*?)\"$")
	public void patient_clicks_the_link_beside_the_message_with_subject(String link, String subject) throws Throwable {
		List<WebElement> emails = browser.findElements(By.cssSelector("#mailbox tbody tr"));
		for(WebElement email : emails) {
			List<WebElement> fields = email.findElements(By.cssSelector("td"));
			if(fields.get(1).getText().equals(subject)) {
				fields.get(3).findElement(By.cssSelector("a")).click();
				return;
			}
		}
	}

	@When("^Patient clicks the \"(.*?)\" link above the message text$")
	public void patient_clicks_the_link_above_the_message_text(String link) throws Throwable {
	    browser.findElement(By.linkText(link)).click();
	}

	@When("^Patient enters message \"(.*?)\" and clicks the send button$")
	public void patient_enters_message_and_clicks_the_send_button(String msg) throws Throwable {
	    enterMessage(msg);
	    clickSend();
	}

	private void verifyLatestMessage(String subject, String sender) {
		// click on date column to make latest message on top
		browser.findElements(By.cssSelector("#mailbox thead th")).get(2).click();
		browser.findElements(By.cssSelector("#mailbox thead th")).get(2).click();
		
	    List<WebElement> emails = browser.findElements(By.cssSelector("#mailbox tbody tr"));
	    WebElement mostRecentEmail = emails.get(0);
	    List<WebElement> cells = mostRecentEmail.findElements(By.tagName("td"));
	    Assert.assertEquals(cells.get(1).getText(), subject);
	    Assert.assertEquals(cells.get(0).getText(), sender);
	    
	   	Calendar cal = Calendar.getInstance();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    	String currentTime = sdf.format(cal.getTime());
    	cal.add(Calendar.MINUTE, -1);
    	String oneMinAgoTime = sdf.format(cal.getTime());
	    String requestedDate = cells.get(2).getText();
 	    Assert.assertTrue(requestedDate.equals(currentTime) || requestedDate.equals(oneMinAgoTime));
	}
	
	@Then("^a message is in (.+)'s outbox with the subject \"(.*?)\" recipient (.+) and correct timestamp$")
	public void messageInOutbox(String outbox, String subject, String recipient) throws Throwable {
		(new MainMenuSteps(driver)).clicksMenuItem("HCP", "Message Outbox", "Messaging");
		verifyLatestMessage(subject, recipient);
	}

	@Then("^a bolded row for the message now appears in (.+)'s inbox with the subject \"(.*?)\" sender (.+) and correct timestamp$")
	public void checkBoldedRow(String inbox, String subject, String sender) throws Throwable {
		(new LoginSteps(driver)).logout();
		
		if(inbox.equals("HCP 1")) {
			(new LoginSteps(driver)).hcp_has_authenticated_successfully();
		} else if(inbox.equals("Patient 2")) {
			(new LoginSteps(driver)).patient_has_authenticated_successfully(2);	
		}		
		
		(new MainMenuSteps(driver)).clicksMenuItem("Patient", "Message Inbox", "Messaging");
		verifyLatestMessage(subject, sender);
	}
	
	@Given("^HCP 1 sent a message to Patient 2 with subject \"(.*?)\" and message \"(.*?)\"$")
	public void hcp_sent_a_message_to_Patient_with_subject_and_message(String subject, String msg) throws Throwable {
		(new LoginSteps(driver)).hcp_has_authenticated_successfully();
		(new MainMenuSteps(driver)).clicksMenuItem("HCP", "Message Outbox", "Messaging");
		hcp_clicks_Compose_a_Message();
		(new EditPatientSteps(driver)).searchForPatient("2");
		hcpSendsMsg(subject, msg);
		(new MainMenuSteps(driver)).clickLogout();
	}
	
	@When("^HCP chooses to sort their inbox by sender name in ascending order$")
	public void hcp_chooses_to_sort_their_inbox_by_sender_name_in_ascending_order() throws Throwable {
		
		// first display all entries
		Select entries = new Select(browser.findElement(By.cssSelector("#mailbox_length select")));
		entries.selectByVisibleText("100");
		
		// click on sender column to make reverse alphabetical
		browser.findElements(By.cssSelector("#mailbox thead th")).get(0).click();
		browser.findElements(By.cssSelector("#mailbox thead th")).get(0).click();
	}
	
	@When("^Patient chooses to sort their outbox by timestamp in descending order$")
	public void patient_chooses_to_sort_their_outbox_by_timestamp_in_descending_order() throws Throwable {
		
		// first display all entries
		Select entries = new Select(browser.findElement(By.cssSelector("#mailbox_length select")));
		entries.selectByVisibleText("100");
		
		// click on date column
		browser.findElements(By.cssSelector("#mailbox thead th")).get(2).click();
		browser.findElements(By.cssSelector("#mailbox thead th")).get(2).click();
	}

	@Then("^the (.+) contains messages with these (.+) in this order:$")
	public void containsMessagesInOrder(String box, String theField, List<String> expectedSenders) throws Throwable {

		// subject by default
		int fieldIndex = 1;
		if(theField.equals("authors")) {
			fieldIndex = 0;
		}
		
		int numberFound = 0;
	    List<WebElement> emails = browser.findElements(By.cssSelector("#mailbox tbody tr"));
		for(WebElement email : emails) {
			List<WebElement> fields = email.findElements(By.cssSelector("td"));
			String sender = fields.get(fieldIndex).getText();
			if(numberFound < expectedSenders.size() && sender.equals(expectedSenders.get(numberFound))) {
				numberFound++; // increment through expected list each time find expected sender
			}
		}
		
	    Assert.assertEquals(numberFound, expectedSenders.size());
	}
}