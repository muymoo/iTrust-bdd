package edu.ncsu.csc.itrust.acceptance.steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.When;

public class MainMenuSteps {
	private final WebDriver browser;

	public MainMenuSteps(SharedDriver browser) {
		this.browser = browser;
	}
	
    @When("^(.*?) clicks the \"(.*?)\" link under the \"(.*?)\" menu subheading$")
    public void clicksMenuItem(String person, String link, String subheading)
            throws Throwable
    {
    	List<WebElement> menus = browser.findElements(By.cssSelector(
    			".iTrustMenuContents div.panel h2"));
    	for(WebElement elt : menus) {
    		if(elt.getText().equals(subheading)) {
    			elt.click();
    			break;
    		}
    	}
    	
        WebElement actualLink = browser.findElement(By.linkText(link));
        actualLink.click();
    }
}
