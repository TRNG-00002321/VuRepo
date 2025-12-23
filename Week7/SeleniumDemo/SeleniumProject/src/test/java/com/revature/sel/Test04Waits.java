package com.revature.sel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class Test04Waits {

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

    @DisplayName("Without Waits")
    @Test
    void withoutWait(){
        driver.get(BASE_URL+"dynamic_loading/1");

        WebElement button = driver.findElement(By.xpath("//button[text()='Start']"));
        button.click();

        WebElement result = driver.findElement(By.id("finish"));
        System.out.println(result.getText());
//        Assertions.assertEquals("Hello World!", result.getText());
    }

    @DisplayName("Test Implicit Wait")
    @Test
    void testImplicitWait(){

        // Set implicit wait for all elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(BASE_URL+"dynamic_loading/1");

        driver.findElement(By.xpath("//button[text()='Start']")).click();

        WebElement result = driver.findElement(By.id(("finish")));
        String text = result.getText();
        System.out.println("Text :: " + text);
        Assertions.assertEquals("Hello World!", text);
    }

    @DisplayName("Explicit Waits")
    @Test
    void testExplicitWait(){
        driver.get(BASE_URL+"dynamic_loading/1");

        WebElement button = driver.findElement(By.xpath("//button[text()='Start']"));
        button.click();

        // Creating an explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement result = wait.until(
                // checking for condition
                ExpectedConditions.visibilityOfElementLocated(By.id("finish"))

        );
        String text = result.getText();
        System.out.println("Text Returned :: " + text);
        Assertions.assertTrue(text.contains("Hello"));
    }

    @DisplayName("Fluent Wait")
    @Test
    void testFluentWait(){
        driver.get(BASE_URL+"dynamic_loading/1");

        WebElement button = driver.findElement(By.xpath("//button[text()='Start']"));
        button.click();

        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500)) // check every 500ms
                .ignoring(NoSuchElementException.class)
                .withMessage("Waiting for result element");

        WebElement result = fluentWait.until(driver->{
            WebElement element = driver.findElement(By.id("finish"));
            return element.isDisplayed() ? element : null;
        });

        String text = result.getText();
        System.out.println("Text Returned :: " + text);
        Assertions.assertTrue(text.contains("Hello"));
    }
}
