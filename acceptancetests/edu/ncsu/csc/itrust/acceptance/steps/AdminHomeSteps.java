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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.When;

public class AdminHomeSteps 
{
    private final WebDriver browser;

    public AdminHomeSteps(SharedDriver browser)
    {
        this.browser = browser;
    }

    @When("^Admin clicks the \"Add PHA\" link under the \"Add\" menu subheading\\.$")
    public void admin_clicks_the_Add_PHA_link_under_the_Add_menu_subheading()
            throws Throwable
    {
    	List<WebElement> menus = browser.findElements(By.cssSelector(
    			".iTrustMenuContents div.panel h2"));
    	menus.get(0).click();
    	
        WebElement addPha = browser.findElement(By.linkText("Add PHA"));
        addPha.click();
    }
}
