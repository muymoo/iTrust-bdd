package edu.ncsu.csc.itrust.acceptance.steps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.Format;
import cucumber.api.java.en.Then;

public class ViewAllPatientsSteps
{
    private final WebDriver browser;

    public ViewAllPatientsSteps(SharedDriver browser)
    {
        this.browser = browser;
    }

    @Then("^the following should be displayed: \"(.*?)\", \"(.*?)\", \"(.*?)\"$")
    public void the_following_should_be_displayed(String name, String address, @Format("yyyy-MM-dd") Date lastVisit)
            throws Throwable
    {
        Select numberOfPatients = new Select(browser.findElement(By.name("patientList_length")));
        numberOfPatients.selectByValue("100");

        String table = browser.findElement(By.id("patientList")).getText();
        System.out.println("Table: " + table);
        System.out.println("name: " + name);

        Assert.assertTrue(table.contains(name));
        System.out.println("address: " + address);

        Assert.assertTrue(table.contains(address));
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        System.out.println("date: " + formatter.format(lastVisit));
        Assert.assertTrue(table.contains(formatter.format(lastVisit)));

    }

}
