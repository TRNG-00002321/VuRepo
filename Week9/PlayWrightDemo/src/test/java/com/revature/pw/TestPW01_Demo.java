package com.revature.pw;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@DisplayName("Playwright Demo")
public class TestPW01_Demo {

    @DisplayName("Basic PW Test")
    @Test
    public void basicTest() {

        // Playwright.create() initialize the playwright library
        try(Playwright pw = Playwright.create()){

            // Launch the browser
            Browser browser = pw.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(false) //Default headless = true
                            .setSlowMo(500) // Slow down the visibility
            );
            // Create a new page (tab)
            Page page = browser.newPage();

            // Navigate to a url
            page.navigate("https://playwright.dev/");

            // get and print the page title
            System.out.println("Title: " + page.title());
            System.out.println("Page URL: " + page.url());

            page.locator("text=Get Started").click();

            assertThat(page).hasURL(Pattern.compile(".*intro"));

            System.out.println("Navigate to :: " + page.url());
        }
    }
}
