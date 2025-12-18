package com.revature.sel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Finding Elements")
public class Test02FindElements {
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

    @DisplayName("Test By Id")
    @Test
    public void testById(){
        driver.get(BASE_URL+"/login");
        WebElement userName = driver.findElement(By.id("username"));
        WebElement pass = driver.findElement(By.id("password"));

        assertTrue(userName.isDisplayed());
        assertTrue(pass.isDisplayed());
    }

    @DisplayName("Test By Name")
    @Test
    public void testByName(){
        driver.get(BASE_URL+"/login");
        WebElement userName = driver.findElement(By.name("username"));
        WebElement pass = driver.findElement(By.name("password"));
        assertTrue(userName.isDisplayed());
        assertTrue(pass.isDisplayed());
    }

    @DisplayName("Test By Tag Name")
    @Test
    public void testByTagName(){
        driver.get(BASE_URL+"/login");
        List<WebElement> userNames = driver.findElements(By.tagName("label"));
        for(WebElement userName : userNames){
            System.out.println(userName.getText());
            assertTrue(userName.isDisplayed());
        }
    }

    @DisplayName("Test if login text include in button")
    @Test
    public void testIfLoginTextIncludeButton(){
        driver.get(BASE_URL+"/login");
        WebElement loginButton = driver.findElement(By.className("radius"));
        System.out.println(loginButton.getText());
        assertTrue(loginButton.getText().contains("Login"));
    }

    @DisplayName("Find text using path")
    @Test
    public void testFindTextUsingPath(){
        driver.get(BASE_URL);
        WebElement userName = driver.findElement(By.xpath("//h2[text()='Available Examples']"));
        System.out.println(userName.getText());
        assertTrue(userName.isDisplayed());
    }
}
