package edu.ncsu.csc.itrust.acceptance.steps;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddPublicHealthAgent 
{
    private final WebDriver browser;

    public AddPublicHealthAgent(SharedDriver browser)
    {
        this.browser = browser;
    }

    @Given("^Admin 9000000001 has authenticated successfully\\.$")
    public void admin_has_authenticated_successfully()
            throws Throwable
    {
        browser.findElement(By.name("j_username")).sendKeys(String.valueOf("9000000001"));
        browser.findElement(By.name("j_password")).sendKeys(String.valueOf("pw"));
        browser.findElement(By.name("j_password")).submit();
        assertEquals("Welcome, Shape Shifter", browser.findElement(By.className("welcome")).getText());
    }

    @When("^Admin clicks the \"Add PHA\" link under the \"Add\" menu subheading\\.$")
    public void admin_clicks_the_Add_PHA_link_under_the_Add_menu_subheading()
            throws Throwable
    {
        WebElement addMenu = browser.findElement(By.cssSelector(
        		".iTrustMenuContents div[anim-type=\"#addMenu\"]"));
        addMenu.click();
        
        WebElement addPha = browser.findElement(By.linkText("Add PHA"));
        addPha.click();
    }

    @When("^Admin enters: first name: Tim last name: Agent email: pha@timagent\\.com$")
    public void admin_enters_first_name_Tim_last_name_Agent_email_pha_timagent_com()
            throws Throwable
    {
        WebElement firstNameInput = browser.findElement(By.cssSelector(
        		"#iTrustContent input[name=\"firstName\"]"));
        firstNameInput.sendKeys("Tim");
        
        WebElement lastNameInput = browser.findElement(By.cssSelector(
        		"#iTrustContent input[name=\"lastName\"]"));
        lastNameInput.sendKeys("Agent");
        
        WebElement emailInput = browser.findElement(By.cssSelector(
        		"#iTrustContent input[name=\"email\"]"));
        emailInput.sendKeys("pha@timagent.com");
        
        WebElement submitButton = browser.findElement(By.cssSelector(
        		"#iTrustContent input[value=\"Add personnel\"]"));
        submitButton.click();
    }

    @When("^Admin clicks the \"Continue to PHA information\" link\\.$")
    public void admin_clicks_the_Continue_to_PHA_information_link()
            throws Throwable
    {
    	WebElement continueToPhaLink = browser.findElement(By.linkText(
    			"Continue to personnel information."));
    	continueToPhaLink.click();
    }

    @When("^Admin enters: Address: (\\d+) Oak Hills Drive City: Capitol City State: North Carolina Zip: (\\d+)-(\\d+) Phone: (\\d+)-(\\d+)-(\\d+)$")
    public void admin_enters_Address_Oak_Hills_Drive_City_Capitol_City_State_North_Carolina_Zip_Phone(int arg1,
            int arg2, int arg3, int arg4, int arg5, int arg6)
            throws Throwable
    {
        WebElement address1 = browser.findElement(By.cssSelector(
        		"input [name=\"streetAddress1\"]"));
        address1.sendKeys(arg1 + " Oak Hills Drive");
        
        WebElement city = browser.findElement(By.cssSelector(
        		"input [name=\"city\"]"));
        city.sendKeys("Capitol City");
        
        Select state = (Select) browser.findElement(By.cssSelector(
        		"input [name=\"state\"]"));
        state.selectByVisibleText("North Carolina");
        
        WebElement zip = browser.findElement(By.cssSelector(
        		"input [name=\"zip\"]"));
        zip.sendKeys(arg2 + "-" + arg3); 

        WebElement phone = browser.findElement(By.cssSelector(
        		"input [name=\"phone\"]"));
        phone.sendKeys(arg4 + "-" + arg5 + "-" + arg6);
    }

    @When("^Admin (\\d+) clicks the \"Edit PHA Record\" button\\.$")
    public void admin_clicks_the_Edit_PHA_Record_button(int arg1)
            throws Throwable
    {
        WebElement submit = browser.findElement(By.cssSelector(
        		"input [value=\"Edit Personnel Record\"]"));
        submit.click();
    }

    @Then("^A new Public Health Agent is added with the following information: First Name: Tim Last Name: Agent Address: (\\d+) Oak Hills DriveCity: Capitol City State: North Carolina Zip: (\\d+)-(\\d+) Phone: (\\d+)-(\\d+)-(\\d+) Email: pha@timagent\\.com$")
    public void a_new_Public_Health_Agent_is_added_with_the_following_information_First_Name_Tim_Last_Name_Agent_Address_Oak_Hills_DriveCity_Capitol_City_State_North_Carolina_Zip_Phone_Email_pha_timagent_com(
            int arg1, int arg2, int arg3, int arg4, int arg5, int arg6)
            throws Throwable
    {
        WebElement successMessage = browser.findElement(By.cssSelector(
        		"#iTrustContent span.iTrustMessage"));
        assertEquals(successMessage.getText(), "Information Successfully Updated");
    }

}
