package com.revature.sel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class Test05Alerts {
    private WebDriver driver;
    private final String BASE_URL = "https://the-internet.herokuapp.com/";

    @BeforeEach
    public void setUp(){
        // Set up your WebDriverManger
        WebDriverManager.chromedriver().setup();
        // Initialize your Webdriver
        driver = new ChromeDriver();
        // Chaining
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown(){
        if(driver != null){
            // close all windows
            driver.quit();
        }
    }

    @DisplayName("Test Alert")
    @Test
    void testSimpleAlert(){
        driver.get(BASE_URL + "javascript_alerts");

        // Use the onclick attribute shown in your screenshot
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

        Alert alert = driver.switchTo().alert();

        String message = alert.getText();
        assertEquals("I am a JS Alert", message);

        alert.accept();

        // The result message is "You successfully clicked an alert" as seen in your screenshot
        String resultText = driver.findElement(By.id("result")).getText();
        assertEquals("You successfully clicked an alert", resultText);
    }

    @DisplayName("Test Handling Prompt")
    @Test
    void testHandlingPrompt(){
        driver.get(BASE_URL + "javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();

        Alert prompt = driver.switchTo().alert();
        assertEquals("I am a JS prompt", prompt.getText());
        prompt.sendKeys("First prompt");
        prompt.accept();
        assertEquals("You entered: First prompt", driver.findElement(By.id("result")).getText());
    }
}
