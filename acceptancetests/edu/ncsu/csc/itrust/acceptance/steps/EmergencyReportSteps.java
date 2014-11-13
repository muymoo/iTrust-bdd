package edu.ncsu.csc.itrust.acceptance.steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;

public class EmergencyReportSteps
{
    private final WebDriver browser;

    public EmergencyReportSteps(SharedDriver browser)
    {
        this.browser = browser;
    }

    @Then("^Enter MID (\\d+) into the form$")
    public void enter_MID_into_the_form(int mid)
            throws Throwable
    {
        browser.findElement(By.id("searchBox")).sendKeys(String.valueOf(mid));
    }

    @Then("^Submit it$")
    public void submit_it()
            throws Throwable
    {
        // Wait and do nothing. Searches automatically
    }

    @Then("^Clicks on MID button$")
    public void clicks_on_MID_button()
            throws Throwable
    {
        browser.findElement(By.xpath("//*[@id=\"searchTarget\"]/table/tbody/tr[2]/td[1]/input")).click();;
    }

    @Then("^Content contains: Name: \"(.*?)\", Age: (\\d+), Gender: \"(.*?)\"$")
    public void content_contains_Name_Age_Gender(String name, int age, String gender)
            throws Throwable
    {
        String content = browser.findElement(By.id("iTrustContent")).getText();
        assertTrue(content.contains("Name: " + name));
        assertTrue(content.contains("Age: " + age));
        assertTrue(content.contains("Gender: " + gender));
    }

}
