package edu.ncsu.csc.itrust.acceptance.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;

public class ViewMyDiagnosesSteps
{
    private final WebDriver browser;

    public ViewMyDiagnosesSteps(SharedDriver browser)
    {
        this.browser = browser;
    }

    @Then("^displays in diagnoses \"(.*?)\"$")
    public void displays(String diagnoses)
            throws Throwable
    {
        String table = browser.findElement(By.xpath("// *[@id=\"iTrustContent\"]/div/table/tbody")).getText();
        Assert.assertTrue(table.contains(diagnoses));
    }

}
