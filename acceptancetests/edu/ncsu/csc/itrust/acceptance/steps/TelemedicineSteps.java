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


import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
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
    
    private String getPatientName(String num) {
		String patientName = "Random Person";
		if(num.equals("2")) {
			patientName = "Andy Programmer";
		}
		if(num.equals("5")) {
			patientName = "Baby Programmer";
		}
		return patientName;
    }
    
    private String getPatientId(String name) {
    	String id = "1";
		if(name.equals("Andy Programmer")) {
			id = "2";
		}
		else if(name.equals("Baby Programmer")) {
			id = "5";
		}
		return id;
    }
    
    @Given("^Patient (.+) is currently being monitored by HCP 1 for (.+)$")
    public void patient_is_currently_being_monitored_by_HCP_for_blood_pressure_and_glucose_levels(String patientNum, String thingsToMonitor) throws Throwable {
		(new LoginSteps(driver)).hcp_has_authenticated_successfully();
		(new MainMenuSteps(driver)).clicksMenuItem("HCP", "Edit Patient List", "Telemedicine");
		(new EditPatientSteps(driver)).searchForPatient("HCP", patientNum);
		
		String patientName = getPatientName(patientNum);
		addPatientToRemoteMonitoring("HCP", patientName);
		chooseThingstoMonitorAndConfirm(patientName, thingsToMonitor);
		(new MainMenuSteps(driver)).clickLogout();
    }
    
    @Given("^Patient (\\d+) has self-reported Systolic: (.+); Diastolic: (.+); and glucose: (.+)$")
    public void patient_has_self_reported_Systolic_Diastolic_and_glucose(int patientNum, String sbp, String dbp, String glucose) throws Throwable {
		(new LoginSteps(driver)).patient_has_authenticated_successfully(patientNum);
		(new MainMenuSteps(driver)).clicksMenuItem("Patient", "Report Telemedicine Status", "Telemedicine");
		enterSbpDbpGlucose(sbp, dbp, glucose);
		clickReport();
		bloodPressureAndGlucoseSuccessfullyReported(patientNum);
		(new MainMenuSteps(driver)).clickLogout();
    }
    
    @Given("^UAP has reported Systolic: (\\d+); Diastolic: (\\d+); and glucose: (\\d+) for Patient (.+)$")
    public void uap_has_reported_Systolic_Diastolic_and_glucose_for_Patient(String sbp, String dbp, String glucose, String patientNum) throws Throwable {
    	(new LoginSteps(driver)).uap_has_authenticated_successfully();
		(new MainMenuSteps(driver)).clicksMenuItem("Patient", "Edit Patient List", "Telemedicine");
		(new EditPatientSteps(driver)).searchForPatient("HCP", patientNum);
		addPatientToRemoteMonitoring("UAP", getPatientName(patientNum));
		(new MainMenuSteps(driver)).clicksMenuItem("Patient", "Report Telemedicine Status", "Telemedicine");
		enterSbpDbpGlucose(sbp, dbp, glucose);
		clickReport();
		bloodPressureAndGlucoseSuccessfullyReported(Integer.parseInt(patientNum));
		(new MainMenuSteps(driver)).clickLogout();
    }
    
    @Given("^Patient (\\d+) has reported Systolic: (\\d+); Diastolic: (\\d+); and glucose: (\\d+) for Patient (\\d+)$")
    public void patient_has_reported_Systolic_Diastolic_and_glucose_for_Patient(String patientNum, String sbp, String dbp, String glucose, String patientNumFor) throws Throwable {
    	(new LoginSteps(driver)).patient_has_authenticated_successfully(Integer.parseInt(patientNum));
		(new MainMenuSteps(driver)).clicksMenuItem("Patient", "Report Telemedicine Status", "Telemedicine");
		browser.findElement(By.linkText(getPatientName(patientNumFor))).click();
		enterSbpDbpGlucose(sbp, dbp, glucose);
		clickReport();
		bloodPressureAndGlucoseSuccessfullyReported(Integer.parseInt(patientNumFor));
		(new MainMenuSteps(driver)).clickLogout();
    }

    @When("^(.+) confirms that he or she wishes to add (.+) to the remote monitoring patient list$")
    public void addPatientToRemoteMonitoring(String user, String patient) throws Throwable {
    	List<WebElement> removePatientBtns = browser.findElements(By.cssSelector("input[value=\"Remove " + patient + "\"]"));
    	if(removePatientBtns.size() > 0) {
    		removePatientBtns.get(0).click();
    		(new MainMenuSteps(driver)).clicksMenuItem("HCP", "Edit Patient List", "Telemedicine");
    		if(user.equals("HCP")) {
    			String idToSearch = getPatientId(patient);
    			(new EditPatientSteps(driver)).searchForPatient("HCP", idToSearch);
    		}
    	}
    	
    	if(user.equals("UAP")) {
    		browser.findElement(By.cssSelector("input[value=\"Add " + patient + "\"]")).click();
    	}
    }

    @When("^HCP specifies that (.+) will report (.+)$")
    public void chooseThingstoMonitorAndConfirm(String patientName, String thingsToMonitor) throws Throwable {
    	if(thingsToMonitor.contains("blood pressure")) {
            browser.findElement(By.cssSelector("input[name=\"bloodPressure\"]")).click();    		
    	}
    	if(thingsToMonitor.contains("weight")) {
            browser.findElement(By.cssSelector("input[name=\"weight\"]")).click();    		
    	}
    	if(thingsToMonitor.contains("pedometer")) {
            browser.findElement(By.cssSelector("input[name=\"pedometer\"]")).click();
    	}
    	if(thingsToMonitor.contains("glucose")) {
    		browser.findElement(By.cssSelector("input[name=\"glucose\"]")).click();
    	}
		browser.findElement(By.cssSelector("input[value=\"Add " + patientName + "\"]")).click();
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
    
    @When("^Patient enters their systolic blood pressure: (.+), diastolic blood pressure: (.+), and glucose level: (.+)$")
    public void enterSbpDbpGlucose(String sbp, String dbp, String glucose) throws Throwable {
		browser.findElement(By.cssSelector("input[name=\"systolicBloodPressure\"]")).sendKeys(sbp);
		browser.findElement(By.cssSelector("input[name=\"diastolicBloodPressure\"]")).sendKeys(dbp);
		browser.findElement(By.cssSelector("input[name=\"glucoseLevel\"]")).sendKeys(glucose);
    }

    @When("^Patient clicks the \"Report\" button$")
    public void clickReport() throws Throwable {
		browser.findElement(By.cssSelector("input[value=\"Report\"]")).click();
    }

    @Then("^Patient (\\d+)'s blood pressure and glucose level are successfully reported$")
    public void bloodPressureAndGlucoseSuccessfullyReported(int arg1) throws Throwable {
		String msg = browser.findElement(By.cssSelector("#iTrustContent .iTrustMessage")).getText();
        Assert.assertEquals(msg, "Information Successfully Added");
    }
    
    @Then("^a list of reported information is displayed for the current date\\. The following information is displayed:$")
    public void a_list_of_reported_information_is_displayed_for_the_current_date_The_following_information_is_displayed(List<List<String>> expected) throws Throwable {

    	WebElement correctTable = null;
    	List<WebElement> tables = browser.findElements(By.cssSelector("table"));
    	for(WebElement table : tables) {
    		List<WebElement> titles = table.findElements(By.cssSelector("th"));
    		for(WebElement title : titles) {
        		if(title.getText().equals("Patient Physiologic Statistics")) {
        			correctTable = table;
        			break;
        		}	
    		}
    	}

    	List<WebElement> rows = correctTable.findElements(By.cssSelector("tr"));

        // Start at index 2 so we skip title row and headers
        for (int i = 2; i < rows.size(); i++)
        {
        	if(expected.size() == i-2) {
        		break;
        	}
            List<WebElement> realRow = rows.get(i).findElements(By.tagName("td"));
            List<String> expectedRow = expected.get(i - 2);

            assertEquals(expectedRow.get(0), realRow.get(0).getText());
            if(!expectedRow.get(1).equals("")) {
            	assertEquals(expectedRow.get(1), realRow.get(1).getText());
            }
            assertEquals(expectedRow.get(2), realRow.get(2).getText());
            assertEquals(expectedRow.get(3), realRow.get(3).getText());
            assertEquals(expectedRow.get(4), realRow.get(4).getText());
            assertEquals(expectedRow.get(5), realRow.get(5).getText());
        }
    }
    
}
