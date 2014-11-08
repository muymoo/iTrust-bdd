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

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EditPersonnelSteps 
{
    private final WebDriver browser;

    public EditPersonnelSteps(SharedDriver browser)
    {
        this.browser = browser;
    }

    @When("^Admin enters: Address: 123 Oak Hills Drive City: Capitol City State: North Carolina Zip: 28700-0458 Phone: 555-877-5105$")
    public void admin_enters_Address_Oak_Hills_Drive_City_Capitol_City_State_North_Carolina_Zip_Phone()
            throws Throwable
    {
        WebElement address1 = browser.findElement(By.cssSelector(
        		"input[name=\"streetAddress1\"]"));
        address1.sendKeys("123 Oak Hills Drive");
        
        WebElement city = browser.findElement(By.cssSelector(
        		"input[name=\"city\"]"));
        city.sendKeys("Capitol City");
        
        Select state = new Select(browser.findElement(By.cssSelector(
        		"select[name=\"state\"]")));
        state.selectByVisibleText("North Carolina");
        
        WebElement zip = browser.findElement(By.cssSelector(
        		"input[name=\"zip\"]"));
        zip.sendKeys("28700-0458"); 

        WebElement phone = browser.findElement(By.cssSelector(
        		"input[name=\"phone\"]"));
        phone.sendKeys("555-877-5105");
    }

    @When("^Admin clicks the \"Edit PHA Record\" button\\.$")
    public void admin_clicks_the_Edit_PHA_Record_button()
            throws Throwable
    {
        WebElement submit = browser.findElement(By.cssSelector(
        		"input[value=\"Edit Personnel Record\"]"));
        submit.click();
    }

    @Then("^A new Public Health Agent is added$")
    //with the following information: First Name: Tim Last Name: Agent Address: (\\d+) Oak Hills DriveCity: Capitol City State: North Carolina Zip: (\\d+)-(\\d+) Phone: (\\d+)-(\\d+)-(\\d+) Email: pha@timagent\\.com$")
    public void a_new_Public_Health_Agent_is_added_with_the_following_information_First_Name_Tim_Last_Name_Agent_Address_Oak_Hills_DriveCity_Capitol_City_State_North_Carolina_Zip_Phone_Email_pha_timagent_com()
            throws Throwable
    {
        WebElement successMessage = browser.findElement(By.cssSelector(
        		"#iTrustContent span.iTrustMessage"));
        assertEquals(successMessage.getText(), "Information Successfully Updated");
    }

}
