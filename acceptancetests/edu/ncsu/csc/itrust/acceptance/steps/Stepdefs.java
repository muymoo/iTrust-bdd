package edu.ncsu.csc.itrust.acceptance.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs
{
    @Given("^LHCP (\\d+), (\\d+), (\\d+) and Patient (\\d+) are in the database$")
    public void lhcp_and_Patient_are_in_the_database(long patient01, long patient02, int patient03, int patient04)
            throws Throwable
    {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("DEBUG: Are they in the database: " + patient01);
    }

    @Given("^Office Visits (\\d+)-(\\d+) are in the database\\.$")
    public void office_Visits_are_in_the_database(int arg1, int arg2)
            throws Throwable
    {
        // Write code here that turns the phrase above into concrete actions

    }

    @Given("^Patient (\\d+) has specified that HCP (\\d+) and (\\d+) are DLHCP's for him$")
    public void patient_has_specified_that_HCP_and_are_DLHCP_s_for_him(int arg1, int arg2, int arg3)
            throws Throwable
    {
        // Write code here that turns the phrase above into concrete actions
    }

    @Given("^Patient (\\d+) has authenticated successfully$")
    public void patient_has_authenticated_successfully(int arg1)
            throws Throwable
    {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^Patient clicks \"(.*?)\" link$")
    public void patient_clicks_My_Providers_link(String link)
            throws Throwable
    {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("DEBUG: Patient clicked link: " + link);
    }

    @Then("^The first result is (.*?)$")
    public void the_first_result_is(String doctorDetails)
            throws Throwable
    {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("DEBUG: The result should be: " + doctorDetails);
    }

}
