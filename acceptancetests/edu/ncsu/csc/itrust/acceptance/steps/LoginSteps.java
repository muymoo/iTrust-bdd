package edu.ncsu.csc.itrust.acceptance.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;

public class LoginSteps
{
    private final WebDriver browser;

    public LoginSteps(SharedDriver browser)
    {
        this.browser = browser;
    }

    @Given("^(?:ER|Admin) \"(.*?)\" has authenticated successfully$")
    public void admin_has_authenticated_successfully(String id)
            throws Throwable
    {
        browser.findElement(By.name("j_username")).sendKeys(id);
        browser.findElement(By.name("j_password")).sendKeys(String.valueOf("pw"));
        browser.findElement(By.name("j_password")).submit();
    }

    @Given("^HCP 1 has authenticated successfully$")
    public void hcp_has_authenticated_successfully()
            throws Throwable
    {
        browser.findElement(By.name("j_username")).sendKeys(String.valueOf("9000000000"));
        browser.findElement(By.name("j_password")).sendKeys(String.valueOf("pw"));
        browser.findElement(By.name("j_password")).submit();
    }

    @Given("^(?:ER|Patient) (\\d+) has authenticated successfully$")
    public void patient_has_authenticated_successfully(int patientId)
            throws Throwable
    {
        browser.findElement(By.name("j_username")).sendKeys(String.valueOf(patientId));
        browser.findElement(By.name("j_password")).sendKeys(String.valueOf("pw"));
        browser.findElement(By.name("j_password")).submit();
    }
}
