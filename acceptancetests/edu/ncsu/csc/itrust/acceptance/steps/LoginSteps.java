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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;

public class LoginSteps 
{
    private final WebDriver browser;

    public LoginSteps(SharedDriver browser)
    {
        this.browser = browser;
    }

    @Given("^Admin 9000000001 has authenticated successfully$")
    public void admin_has_authenticated_successfully()
            throws Throwable
    {
        browser.findElement(By.name("j_username")).sendKeys(String.valueOf("9000000001"));
        browser.findElement(By.name("j_password")).sendKeys(String.valueOf("pw"));
        browser.findElement(By.name("j_password")).submit();
        assertEquals("Welcome, Shape Shifter", browser.findElement(By.className("welcome")).getText());
    }
    
    @Given("^Patient (\\d+) has authenticated successfully$")
    public void patient_has_authenticated_successfully(int patientId)
            throws Throwable
    {
        browser.findElement(By.name("j_username")).sendKeys(String.valueOf(patientId));
        browser.findElement(By.name("j_password")).sendKeys(String.valueOf("pw"));
        browser.findElement(By.name("j_password")).submit();
    }
}
