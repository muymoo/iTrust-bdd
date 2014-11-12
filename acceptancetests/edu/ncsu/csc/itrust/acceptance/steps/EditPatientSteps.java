package edu.ncsu.csc.itrust.acceptance.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EditPatientSteps {

    private final WebDriver browser;

    public EditPatientSteps(SharedDriver browser)
    {
        this.browser = browser;
    }
    
    @When("^HCP searches and selects (\\d+)$")
    public void hcp_searches_and_selects(int arg1) throws Throwable {
        WebElement searchBox = browser.findElement(By.id("searchBox"));
        searchBox.sendKeys("2");
        
        WebElement result = browser.findElement(By.cssSelector("#searchTarget table input[value=\"2\"]"));
        result.click();
    }

    @When("^HCP chooses \"(.*?)\"$")
    public void hcp_chooses(String linkText) throws Throwable {
    	List<WebElement> options = browser.findElement(By.cssSelector(".patient-navigation")).findElements(By.xpath(".//*"));
    	for(WebElement opt : options) {
    		if(opt.getText().equals(linkText)) {
    			opt.click();
    		}
    	}
    }

    @Then("^the BMI is automatically calculated and displayed as (.+) for the (.+) recording$")
    public void the_BMI_is_automatically_calculated_and_displayed_as_for_the_recording(String expectBMI, String expectDateTime) throws Throwable {
        List<WebElement> rows = browser.findElements(By.cssSelector("#HealthRecordsTable tr"));
        int rowNum = 0;
        for(WebElement row : rows) {
        	if(rowNum < 2) {
        		// skip this (it's a header row)
        	}
        	else {
        		List<WebElement> data = row.findElements(By.tagName("td"));
        		String dateTime = data.get(12).getText();
        		if(expectDateTime.equals(dateTime)) {
        			Assert.assertEquals(expectBMI, data.get(3).getText());
        			return;
        		}
        	}
        	rowNum++;
        }
        Assert.assertTrue(false);
    }
    
    @When("^HCP views the patient's weight chart$")
    public void hcp_views_the_patient_s_weight_chart() throws Throwable {
        WebElement weightChartLink = browser.findElement(By.id("viewWeightChart"));
        weightChartLink.click();
    }

    @Then("^there is an error that there is no data in the past years$")
    public void there_is_an_error_that_there_is_no_data_in_the_past_years() throws Throwable {
        WebElement error = browser.findElement(By.cssSelector(".iTrustMessage"));
        Assert.assertEquals(error.getText(), "Patient has no data available from the past 3 years");
    }
}
