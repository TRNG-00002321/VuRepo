package com.revature.sel.pom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("POM Implementation")
public class TestPomImpl {
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
        driver.get(BASE_URL+"login");
    }

    @AfterEach
    public void tearDown(){
        if(driver != null){
            // close all windows
            driver.quit();
        }
    }

    @DisplayName("Test Login Valid")
    @Test
    void testLoginValid(){
        LoginPage loginPage = new LoginPage(driver);
        // SecurePage securePage = loginPage.enterUsername("tomsmith").enterPassword("SuperSecretPassword!").clickLogin();
        SecurePage securePage = loginPage.loginAs("tomsmith", "SuperSecretPassword!");

        assertTrue(securePage.getFlashMessage().contains("logged"));

    }
}
