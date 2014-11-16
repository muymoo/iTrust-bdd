package edu.ncsu.csc.itrust.acceptance.steps;

import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EditAppointmentTypeSteps
{
    private final WebDriver browser;
    private int             randomDuration;
    private String          randomString;

    public EditAppointmentTypeSteps(SharedDriver browser)
    {
        this.browser = browser;
    }

    @When("^Admin chooses to add the appointment type named \"(.*?)\" with a duration of (\\d+) minutes$")
    public void admin_chooses_to_add_a_new_appointment_type_named_with_a_duration_of_minutes(String appointmentName,
            int duration)
            throws Throwable
    {
        randomDuration = new Random().nextInt(100);
        randomString = generateRandomString();

        browser.findElement(By.id("name")).sendKeys(appointmentName + randomString);
        browser.findElement(By.id("duration")).sendKeys(String.valueOf(randomDuration));
    }

    @When("^Admin chooses to edit the appointment type named \"(.*?)\" with a duration of (\\d+) minutes$")
    public void admin_chooses_to_edit_a_new_appointment_type_named_with_a_duration_of_minutes(String appointmentName,
            int duration)
            throws Throwable
    {
        randomDuration = new Random().nextInt(100);
        browser.findElement(By.id("name")).sendKeys(appointmentName);
        browser.findElement(By.id("duration")).sendKeys(String.valueOf(randomDuration));
    }

    private static String generateRandomString()
            throws Exception
    {

        StringBuffer buffer = new StringBuffer();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        int charactersLength = characters.length();

        for (int i = 0; i < 10; i++)
        {
            double index = Math.random() * charactersLength;
            buffer.append(characters.charAt((int) index));
        }
        return buffer.toString();
    }

    @When("^Admin clicks submit to save the appointment type$")
    public void admin_clicks_submit_to_save_the_new_appointment_type()
            throws Throwable
    {
        browser.findElement(By.id("add")).click();
    }

    @When("^Admin clicks submit to update the appointment type$")
    public void admin_clicks_submit_to_update_the_new_appointment_type()
            throws Throwable
    {
        browser.findElement(By.id("update")).click();
    }

    @Then("^the \"(.*?)\" appointment type is now included in the list of appointment types, with duration of (\\d+) minutes$")
    public void the_new_appointment_type_is_now_included_in_the_list_of_appointment_types_with_duration_of_minutes(
            String appointmentType, int duration)
            throws Throwable
    {
        Assert.assertTrue(browser.findElement(By.xpath("//*[@id=\"mainForm\"]/table[2]/tbody")).getText()
                .contains(appointmentType + randomString));

        Assert.assertTrue(browser.findElement(By.xpath("//*[@id=\"mainForm\"]/table[2]/tbody")).getText()
                .contains(String.valueOf(randomDuration)));
    }

    @Then("^the \"(.*?)\" appointment type is now included in the list of appointment types, with updated duration of (\\d+) minutes$")
    public void the_new_appointment_type_is_now_included_in_the_list_of_appointment_types_with_updated_duration_of_minutes(
            String appointmentType, int duration)
            throws Throwable
    {
        Assert.assertTrue(browser.findElement(By.xpath("//*[@id=\"mainForm\"]/table[2]/tbody")).getText()
                .contains(appointmentType));

        Assert.assertTrue(browser.findElement(By.xpath("//*[@id=\"mainForm\"]/table[2]/tbody")).getText()
                .contains(String.valueOf(randomDuration)));
    }
}
