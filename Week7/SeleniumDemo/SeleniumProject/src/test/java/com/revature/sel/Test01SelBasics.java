package com.revature.sel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Basic Selenium Test")
public class Test01SelBasics {
    private WebDriver driver;


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

    @Test
    public void testBasic(){

        // Navigate to the website
        driver.get("https://www.selenium.dev/");

        // Get the page title
        String title = driver.getTitle();
        System.out.println("Title: " + title);
        assertTrue(title.contains("Selenium"));
    }

    @Test
    public void testDocumentation(){
        driver.get("https://www.selenium.dev/documentation/");
        System.out.println("Title: " + driver.getTitle());
        assertTrue(driver.getTitle().contains("The Selenium Browser Automation Project | Selenium"));
    }
}
