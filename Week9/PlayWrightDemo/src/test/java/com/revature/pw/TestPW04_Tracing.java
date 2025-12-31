package com.revature.pw;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

@DisplayName("Playwright Tracing Demo")
public class TestPW04_Tracing {
    @DisplayName("Basic Tracing Demo")
    @Test
    public void testBaiscDemo(){
        try(Playwright playwright = Playwright.create()){
            Browser browser = playwright.chromium().launch();
            BrowserContext context = browser.newContext();

            // start tracing before you perform ant test / task
            context.tracing()
                    .start(
                            new Tracing.StartOptions()
                                    .setScreenshots(true)
                                    .setSnapshots(true)
                                    .setSources(true)
                    );
            System.out.println("Tracing Started");
            // Perform your test

            Page page = context.newPage();
            page.navigate("https://the-internet.herokuapp.com/login");
            page.locator("#username").fill("tomsmith");
            page.locator("#password").fill("SuperSecretPassword!");
            page.locator("button[type='submit']").click();
            page.waitForURL("**/secure");
            context.tracing().stop(new Tracing
                    .StopOptions().setPath(Paths.get("target/traces/login-trace.zip")));
            context.close();
            browser.close();
        }
    }
}
