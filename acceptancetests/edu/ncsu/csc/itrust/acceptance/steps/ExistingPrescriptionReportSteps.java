package edu.ncsu.csc.itrust.acceptance.steps;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Then;

public class ExistingPrescriptionReportSteps {

    private final WebDriver browser;

    public ExistingPrescriptionReportSteps(SharedDriver browser)
    {
        this.browser = browser;
    }
    
	@Then("^the prescription table is displayed with (\\d+) rows:$")
	public void the_prescription_table_is_displayed_with_rows(int num, List<String> data) throws Throwable {
		
		List<WebElement> rows = browser.findElements(By.cssSelector("#iTrustContent table tr"));
		List<String> values = new ArrayList<String>();
		int rowNum = 0;
		for(WebElement row : rows) {
			if(rowNum > 1) {
				List<WebElement> elts = row.findElements(By.tagName("td"));
				values.add(elts.get(1).getText());
			}
			rowNum++;
		}
	    Assert.assertEquals(values, data);
	}
}
