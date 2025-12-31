package com.revature.playwright.tests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class NavigationTest {

    static Playwright playwright;
    static Browser browser;
    BrowserContext context;
    Page page;

    @BeforeAll
    static void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
    }

    @AfterAll
    static void teardown() {
        browser.close();
        playwright.close();
    }

    @BeforeEach
    void createPage() {
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    void closePage() {
        context.close();
    }

    @Test
    void testBackForwardNavigation() {
        page.navigate("https://the-internet.herokuapp.com/");
        String homeUrl = page.url();

        page.getByRole(AriaRole.LINK,
                        new Page.GetByRoleOptions().setName("Form Authentication"))
                .click();

        assertThat(page).hasURL("https://the-internet.herokuapp.com/login");

        page.goBack();
        assertThat(page).hasURL(homeUrl);

        page.goForward();
        assertThat(page).hasURL("https://the-internet.herokuapp.com/login");
    }

    @Test
    void testNewTab() {
        page.navigate("https://the-internet.herokuapp.com/windows");

        Page popup = page.waitForPopup(() ->
                page.getByRole(AriaRole.LINK,
                                new Page.GetByRoleOptions().setName("Click Here"))
                        .click()
        );

        assertThat(popup).hasTitle("New Window");
        assertThat(popup.getByRole(AriaRole.HEADING,
                new Page.GetByRoleOptions().setName("New Window")))
                .isVisible();

        popup.close();
    }

    @Test
    void testMultipleTabs() {
        page.navigate("https://the-internet.herokuapp.com/");

        Page page2 = context.newPage();
        page2.navigate("https://the-internet.herokuapp.com/login");

        assertThat(page).hasTitle("The Internet");
        assertThat(page2).hasURL("https://the-internet.herokuapp.com/login");

        page2.close();
    }

    @Test
    void testWaitForNavigation() {
        page.navigate("https://the-internet.herokuapp.com/login");

        page.fill("#username", "tomsmith");
        page.fill("#password", "SuperSecretPassword!");

        page.waitForNavigation(() ->
                page.getByRole(AriaRole.BUTTON,
                                new Page.GetByRoleOptions().setName("Login"))
                        .click()
        );

        assertThat(page).hasURL("**/secure");
        assertThat(page.locator("#flash"))
                .containsText("secure area");
    }

    @Test
    void testCaptureScreenshot() {
        page.navigate("https://the-internet.herokuapp.com/");

        // Full page screenshot
        page.screenshot(new Page.ScreenshotOptions()
                .setPath(java.nio.file.Paths.get("screenshots/homepage.png"))
                .setFullPage(true));

        // Element screenshot
        Locator heading = page.locator("h1");
        heading.screenshot(new Locator.ScreenshotOptions()
                .setPath(java.nio.file.Paths.get("screenshots/heading.png")));

        // Verify files exist
        java.io.File fullPage = new java.io.File("screenshots/homepage.png");
        java.io.File element = new java.io.File("screenshots/heading.png");

        Assertions.assertTrue(fullPage.exists(), "Full page screenshot should exist");
        Assertions.assertTrue(element.exists(), "Element screenshot should exist");
    }

}
