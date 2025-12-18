package com.revature.sel;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class CheckElement {
    private WebDriver driver;
    private String BASE_URL = "https://the-internet.herokuapp.com/";

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown(){
        if(driver != null){
            // close all windows
            driver.quit();
        }
    }

    @Test
    @DisplayName("Complete login form interaction")
    void completeForm_loginFlow() {

        driver.get(BASE_URL + "/login");

        // Find elements
        WebElement userName = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.className("radius"));

        // Verify input values
        // Verify elements are displayed and enabled
        assertTrue(userName.isDisplayed());
        assertTrue(password.isDisplayed());
        assertTrue(loginButton.isDisplayed());


        // Clear and enter credentials
        userName.clear();
        userName.sendKeys("tomsmith");
        password.clear();
        password.sendKeys("SuperSecretPassword!");

        // Click login
        loginButton.click();

        // Verify success (check for success message or URL)
        WebElement verify = driver.findElement(By.id("flash"));
        System.out.println(verify.getText());
        assertTrue(verify.isDisplayed());
        assertTrue(verify.getText().contains("You logged into a secure area!"));
    }
}
