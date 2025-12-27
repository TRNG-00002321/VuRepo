package com.revature.sele;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

public class FirstSeleniumTest extends BaseTest{

    @Test
    @DisplayName("Navigate to Google and verify title")
    void testNavigateToGoogle() {
        // Navigate to URL
        driver.get("https://www.google.com");

        // Get page title
        String title = driver.getTitle();

        // Verify title
        assertTrue(title.contains("Google"));
    }

    @Test
    @DisplayName("Navigate to Example.com and verify content")
    void testNavigateToExample(){
        // Navigate
        driver.get("https://example.com");

        // Get title and URL
        String title = driver.getTitle();
        String url = driver.getCurrentUrl();

        // Verify content
        assertTrue(title.contains("Example Domain"));
        assertTrue(url.contains("example.com"));

        // Find element and verify text
        WebElement element = driver.findElement(By.tagName("h1"));
        assertEquals("Example Domain", element.getText());
    }

    @Test
    @DisplayName("Navigate to practice site and find elements")
    void testFindElements(){
        // Navigate to a practice site
        driver.get("https://the-internet.herokuapp.com/");

        // Find heading
        WebElement heading = driver.findElement(By.tagName("h1"));
        assertEquals("Welcome to the-internet", heading.getText());

        // Find link by link text
        WebElement formAuthLink = driver.findElement(By.linkText("Form Authentication"));
        assertTrue(formAuthLink.isDisplayed());

        // Get page source
        String source = driver.getPageSource();
        assertTrue(source.contains("Available Examples"));
    }

    @Test
    @DisplayName("Navigate to favorite website")
    void navigateToW3Schools(){
        driver.get("https://www.w3schools.com/");

        WebElement title = driver.findElement(By.tagName("h1"));
        assertEquals("Learn to Code", title.getText());

        WebElement guide = driver.findElement(By.className("learntocodeh4"));
        assertTrue(guide.isDisplayed());
        assertTrue(guide.getText().contains("Not Sure"));
    }

    @Test
    @DisplayName("Add a test that verifies the current URL after navigation")
    void verifyCurrentUrl(){
        driver.get("https://the-internet.herokuapp.com/login");

        // action that causes navigation
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword!");
        loginButton.click();

        // get current URL
        String actualURL = driver.getCurrentUrl();
        assertEquals("https://the-internet.herokuapp.com/secure", actualURL);
    }

    @Test
    @DisplayName("Test link clicking and navigation")
    void testLinkClicking(){
        driver.get("https://the-internet.herokuapp.com/");

        driver.findElement(By.linkText("Checkboxes")).click();

        assertTrue(driver.getCurrentUrl().contains("checkboxes"));

        driver.navigate().back();

        assertTrue(driver.getCurrentUrl().equals("https://the-internet.herokuapp.com/"));
    }

    @Test
    @DisplayName("Test checkbox interaction")
    void testCheckboxes(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        java.util.List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));

        assertEquals(2, checkboxes.size());

        WebElement checkbox1 = checkboxes.get(0);
        WebElement checkbox2 = checkboxes.get(1);

        assertFalse(checkbox1.isSelected());
        assertTrue(checkbox2.isSelected());
        checkbox1.click();
        assertTrue(checkbox1.isSelected());
    }
}


