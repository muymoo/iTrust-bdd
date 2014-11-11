package edu.ncsu.csc.itrust.acceptance.steps;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyProviders
{

    private final WebDriver browser;

    public MyProviders(SharedDriver browser)
    {
        this.browser = browser;
    }

    @When("^Patient clicks checkbox to change Kelly Doctor from undesignated to designated$")
    public void patient_clicks_checkbox_to_change_Kelly_Doctor_from_undesignated_to_designated()
            throws Throwable
    {
        browser.findElement(By.xpath("//*[@id=\"hcp_table\"]/tbody/tr[3]/td[5]/input")).click();
    }

    @Then("^Row (\\d+) result is \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\"$")
    public void the_row_result_is(int rowNumber, String name, String specialty, String address, String date,
            String designatedHCP)
            throws Throwable
    {
        WebElement providerTable = browser.findElement(By.id("hcp_table"));
        List<WebElement> rowResult = providerTable.findElements(By.tagName("tr")).get(rowNumber)
                .findElements(By.tagName("td"));
        assertEquals(name, rowResult.get(0).getText());
        assertEquals(specialty, rowResult.get(1).getText());
        assertEquals(address, rowResult.get(2).getText());
        assertEquals(date, rowResult.get(3).getText());
        assertEquals(Boolean.parseBoolean(designatedHCP), rowResult.get(4).findElement(By.tagName("input"))
                .isSelected());
    }

    @When("^Patient enters \"(.*?)\" into the text box for finding a new HCP$")
    public void patient_enters_into_the_text_box_for_finding_a_new_HCP(String doctorName)
            throws Throwable
    {
        browser.findElement(By.name("doctor")).sendKeys(doctorName);
    }

    @When("^Patient enters \"(.*?)\" into the text box for limiting the search by specialty$")
    public void patient_enters_into_the_text_box_for_limiting_the_search_by_specialty(String specialty)
            throws Throwable
    {
        browser.findElement(By.name("filter_specialty")).sendKeys(specialty);
    }

    @When("^Patient clicks \"(.*?)\"$")
    public void patient_clicks(String arg1)
            throws Throwable
    {
        browser.findElement(By.name("update_filter")).submit();
    }

    @After("@hcp")
    public void afterScenario()
    {
        WebElement kellyDoctorDHCP = browser.findElement(By.xpath("//*[@id=\"hcp_table\"]/tbody/tr[3]/td[5]/input"));
        if ( kellyDoctorDHCP.isSelected() )
        {
            kellyDoctorDHCP.click();
        }
    }

}
