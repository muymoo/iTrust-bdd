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

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddPublicHealthAgent 
{

    @Given("^Admin has authenticated successfully\\.$")
    public void admin_has_authenticated_successfully()
            throws Throwable
    {
//        browser.findElement(By.name("j_username")).sendKeys(String.valueOf("9000000001"));
//        browser.findElement(By.name("j_password")).sendKeys(String.valueOf("pw"));
//        browser.findElement(By.name("j_password")).submit();
//        assertEquals("Welcome, Shape Shifter", browser.findElement(By.className("welcome")).getText());
    }

    @When("^Admin clicks the “Add PHA” link under the “Add” menu subheading\\.$")
    public void admin_clicks_the_Add_PHA_link_under_the_Add_menu_subheading()
            throws Throwable
    {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^Admin enters: first name: Tim last name: Agent email: pha@timagent\\.com$")
    public void admin_enters_first_name_Tim_last_name_Agent_email_pha_timagent_com()
            throws Throwable
    {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^Admin clicks the “Continue to PHA information” link\\.$")
    public void admin_clicks_the_Continue_to_PHA_information_link()
            throws Throwable
    {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^Admin enters: Address: (\\d+) Oak Hills Drive City: Capitol City State: North Carolina Zip: (\\d+)-(\\d+) Phone: (\\d+)-(\\d+)-(\\d+)$")
    public void admin_enters_Address_Oak_Hills_Drive_City_Capitol_City_State_North_Carolina_Zip_Phone(int arg1,
            int arg2, int arg3, int arg4, int arg5, int arg6)
            throws Throwable
    {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^Admin (\\d+) clicks the “Edit PHA Record” button\\.$")
    public void admin_clicks_the_Edit_PHA_Record_button(int arg1)
            throws Throwable
    {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^A new Public Health Agent is added with the following information: First Name: Tim Last Name: Agent Address: (\\d+) Oak Hills DriveCity: Capitol City State: North Carolina Zip: (\\d+)-(\\d+) Phone: (\\d+)-(\\d+)-(\\d+) Email: pha@timagent\\.com$")
    public void a_new_Public_Health_Agent_is_added_with_the_following_information_First_Name_Tim_Last_Name_Agent_Address_Oak_Hills_DriveCity_Capitol_City_State_North_Carolina_Zip_Phone_Email_pha_timagent_com(
            int arg1, int arg2, int arg3, int arg4, int arg5, int arg6)
            throws Throwable
    {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}
