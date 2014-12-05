package edu.ncsu.csc.itrust.acceptance.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Then;

public class FakeEmailSteps {
    private final WebDriver browser;

    public FakeEmailSteps(SharedDriver browser)
    {
        this.browser = browser;
    }
    
	@Then("^a fake email has been sent to (.+) informing them that they now have a message waiting$")
	public void fakeEmailSentTo(String name) throws Throwable {
	    browser.findElement(By.linkText("Show Fake Emails")).click();
	    
	    String email = "";
	    if(name.equals("Patient 2")) {
	    	email = "andy.programmer@gmail.com";
	    } else if(name.equals("HCP 1")) {
	    	email = "kdoctor@iTrust.org";
	    }
	    
	    List<WebElement> emails = browser.findElements(By.cssSelector("table.results tr"));
	    WebElement mostRecentEmail = emails.get(1);
	    List<WebElement> cells = mostRecentEmail.findElements(By.tagName("td"));
	    Assert.assertEquals(cells.get(0).getText(), email);
	    Assert.assertTrue(cells.get(3).getText().contains("You have received a new message from"));
	}
	
}
