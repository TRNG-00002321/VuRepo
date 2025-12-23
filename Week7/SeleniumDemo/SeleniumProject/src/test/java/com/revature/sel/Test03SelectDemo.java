package com.revature.sel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.*;

public class Test03SelectDemo {
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

    @Test
    @DisplayName("Testing Select List")
    public void testSelectDemo(){
        driver.get(BASE_URL+"dropdown");

        WebElement dropDownElement = driver.findElement(By.id("dropdown"));

        Select dropDown = new Select(dropDownElement);

        // dropDown.selectVisibleText("Option1");
        dropDown.selectByValue("1");
        WebElement selectedOption = dropDown.getFirstSelectedOption();

        // assertEquals("Option 1", selectedOption.getText());
        assertEquals("1", selectedOption.getAttribute("value"));

    }

    Actions action = new Actions(driver);
    @Test
    @DisplayName("Action API in Action...")
    public void actionAPIDemo() throws InterruptedException {
        driver.get(BASE_URL+"login");

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.className("radius"));

        action.click(username)
                .sendKeys("tomsmith")
                .sendKeys(Keys.TAB)
                .sendKeys("SuperSecretPassword!")
                .click(loginButton)
                .perform();

        Thread.sleep(5000);
    }
}
