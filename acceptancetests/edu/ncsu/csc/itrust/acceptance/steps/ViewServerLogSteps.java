package edu.ncsu.csc.itrust.acceptance.steps;

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
		startDate.sendKeys(start);
		
		WebElement endDate = browser.findElement(By.cssSelector("input[name=\"endDate\"]"));
		endDate.sendKeys(end);
	}

	@When("^Patient chooses to view log sorted by date\\.$")
	public void patient_chooses_to_view_log_sorted_by_date(int arg1)
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^a list should be displayed$")
	public void a_list_should_be_displayed() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^Row (\\d+) should be Justin Time\\. ER\\. (\\d+)/(\\d+)/(\\d+) (\\d+):(\\d+)AM\\. Transaction Code (\\d+)\\.$")
	public void row_should_be_Justin_Time_ER_AM_Transaction_Code(int arg1,
			int arg2, int arg3, int arg4, int arg5, int arg6, int arg7)
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^Row (\\d+) should be Kelly Doctor \\(with a link to Kelly Doctor's personal information\\)\\. LHCP\\. (\\d+)/(\\d+)/(\\d+) (\\d+):(\\d+)PM\\. Transaction Code (\\d+)\\.$")
	public void row_should_be_Kelly_Doctor_with_a_link_to_Kelly_Doctor_s_personal_information_LHCP_PM_Transaction_Code(
			int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7)
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^Row (\\d+) should be Gandalf Stormcrow \\(with a link to Gandalf Stormcrow's personal information\\)\\. LHCP\\. (\\d+)/(\\d+)/(\\d+) (\\d+):(\\d+)PM\\. View\\. Transaction Code (\\d+)\\.$")
	public void row_should_be_Gandalf_Stormcrow_with_a_link_to_Gandalf_Stormcrow_s_personal_information_LHCP_PM_View_Transaction_Code(
			int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7)
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^Row (\\d+) should be Kelly Doctor \\(with a link to Kelly Doctor's personal information\\)\\. LHCP\\. (\\d+)/(\\d+)/(\\d+) (\\d+):(\\d+)AM\\. Transaction Code (\\d+)\\.$")
	public void row_should_be_Kelly_Doctor_with_a_link_to_Kelly_Doctor_s_personal_information_LHCP_AM_Transaction_Code(
			int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7)
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

}
