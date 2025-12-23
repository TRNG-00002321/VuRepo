package com.revature.sele;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.*;

class ActionsApiTest extends BaseTest {

    private Actions actions;

    @BeforeEach
    void setupActions() {
        actions = new Actions(driver);
    }

    @Test
    @DisplayName("Mouse hover reveals hidden element")
    void testMouseHover(){
        driver.get("https://the-internet.herokuapp.com/hovers");

        WebElement figure = driver.findElement(By.cssSelector(".figure"));

        actions.moveToElement(figure).perform();

        WebElement caption = figure.findElement(By.cssSelector(".figcaption"));
        assertTrue(caption.isDisplayed(), "Caption should be visible on hover");

        String captionText = caption.getText();
        assertTrue(captionText.contains("user1"), "Caption should contain user info");
    }

    @DisplayName("Hover over multiple elements")
    @Test
    void testMultipleHovers(){
        driver.get("https://the-internet.herokuapp.com/hovers");

        java.util.List<WebElement> figures = driver.findElements(By.cssSelector(".figure"));
        for (int i = 0; i < figures.size(); i++) {
            WebElement figure = figures.get(i);
            actions.moveToElement(figure).perform();

            WebElement caption = figure.findElement(By.cssSelector(".figcaption"));
            assertTrue(caption.isDisplayed(), "Caption " + i + " should be visible on hover");

            // Move away
            actions.moveToElement(driver.findElement(By.tagName("h3"))).perform();
        }
    }

    @Test
    @DisplayName("Hover and click link")
    void testHoverAndClick() {
        driver.get("https://the-internet.herokuapp.com/hovers");

        WebElement figure = driver.findElement(By.cssSelector(".figure"));
        actions.moveToElement(figure).perform();

        WebElement profileLink = driver.findElement(By.linkText("View profile"));
        actions.moveToElement(profileLink).click().perform();
        WebElement text = driver.findElement(By.tagName("h1"));
        assertEquals("Not Found", text.getText());
    }

    @Test
    @DisplayName("Basic drag and drop")
    void testDragAndDrop() {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        WebElement source = driver.findElement(By.id("column-a"));
        WebElement target = driver.findElement(By.id("column-b"));

        String sourceInitialText = source.getText();
        String targetInitialText = target.getText();

        assertEquals("A", sourceInitialText);
        assertEquals("B", targetInitialText);

        actions.dragAndDrop(source, target).perform();
    }

    @Test
    @DisplayName("Drag and drop with click-hold-move-release")
    void testDragAndDropManual() {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        WebElement source = driver.findElement(By.id("column-a"));
        WebElement target = driver.findElement(By.id("column-b"));

        actions.clickAndHold(source).moveToElement(target).release().perform();
    }

    

}

