/*
 * Copyright (c) 2014 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */

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
