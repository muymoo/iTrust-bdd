package edu.ncsu.csc.itrust.acceptance.steps;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ReportsSteps {

    private final WebDriver browser;

    public ReportsSteps(SharedDriver browser)
    {
        this.browser = browser;
    }
    
	@When("^HCP views the newly generated comprehensive report for Patient 2$")
	public void hcp_views_the_newly_generated_comprehensive_report_for_Patient() throws Throwable {
	    List<WebElement> rows = browser.findElements(By.cssSelector("#iTrustContent table tbody tr"));
	    int lastRowIndex = rows.size() - 1;
	    WebElement lastRow = rows.get(lastRowIndex);
	    List<WebElement> data = lastRow.findElements(By.tagName("td"));
	    
	    Assert.assertEquals(data.get(1).getText(), "Andy Programmer");
	    Assert.assertEquals(data.get(4).getText(), "Requested");
	    
	   	Calendar cal = Calendar.getInstance();
    	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
    	String currentTime = sdf.format(cal.getTime());
    	cal.add(Calendar.MINUTE, -1);
    	String oneMinAgoTime = sdf.format(cal.getTime());
	    String requestedDate = data.get(2).getText();
 	    Assert.assertTrue(requestedDate.equals(currentTime) || requestedDate.equals(oneMinAgoTime));

 	    WebElement viewLink = data.get(5).findElement(By.tagName("a"));
 	    viewLink.click();
	}

	@Then("^HCP sees the Comprehensive Patient Report for Andy Programmer$")
	public void hcp_sees_the_Comprehensive_Patient_Report_for_Andy_Programmer() throws Throwable {
	    WebElement title = browser.findElement(By.cssSelector("#iTrustContent > h3"));
	    Assert.assertEquals(title.getText(), "Comprehensive Patient Report for Andy Programmer");
	}
}
