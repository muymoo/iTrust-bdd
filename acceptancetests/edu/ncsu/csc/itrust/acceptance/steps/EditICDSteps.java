package edu.ncsu.csc.itrust.acceptance.steps;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EditICDSteps
{
    private final WebDriver browser;
    private String randomCode;

    public EditICDSteps(SharedDriver browser)
    {
        this.browser = browser;
    }

    @When("^Enter the following information into the form: Code: \"(.*?)\" Description: \"(.*?)\" Chronic: \"(.*?)\"$")
    public void enter_the_following_information_into_the_form_Code_Description_Chronic(String code, String description,
            String isChronic)
            throws Throwable
    {
        Random rand = new Random();
        randomCode = String.valueOf(rand.nextInt(100000)/100.00f);
        
        browser.findElement(By.name("code")).sendKeys(randomCode);
        browser.findElement(By.name("description")).sendKeys(description);
        if ( Boolean.parseBoolean(isChronic) )
        {
            browser.findElement(By.name("classification")).click();
        }
    }

    @When("^Click the \"(.*?)\" button$")
    public void click_the_button(String arg1)
            throws Throwable
    {
        browser.findElement(By.name("add")).click();
    }

    @Then("^The current ICD Codes contain: Code: \"(.*?)\" Description: \"(.*?)\" Chronic: \"(.*?)\"$")
    public void the_current_ICD_Codes_contain_Code_Description_Chronic(String code, String description, String isCronic)
            throws Throwable
    {
        assertTrue(browser.findElement(By.xpath("//*[@id=\"iTrustContent\"]/div/form/table[2]/tbody")).getText().contains(randomCode));
    }

}
