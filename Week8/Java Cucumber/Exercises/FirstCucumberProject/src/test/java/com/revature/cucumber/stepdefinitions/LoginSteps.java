package com.revature.cucumber.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.After;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;

public class LoginSteps {

    private WebDriver driver;
    private static final String BASE_URL = "https://the-internet.herokuapp.com";
    private WebDriverWait wait;

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(BASE_URL + "/login");
    }

    @When("the user enters username {string}")
    public void theUserEntersUsername(String username) {
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(username);
    }

    @When("the user enters password {string}")
    public void theUserEntersPassword(String password) {
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);
    }

    @When("the user clicks the login button")
    public void theUserClicksTheLoginButton() {
        WebElement loginButton = driver.findElement(By.className("radius"));
        loginButton.click();
    }

    @Then("the user should be redirected to the secure area")
    public void theUserShouldBeRedirectedToTheSecureArea() {
        wait.until(ExpectedConditions.urlContains("/secure"));
        assertTrue(driver.getCurrentUrl().contains("/secure"),
                "User was not redirected to secure area");
    }

    @Then("the user should see a success message containing {string}")
    public void theUserShouldSeeSuccessMessageContaining(String expectedMessage) {
        WebElement actualMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("flash-messages")));
        assertTrue(actualMessage.getText().contains(expectedMessage),
                "Actual message does not contain expected text");
    }

    @Then("the user should remain on the login page")
    public void theUserShouldRemainOnTheLoginPage() {
        assertTrue(driver.getCurrentUrl().contains("/login"),
                "User did not remain on the login page");
    }

    @Then("the user should see an error message containing {string}")
    public void theUserShouldSeeErrorMessageContaining(String expectedMessage) {
        WebElement actualMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("flash-messages")));
        assertTrue(actualMessage.getText().contains(expectedMessage),
                "Actual error message does not contain expected text");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}