/*
 * Copyright (c) 2014 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */

package edu.ncsu.csc.itrust.acceptance.steps;


import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TelemedicineSteps 
{
    private final WebDriver browser;
    private final SharedDriver driver;

    public TelemedicineSteps(SharedDriver browser)
    {
        this.browser = browser;
        this.driver = browser;
    }

    @When("^(.+) confirms that he or she wishes to add Andy Programmer to the remote monitoring patient list$")
    public void hcp_confirms_that_he_or_she_wishes_to_add_Andy_Programmer_to_the_remote_monitoring_patient_list(String user) throws Throwable {
    	List<WebElement> removePatientBtns = browser.findElements(By.cssSelector("input[value=\"Remove Andy Programmer\"]"));
    	if(removePatientBtns.size() > 0) {
    		removePatientBtns.get(0).click();
    		(new MainMenuSteps(driver)).clicksMenuItem("HCP", "Edit Patient List", "Telemedicine");
    		if(user.equals("HCP")) {
    			(new EditPatientSteps(driver)).searchForPatient("HCP", "2");
    		}
    	}
    	
    	if(user.equals("UAP")) {
    		browser.findElement(By.cssSelector("input[value=\"Add Andy Programmer\"]")).click();
    	}
    }

    @When("^HCP specifies that Andy Programmer will report blood pressure, weight, and pedometer readings$")
    public void hcp_specifies_that_Andy_Programmer_will_report_blood_pressure_weight_and_pedometer_readings() throws Throwable {
        browser.findElement(By.cssSelector("input[name=\"bloodPressure\"]")).click();
        browser.findElement(By.cssSelector("input[name=\"weight\"]")).click();
        browser.findElement(By.cssSelector("input[name=\"pedometer\"]")).click();
		browser.findElement(By.cssSelector("input[value=\"Add Andy Programmer\"]")).click();
    }
    

	@When("^HCP confirms that he or she wishes to remove Random Person from the remote monitoring patient list$")
	public void hcp_confirms_that_he_or_she_wishes_to_remove_Random_Person_from_the_remote_monitoring_patient_list() throws Throwable {
		List<WebElement> addBtns = browser.findElements(By.cssSelector("input[value=\"Add Random Person\"]"));
		if(addBtns.size() > 0) {
			browser.findElement(By.cssSelector("input[value=\"Add Random Person\"]")).click();
			(new MainMenuSteps(driver)).clicksMenuItem("HCP", "Edit Patient List", "Telemedicine");
    		(new EditPatientSteps(driver)).searchForPatient("HCP", "1");
		}

		browser.findElement(By.cssSelector("input[value=\"Remove Random Person\"]")).click();
	}
	
	@Then("^Random Person has been successfully removed from the list of patients for remote monitoring$")
	public void random_Person_has_been_successfully_removed_from_the_list_of_patients_for_remote_monitoring() throws Throwable {
		String msg = browser.findElement(By.cssSelector("#iTrustContent .iTrustMessage")).getText();
        Assert.assertEquals(msg, "Patient Random Person Removed");
	}

    @Then("^Andy Programmer has been successfully added to the list of patients for remote monitoring$")
    public void andy_Programmer_has_been_successfully_added_to_the_list_of_patients_for_remote_monitoring() throws Throwable {
        String msg = browser.findElement(By.cssSelector("#iTrustContent .iTrustMessage")).getText();
        Assert.assertEquals(msg, "Patient Andy Programmer Added");
    }
}
