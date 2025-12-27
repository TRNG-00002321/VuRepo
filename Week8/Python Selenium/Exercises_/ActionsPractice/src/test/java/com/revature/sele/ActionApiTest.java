package com.revature.sele;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

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

    @Test
    @DisplayName("Double-click action")
    void testDoubleClick() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        WebElement addButton = driver.findElement(By.cssSelector("button[onclick='addElement()']"));

        actions.doubleClick(addButton).perform();

        List<WebElement> deleteButtons = driver.findElements(By.className("added-manually"));

        assertEquals(2, deleteButtons.size());
    }

    @Test
    @DisplayName("Context menu (right-click)")
    void testContextClick(){
        driver.get("https://the-internet.herokuapp.com/context_menu");

        WebElement hotSpot = driver.findElement(By.id("hot-spot"));

        actions.contextClick(hotSpot).perform();

        String alertText = driver.switchTo().alert().getText();
        assertTrue(alertText.contains("context"));
        driver.switchTo().alert().accept();
    }

    @Test
    @DisplayName("Click at specific coordinates")
    void testClickAtOffset(){
        driver.get("https://the-internet.herokuapp.com/");

        WebElement heading = driver.findElement(By.tagName("h1"));

        actions.moveToElement(heading,10,10).click().perform();
    }

    @Test
    @DisplayName("Keyboard modifier keys")
    void testKeyboardModifiers(){
        driver.get("https://the-internet.herokuapp.com/key_presses");

        WebElement input = driver.findElement(By.id("target"));

        actions.click(input).sendKeys("f").perform();

        WebElement result = driver.findElement(By.id("result"));
        assertTrue(result.getText().contains("F"));

        actions.keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .perform();

        assertTrue(result.getText().contains("A"));
    }

    @Test
    @DisplayName("Ctrl+A, Ctrl+C, Ctrl+V sequence")
    void testCopyPaste(){
        driver.get("https://the-internet.herokuapp.com/login");
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));

        username.sendKeys("testtext");

        actions.click(username).keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .perform();

        actions.keyDown(Keys.CONTROL)
                .sendKeys("c")
                .keyUp(Keys.CONTROL)
                .perform();

        actions.click(password)
                .keyDown(Keys.CONTROL)
                .sendKeys("v")
                .keyUp(Keys.CONTROL)
                .perform();
    }

    @Test
    @DisplayName("Complex action chain")
    void testComplexActionChain(){
        driver.get("https://the-internet.herokuapp.com/login");

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.cssSelector("button[type='submit']"));

        actions.click(username)
                .sendKeys("tomsmith")
                .sendKeys(Keys.TAB)
                .sendKeys("SuperSecretPassword!")
                .click(login)
                .perform();

        assertTrue(driver.getCurrentUrl().contains("secure"));
    }
}

