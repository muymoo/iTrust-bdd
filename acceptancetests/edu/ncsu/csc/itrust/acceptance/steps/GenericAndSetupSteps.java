package edu.ncsu.csc.itrust.acceptance.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class GenericAndSetupSteps {

    private final WebDriver browser;
    private final SharedDriver driver;
    
    public GenericAndSetupSteps(SharedDriver browser)
    {
    	this.driver = browser;
        this.browser = browser;
    }
    
	@When("^(.*?) clicks the \"(.*?)\" link$")
	public void hcp_clicks_the_link(String person, String linkText) throws Throwable {
	    WebElement link = browser.findElement(By.linkText(linkText));
	    link.click();
	}
	
	/**
	 * Log in and give Patient 2 an office visit, then logout
	 */
	@Given("^Patient 2 visited the office on (.+)$")
	public void patient_visited_the_office_on(String date) throws Throwable {
		(new LoginSteps(driver)).hcp_has_authenticated_successfully();
		(new MainMenuSteps(driver)).clicksMenuItem("HCP", "Document Office Visit", "Office Visits");
		(new EditPatientSteps(driver)).searchForPatient("HCP", "2");
		(new DocumentOfficeVisitSteps(driver)).hcp_clicks();
		(new DocumentOfficeVisitSteps(driver)).hcp_enters_the_date_and_clicks(date);
		(new MainMenuSteps(driver)).clickLogout();
	}
}
