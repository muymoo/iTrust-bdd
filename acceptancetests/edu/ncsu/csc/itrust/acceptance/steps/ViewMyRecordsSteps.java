package edu.ncsu.csc.itrust.acceptance.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ViewMyRecordsSteps {
	private final WebDriver browser;
	
	public ViewMyRecordsSteps(SharedDriver browser) {
		this.browser = browser;
	}
	
	private WebElement getFamilyHistoryTable() {
	    List<WebElement> tables = browser.findElements(By.cssSelector("table"));
	    for(WebElement table : tables) {
	    	WebElement title = table.findElement(By.tagName("th"));
	    	if(title.getText().equals("Family Medical History")) {
	    		return table;
	    	}
	    }
	    return null;
	}

	@Then("^the Family Medical History table is displayed with (\\d+) rows\\.$")
	public void the_Family_Medical_History_table_is_displayed_with_rows(int numRows) throws Throwable {
		WebElement familyHistoryTable = getFamilyHistoryTable();
	    Assert.assertNotNull(familyHistoryTable);
	    
	    List<WebElement> rows = familyHistoryTable.findElements(By.tagName("tr"));
	    Assert.assertEquals(rows.size(), numRows+2);
	}

	@Then("^FMH Row (\\d+) should be (.+)\\. (.+)\\.(.*)$")
	public void rowShouldBe(int rowNum, String name, String relationship, String diabetesYes) throws Throwable {
		WebElement familyHistoryTable = getFamilyHistoryTable();	    
	    List<WebElement> rows = familyHistoryTable.findElements(By.tagName("tr"));

	    WebElement row = rows.get(rowNum + 1); //ignore subheading too
	    List<WebElement> data = row.findElements(By.tagName("td"));
	    Assert.assertEquals(data.get(0).getText(), name);
	    Assert.assertEquals(data.get(1).getText(), relationship);
	    Assert.assertEquals(data.get(2).getText(), "");
	    Assert.assertEquals(data.get(3).getText(), "");
	    if(diabetesYes.equals("Diabetes")) {
		    Assert.assertEquals(data.get(4).getText(), "x");
	    }
	    else {
		    Assert.assertEquals(data.get(4).getText(), "");
	    }
	    Assert.assertEquals(data.get(5).getText(), "");
	    Assert.assertEquals(data.get(6).getText(), "");
	    Assert.assertEquals(data.get(7).getText(), "");
	}
}
