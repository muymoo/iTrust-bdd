package edu.ncsu.csc.itrust.acceptance.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * Base class that all steps should extend
 */
public class Step
{
    private static final String ITRUST_URL = "http://localhost:8080/iTrust/";
    protected WebDriver         browser;

    @Given("iTrust is running")
    public void beforeScenario()
    {
        this.browser = new FirefoxDriver();
        browser.get(ITRUST_URL);
    }

    @Then("I close the browser")
    public void afterScenario()
    {
        browser.close();
    }

}
