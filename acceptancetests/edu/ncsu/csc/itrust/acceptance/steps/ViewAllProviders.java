package edu.ncsu.csc.itrust.acceptance.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ViewAllProviders
{

    private final WebDriver browser;

    public ViewAllProviders(SharedDriver browser)
    {
        this.browser = browser;
    }

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
    public void patient_has_authenticated_successfully(int patientId)
            throws Throwable
    {
        browser.findElement(By.name("j_username")).sendKeys(String.valueOf(patientId));
        browser.findElement(By.name("j_password")).sendKeys(String.valueOf("pw"));
        browser.findElement(By.name("j_password")).submit();
    }

    @When("^Patient clicks \"(.*?)\" link$")
    public void patient_clicks_My_Providers_link(String link)
            throws Throwable
    {
        // Write code here that turns the phrase above into concrete actions
        browser.findElement(By.xpath("//*[@id=\"iTrustMenu\"]/div/div[2]/div[1]")).click();

        browser.findElement(By.linkText(link)).click();
    }

    @Then("^The first result is \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\"$")
    public void the_first_result_is(String name, String specialty, String address, String date, String designatedHCP)
            throws Throwable
    {

        WebElement providerTable = browser.findElement(By.id("hcp_table"));
        int secondRowIndex = 1;
        List<WebElement> firstResult = providerTable.findElements(By.tagName("tr")).get(secondRowIndex)
                .findElements(By.tagName("td"));
        assertEquals("Gandalf Stormcrow", firstResult.get(0).getText());
        assertEquals("none", firstResult.get(1).getText());
        assertEquals("4321 My Road St PO BOX 2 New York, NY 10453", firstResult.get(2).getText());
        assertEquals("09/14/2009", firstResult.get(3).getText());
        assertTrue(firstResult.get(4).findElement(By.tagName("input")).isSelected());
    }
}
