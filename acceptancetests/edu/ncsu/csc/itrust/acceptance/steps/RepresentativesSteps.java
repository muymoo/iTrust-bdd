package edu.ncsu.csc.itrust.acceptance.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;

public class RepresentativesSteps 
{
    private final WebDriver browser;
    private final SharedDriver driver;

    public RepresentativesSteps(SharedDriver browser)
    {
        this.browser = browser;
        this.driver = browser;
    }
    
    @Given("^Patient (.+) is a representative for Patient (.+)$")
    public void patient_is_a_representative_for_Patient(String representativePatientNum, String patientNum) throws Throwable {
		(new LoginSteps(driver)).hcp_has_authenticated_successfully();
		(new MainMenuSteps(driver)).clicksMenuItem("HCP", "Representatives", "Patient Info");
		(new EditPatientSteps(driver)).searchForPatient("HCP", patientNum);
		
		browser.findElement(By.cssSelector("input[value=\"Find User\"]")).click();
		
		driver.switchTo().frame("getUserFrame");
		browser.findElement(By.cssSelector("input[name=\"mid\"]")).sendKeys(representativePatientNum);
		browser.findElement(By.cssSelector("input[value=\"Search for User\"]")).click();
		browser.findElement(By.cssSelector("input[value=\"This user is correct\"]")).click();
		driver.switchTo().defaultContent();

		browser.findElement(By.cssSelector("input[value=\"Represent\"]")).click();
		
		(new MainMenuSteps(driver)).clickLogout();
    };
}
