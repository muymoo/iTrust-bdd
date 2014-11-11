package edu.ncsu.csc.itrust.acceptance.steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.When;

public class PatientHomeSteps {
	private final WebDriver browser;

	public PatientHomeSteps(SharedDriver browser) {
		this.browser = browser;
	}

	@When("^Patient clicks the \"(.*?)\" link$")
	public void patient_clicks_My_Providers_link(String link) throws Throwable {
    	List<WebElement> menus = browser.findElements(By.cssSelector(
    			".iTrustMenuContents div.panel h2"));
    	menus.get(1).click(); // click edit menu
    	
        WebElement addPha = browser.findElement(By.linkText(link));
        addPha.click();
    }
}
