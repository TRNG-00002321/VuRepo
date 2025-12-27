package com.revature.cucumber.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.jupiter.api.Assertions.*;


public class DataDrivenSteps {
    private static WebDriver driver;

    @When("the user enters email {string}")
    public void enterEmail(String email) {
        // TODO: Implement
        // Handle empty string case
        if (email != null && !email.isEmpty()) {
            driver.findElement(By.id("email")).sendKeys(email);
        }
    }

    @Then("the email validation result should be {string}")
    public void validateEmailResult(String expectedValid) {
        // TODO: Implement
        boolean isValid = expectedValid.equalsIgnoreCase("yes");
        // Assert based on expected validation
        boolean actualValid =
                driver.findElements(By.id("email-error")).isEmpty();

        if (isValid) {
            assertTrue(actualValid, "Expected email to be valid");
        } else {
            assertFalse(actualValid, "Expected email to be invalid");
        }
    }

    @Given("the user opens {string} browser")
    public void openBrowser(String browserName) {
        // TODO: Implement browser factory
        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            // Add more browsers
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
    }

    @Given("the viewport is set to {string} x {string}")
    public void setViewport(String width, String height) {
        // TODO: Implement viewport setting
        driver.manage().window().setSize(
                new Dimension(Integer.parseInt(width), Integer.parseInt(height))
        );
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}