package edu.ncsu.csc.itrust.acceptance.steps;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;

public class CreatePatientSteps {

    private final SharedDriver browser;
    
    public static String lastCreatedPatientName;
    
    public CreatePatientSteps(SharedDriver browser)
    {
        this.browser = browser;
    }
	 
    @Given("I have a new patient")
    public void createNewPatient() throws Throwable {
    	MainMenuSteps mainmenusteps = new MainMenuSteps(browser);
    	mainmenusteps.clicksMenuItem("HCP", "Patient", "Add");
    	
	    String first = RandomStringUtils.randomAlphabetic(10);
	    String last = RandomStringUtils.randomAlphabetic(10);
	    
	    WebElement firstName = browser.findElement(By.cssSelector("input[name=\"firstName\"]"));
	    firstName.sendKeys(first);
	    
	    WebElement lastName = browser.findElement(By.cssSelector("input[name=\"lastName\"]"));
	    lastName.sendKeys(last);
	    
	    lastCreatedPatientName = firstName + " " + lastName;
	    
	    WebElement email = browser.findElement(By.cssSelector("input[name=\"email\"]"));
	    email.sendKeys("myemail@gmail.com");
	    
	    WebElement addBtn = browser.findElement(By.cssSelector("input[value=\"Add patient\"]"));
	    addBtn.click();
    }
	
}
