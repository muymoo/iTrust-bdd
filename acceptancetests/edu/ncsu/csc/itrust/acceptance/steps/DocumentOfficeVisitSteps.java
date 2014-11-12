package edu.ncsu.csc.itrust.acceptance.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.PendingException;
import cucumber.api.java.en.When;

public class DocumentOfficeVisitSteps {

    private final WebDriver browser;

    public DocumentOfficeVisitSteps(SharedDriver browser)
    {
        this.browser = browser;
    }
    
    @When("^HCP clicks \"Yes, Document Office Visit\"$")
    public void hcp_clicks() throws Throwable {
        WebElement btn = browser.findElement(By.cssSelector("input[value=\"Yes, Document Office Visit\"]"));
        btn.click();
    }

    @When("^HCP enters the date \"(.*?)\" and clicks create$")
    public void hcp_enters_the_date_and_clicks(String date) throws Throwable {
        WebElement dateInput = browser.findElement(By.cssSelector("input[name=\"visitDate\"]"));
        dateInput.clear();
        dateInput.sendKeys(date);
        
        WebElement createBtn = browser.findElement(By.id("update"));
        createBtn.click();
    }

    @When("^HCP selects Prescriptions and enters \"(.*?)\", (\\d+) mg, from \"(.*?)\" to \"(.*?)\", with instructions \"(.*?)\"$")
    public void hcp_selects_Prescriptions_and_enters_mg_from_to_with_instructions(String drug, int mgNum, String start, String end, String instrs) throws Throwable {
        WebElement prescriptionsLink = browser.findElement(By.linkText("Prescriptions"));
        prescriptionsLink.click();
        
        Select selectDrug = new Select(browser.findElement(By.id("medID")));
        selectDrug.selectByVisibleText(drug);
        
        WebElement mg = browser.findElement(By.id("dosage"));
        mg.sendKeys(Integer.toString(mgNum));
        
        WebElement startDate = browser.findElement(By.id("startDate"));
        startDate.clear();
        startDate.sendKeys(start);
        
        WebElement endDate = browser.findElement(By.id("endDate"));
        endDate.clear();
        endDate.sendKeys(end);
        
        WebElement instructions = browser.findElement(By.id("instructions"));
        instructions.clear();
        instructions.sendKeys(instrs);
    }

    @When("^HCP clicks Add Prescription$")
    public void hcp_clicks_Add_Prescription() throws Throwable {
        WebElement addPrescription = browser.findElement(By.id("addprescription"));
        addPrescription.click();
    }
}
