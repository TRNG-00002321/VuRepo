package com.revature.sel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class TestHandlingWindows {
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

    @DisplayName("Test Multiple Windows")
    @Test
    void testMultipleWindows(){
        driver.get(BASE_URL + "windows");

        // Store original window handle
        String originalWindow =  driver.getWindowHandle();

        // Click link that opens new window
        driver.findElement(By.linkText("Click Here")).click();

        // Wait for new window
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        // Get all window handles
        Set<String> windowHandles = driver.getWindowHandles();

        // Switch to new window
        for (String handle : windowHandles) {
            if(!handle.equals(originalWindow)){
                driver.switchTo().window(handle);
                break;
            }
        }

        assertTrue(driver.getCurrentUrl().contains("New Window"));

        driver.close();

        driver.switchTo().window(originalWindow);

        assertTrue(driver.getCurrentUrl().contains("new"));
    }

}
