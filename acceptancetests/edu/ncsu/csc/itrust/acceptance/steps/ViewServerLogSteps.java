package edu.ncsu.csc.itrust.acceptance.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ViewServerLogSteps {
	private final WebDriver browser;
	
	public ViewServerLogSteps(SharedDriver browser) {
		this.browser = browser;
	}
	
	@When("^Patient enters Start Date: \"(.*?)\" and End Date: \"(.*?)\"$")
	public void patient_enters_Start_Date_and_End_Date(String start, String end) throws Throwable {
		WebElement startDate = browser.findElement(By.cssSelector("input[name=\"startDate\"]"));
		startDate.clear();
		startDate.sendKeys(start);
		
		WebElement endDate = browser.findElement(By.cssSelector("input[name=\"endDate\"]"));
		endDate.clear();
		endDate.sendKeys(end);
	}

	@When("^Patient chooses to view log sorted by date$")
	public void patient_chooses_to_view_log_sorted_by_date()
			throws Throwable {
		WebElement filterRecords = browser.findElement(By.cssSelector("input[value=\"Filter Records\"]"));
		filterRecords.click();
	}

	@Then("^a list should be displayed$")
	public void a_list_should_be_displayed() throws Throwable {
		WebElement list = browser.findElement(By.cssSelector("table.fTable"));
		List<WebElement> rows = list.findElements(By.cssSelector("tbody tr"));
		Assert.assertEquals(rows.size(), 4);
	}
	
	@Then("^AL Row (\\d+) should be (.+)\\. (.+)\\. (.+)\\.$")
	public void row_should_be(int rowNum, String accessor, String role, String description) throws Throwable {
		WebElement list = browser.findElement(By.cssSelector("table.fTable"));
		List<WebElement> rows = list.findElements(By.cssSelector("tbody tr"));
		
	    WebElement row = rows.get(rowNum);
	    List<WebElement> data = row.findElements(By.tagName("td"));
	    Assert.assertEquals(data.get(1).getText(), accessor);
	    Assert.assertEquals(data.get(2).getText(), role);
	    Assert.assertEquals(data.get(3).getText(), description);
	}
}
