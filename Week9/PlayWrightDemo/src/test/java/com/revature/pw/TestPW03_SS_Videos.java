package com.revature.pw;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

@DisplayName("PW Screenshot and Video Demo")
public class TestPW03_SS_Videos {
    @DisplayName("Screenshot Demo")
    @Test
    public void testScreenshot(){
        try(Playwright pw = Playwright.create()){
            Browser browser = pw.chromium().launch();
            Page page = browser.newPage();
            page.navigate("http://playwright.dev/java/");
//            page.screenshot(new Page
//                    .ScreenshotOptions()
//                    .setPath(Paths.get("target/screenshots/basic.png")));
//                    // .setFullPage(true);

            page.locator("text=Getting Started")
                    .screenshot(new Locator
                    .ScreenshotOptions()
                    .setPath(Paths
                    .get("target/screenshots/basic1.png")));
        }
    }

    @DisplayName("PW Video Recording")
    @Test
    public void testVideo(){
        try(Playwright playwright = Playwright.create()){
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(true)
            );
            BrowserContext context = browser.newContext(
                    new Browser.NewContextOptions()
                            .setRecordVideoDir(Paths.get("target/videos"))
                            .setRecordVideoSize(1280, 720)
            );

            Page page = context.newPage();
            System.out.println("Recording Started");
            page.navigate("https://the-internet.herokuapp.com/login");
            page.locator("#username").fill("tomsmith");
            page.locator("#password").fill("SuperSecretPassword!");
            page.locator("button[type='submit']").click();
            page.waitForTimeout(5000);
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("target/screenshots/logged_in.png")));
            // Video is saved only after the context is closed
            context.close();
            browser.close();
        }
    }
}
