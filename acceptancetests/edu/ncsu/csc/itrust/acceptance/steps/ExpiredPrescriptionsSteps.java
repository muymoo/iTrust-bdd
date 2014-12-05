package edu.ncsu.csc.itrust.acceptance.steps;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Then;

public class ExpiredPrescriptionsSteps
{
    private final WebDriver browser;

    public ExpiredPrescriptionsSteps(SharedDriver browser)
    {
        this.browser = browser;
    }

    @Then("^A report should appear with title \"(.*?)\"$")
    public void a_report_should_appear_with_title(String title)
            throws Throwable
    {
        String tableTitle = browser.findElement(By.xpath("//*[@id=\"iTrustContent\"]/div/table/tbody/tr[1]/th"))
                .getText();
        assertEquals(title, tableTitle);
    }

    @Then("^The following information is displayed:$")
    public void the_following_information_is_displayed(List<List<String>> input)
            throws Throwable
    {
        List<WebElement> rows = browser.findElements(By.cssSelector("table.fTable tr"));

        // Start at index 2 so we skip title row and headers
        for (int i = 2; i < rows.size(); i++)
        {
            List<WebElement> rowOfCells = rows.get(i).findElements(By.tagName("td"));
            List<String> rowOfInput = input.get(i - 2);

            assertEquals(rowOfInput.get(0), rowOfCells.get(0).getText());
            assertEquals(rowOfInput.get(1), rowOfCells.get(1).getText());
            assertEquals(rowOfInput.get(2), rowOfCells.get(2).getText());
            assertEquals(rowOfInput.get(3), rowOfCells.get(3).getText());
        }
    }

    @Then("^The following HCP infomation should be displayed:$")
    public void the_following_should_be_displayed(Map<String, String> hcpInfo)
            throws Throwable
    {
        List<WebElement> rows = browser.findElements(By.cssSelector("table.fTable tr"));

        // Start at index 1 so we skip title row
        for (int i = 1; i < rows.size(); i++)
        {
            List<WebElement> rowOfCells = rows.get(i).findElements(By.tagName("td"));
            assertEquals(hcpInfo.get(rowOfCells.get(0).getText()), rowOfCells.get(1).getText());
        }
    }
}
