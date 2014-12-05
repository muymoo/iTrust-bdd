package edu.ncsu.csc.itrust.acceptance.steps;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddPHASteps 
{
    private final WebDriver browser;

    public AddPHASteps(SharedDriver browser)
    {
        this.browser = browser;
    }

    @When("^Admin enters: first name: Frank last name: Sinatra email: frankie@gmail\\.com$")
    public void admin_enters_first_name_Tim_last_name_Agent_email_pha_timagent_com()
            throws Throwable
    {
        WebElement firstNameInput = browser.findElement(By.cssSelector(
        		"#iTrustContent input[name=\"firstName\"]"));
        firstNameInput.sendKeys("Frank");
        
        WebElement lastNameInput = browser.findElement(By.cssSelector(
        		"#iTrustContent input[name=\"lastName\"]"));
        lastNameInput.sendKeys("Sinatra");
        
        WebElement emailInput = browser.findElement(By.cssSelector(
        		"#iTrustContent input[name=\"email\"]"));
        emailInput.sendKeys("frankie@gmail.com");
        
        WebElement submitButton = browser.findElement(By.cssSelector(
        		"#iTrustContent input[value=\"Add personnel\"]"));
        submitButton.click();
    }

    @When("^Admin clicks the \"Continue to PHA information\" link\\.$")
    public void admin_clicks_the_Continue_to_PHA_information_link()
            throws Throwable
    {
    	WebElement continueToPhaLink = browser.findElement(By.linkText(
    			"Continue to personnel information."));
    	continueToPhaLink.click();
    }
}
