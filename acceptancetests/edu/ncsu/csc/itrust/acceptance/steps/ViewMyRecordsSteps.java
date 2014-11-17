package edu.ncsu.csc.itrust.acceptance.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ViewMyRecordsSteps {
	private final WebDriver browser;
	
	public ViewMyRecordsSteps(SharedDriver browser) {
		this.browser = browser;
	}
	
	private WebElement getFamilyHistoryTable() {
	    List<WebElement> tables = browser.findElements(By.cssSelector("table"));
	    for(WebElement table : tables) {
	    	WebElement title = table.findElement(By.tagName("th"));
	    	if(title.getText().equals("Family Medical History")) {
	    		return table;
	    	}
	    }
	    return null;
	}

	@Then("^the Family Medical History table is displayed with (\\d+) rows\\.$")
	public void the_Family_Medical_History_table_is_displayed_with_rows(int numRows) throws Throwable {
		WebElement familyHistoryTable = getFamilyHistoryTable();
	    Assert.assertNotNull(familyHistoryTable);
	    
	    List<WebElement> rows = familyHistoryTable.findElements(By.tagName("tr"));
	    Assert.assertEquals(rows.size(), numRows+2);
	}

	@Then("^FMH Row (\\d+) should be (.+)\\. (.+)\\.(.*)$")
	public void rowShouldBe(int rowNum, String name, String relationship, String diabetesYes) throws Throwable {
		WebElement familyHistoryTable = getFamilyHistoryTable();	    
	    List<WebElement> rows = familyHistoryTable.findElements(By.tagName("tr"));

	    WebElement row = rows.get(rowNum + 1); //ignore subheading too
	    List<WebElement> data = row.findElements(By.tagName("td"));
	    Assert.assertEquals(data.get(0).getText(), name);
	    Assert.assertEquals(data.get(1).getText(), relationship);
	    Assert.assertEquals(data.get(2).getText(), "");
	    Assert.assertEquals(data.get(3).getText(), "");
	    if(diabetesYes.equals("Diabetes")) {
		    Assert.assertEquals(data.get(4).getText(), "x");
	    }
	    else {
		    Assert.assertEquals(data.get(4).getText(), "");
	    }
	    Assert.assertEquals(data.get(5).getText(), "");
	    Assert.assertEquals(data.get(6).getText(), "");
	    Assert.assertEquals(data.get(7).getText(), "");
	}
	

	@When("^Patient clicks a link next to his office visit on (.+) to take satisfaction survey$")
	public void patient_clicks_a_link_next_to_his_office_visit_on_to_take_satisfaction_survey(String date) throws Throwable {
	    
		// This is the grossest testing method I've probably ever written...
		// but there are like 11 tables on this page and no ids or anything. 
		List<WebElement> tables = browser.findElements(By.cssSelector("#iTrustContent table table"));
		for(WebElement table : tables) {
			List<WebElement> titles = table.findElements(By.cssSelector("th"));
			for(WebElement title : titles) {
				if(title.getText().equals("Office Visits")) {
					// if we find the Office Visits table
					List<WebElement> rows = table.findElements(By.tagName("tr"));
					for(WebElement row : rows) {
						List<WebElement> cells = row.findElements(By.tagName("td"));
						if(cells.size() > 0 && cells.get(0).getText().equals(date)) {
							// if it matches the date we want
							List<WebElement> links = cells.get(1).findElements(By.linkText("Complete Visit Survey"));
							if(links.size() > 0) {
								links.get(0).click();
								return;
							}
						}
					}
				}
			}
		}
		Assert.assertTrue(false);
	}
	
	@When("^Patient inputs the following information and submits: (.+) minutes, (.+) minutes, (.+), (.+)$")
	public void patient_inputs_the_following_information_and_submits_minutes_minutes(String mins1, 
			String mins2, String num1, String num2) throws Throwable {
	    if(!mins1.equals("[none]")) {
			WebElement waitingMinutes = browser.findElement(By.cssSelector("input[name=\"waitingMinutesString\"]"));
		    waitingMinutes.sendKeys(mins1);
	    }
	    
	    if(!mins2.equals("[none]")) {
		    WebElement examMinutes = browser.findElement(By.cssSelector("input[name=\"examMinutesString\"]"));
		    examMinutes.sendKeys(mins2);
	    }
	    
	    if(!num1.equals("[none]")) {
		    WebElement sat1 = browser.findElement(By.cssSelector("input[value=\"satRadio" + num1 + "\"]"));
		    sat1.click();
	    }
	    
	    if(!num2.equals("[none]")) {
		    WebElement sat2 = browser.findElement(By.cssSelector("input[value=\"treRadio" + num2 + "\"]"));
		    sat2.click();
	    }
	    
	    WebElement submit = browser.findElement(By.cssSelector("input[value=\"Submit Survey\"]"));
	    submit.click();
	}
	
	@Then("^the survey answers are stored and the event is logged$")
	public void the_survey_answers_are_stored_and_the_event_is_logged() throws Throwable {
	    WebElement message = browser.findElement(By.className("iTrustMessage"));
	    Assert.assertTrue(message.getText().contains("Survey Successfully Submitted"));
	}
}
