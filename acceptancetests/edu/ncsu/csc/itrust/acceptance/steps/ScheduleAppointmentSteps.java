package edu.ncsu.csc.itrust.acceptance.steps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.Format;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScheduleAppointmentSteps
{
    private final WebDriver browser;

    public ScheduleAppointmentSteps(SharedDriver browser)
    {
        this.browser = browser;
    }

    @When("^HCP chooses to schedule a new appointment with: Patient: (\\d+), type:  \"(.*?)\" at \"(.*?)\" with comment \"(.*?)\"$")
    public void hcp_chooses_to_schedule_a_new_appointment_with_Patient_type_at_with_comment(int patientId,
            String appointmentType, @Format("h:mma MMMMMM d, yyyy") Date date, String comment)
            throws Throwable
    {
        browser.findElement(By.id("searchBox")).sendKeys(String.valueOf(patientId));
        browser.findElement(By.xpath("//*[@id=\"searchTarget\"]/table/tbody/tr[2]/td[1]/input")).click();

        Select appointmentDropDown = new Select(browser.findElement(By.name("apptType")));
        appointmentDropDown.selectByValue(appointmentType);

        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        WebElement scheduler = browser.findElement(By.name("schedDate"));
        scheduler.clear();
        scheduler.sendKeys(formatter.format(date));

        DateFormat hourFormat = new SimpleDateFormat("hh");
        Select hourDropDown = new Select(browser.findElement(By.name("time1")));
        hourDropDown.selectByValue(hourFormat.format(date));

        DateFormat minuteFormat = new SimpleDateFormat("mm");
        Select minuteDropDown = new Select(browser.findElement(By.name("time2")));
        minuteDropDown.selectByValue(minuteFormat.format(date));

        DateFormat amPmFormat = new SimpleDateFormat("a");
        Select amPmDropDown = new Select(browser.findElement(By.name("time3")));
        amPmDropDown.selectByValue(amPmFormat.format(date));

        browser.findElement(By.name("comment")).sendKeys(comment);
    }

    @When("^HCP clicks submit to save the new appointment$")
    public void hcp_clicks_submit_to_save_the_new_appointment()
            throws Throwable
    {
        browser.findElement(By.name("scheduleButton")).click();
    }

    @Then("^displays \"(.*?)\" with \"(.*?)\" for \"(.*?)\" for (\\d+) minutes with comment \"(.*?)\"$")
    public void displays_with_Kelly_Doctor_for_for_minutes_with(String type, String hcp,
            @Format("h:mma MMMMMM d, yyyy") Date date, int minutes, String comment)
            throws Throwable
    {
        String table = browser.findElement(By.xpath("//*[@id=\"iTrustContent\"]/div/table/tbody")).getText();
        Assert.assertTrue(table.contains(type));
        Assert.assertTrue(table.contains(hcp));

        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
        System.out.println(formatter.format(date));
        System.out.println(table);
        Assert.assertTrue(table.contains(formatter.format(date)));
        Assert.assertTrue(table.contains(String.valueOf(minutes)));
    }

}
