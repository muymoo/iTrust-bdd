package edu.ncsu.csc.itrust.acceptance.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.When;

/**
 * This class can make the most generic of generic steps for reuse.
 */
public class GenericSteps {

    private final WebDriver browser;

    public GenericSteps(SharedDriver browser)
    {
        this.browser = browser;
    }
    
	@When("^(.*?) clicks the \"(.*?)\" link$")
	public void hcp_clicks_the_link(String person, String linkText) throws Throwable {
	    WebElement link = browser.findElement(By.linkText(linkText));
	    link.click();
	}
}
