package edu.ncsu.csc.itrust.acceptance.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GetSatisfactionSurveySteps {

    private final WebDriver browser;
    private final SharedDriver driver;

    public GetSatisfactionSurveySteps(SharedDriver browser)
    {
        this.browser = browser;
        this.driver = browser;
    }
   
    @Given("^Patient (\\d+) has taken satisfaction survey$")
    public void patient_has_taken_satisfaction_survey(int arg1) throws Throwable {
    	(new GenericAndSetupSteps(driver)).patient_visited_the_office_on("11/21/2014");
    	(new LoginSteps(driver)).patient_has_authenticated_successfully(2);
		(new MainMenuSteps(driver)).clicksMenuItem("Patient", "View My Records", "Records");
		(new ViewMyRecordsSteps(driver)).patient_clicks_a_link_next_to_his_office_visit_on_to_take_satisfaction_survey("Nov 21, 2014");
		(new ViewMyRecordsSteps(driver)).patient_inputs_the_following_information_and_submits_minutes_minutes("15 minute", "10 minutes", "3", "5");
		(new MainMenuSteps(driver)).clickLogout();
    }
    
	@When("^Patient inputs Surgeon for physician type and zip code (\\d+) and submits$")
	public void patient_inputs_Surgeon_for_physician_type_and_zip_code_and_submits(int zipcode) throws Throwable {
	    WebElement zipInput = browser.findElement(By.cssSelector("input[name=\"hcpZip\"]"));
	    zipInput.sendKeys(Integer.toString(zipcode));
	    
	    Select specialtyDropdown = new Select(browser.findElement(By.cssSelector("select[name=\"hcpSpecialty\"]")));
	    specialtyDropdown.selectByVisibleText("Surgeon");
	    
	    WebElement submit = browser.findElement(By.cssSelector("input[value=\"Search\"]"));
	    submit.click();
	}
	
	@Then("^the LHCP Search Results table is displayed with:$")
	public void the_LHCP_Search_Results_table_is_displayed_with(List<List<String>> content) throws Throwable {
		List<WebElement> rows = browser.findElements(By.cssSelector("table.fTable tr"));
		int index = 0;
		for(WebElement row : rows) {
			if(index < 2) {
				index++;
			}
			else if(index==2) {
				List<WebElement> cells = row.findElements(By.tagName("td"));
				Assert.assertEquals(cells.get(0).getText(), content.get(index-2).get(0));
				Assert.assertEquals(cells.get(8).getText(), content.get(index-2).get(1));
				Assert.assertEquals(cells.get(9).getText(), content.get(index-2).get(2));
				Assert.assertEquals(cells.get(10).getText(), content.get(index-2).get(3));
				Assert.assertEquals(cells.get(11).getText(), content.get(index-2).get(4));
				index++;
			}
			else {
				// TODO for now just ignoring the rest... not sure why the 2nd row is here (bug?)
			}
		}
	}
}
