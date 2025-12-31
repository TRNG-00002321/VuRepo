package com.revature.pw;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

@DisplayName("Advanced Tracing")
public class TestPW05_AdvanceTracing {

    @Test
    @DisplayName("Login and Logout with Playwright Tracing")
    void loginLogoutTracing() {

        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch();
            BrowserContext context = browser.newContext();

            // Start tracing with metadata
            context.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(true)
                    .setTitle("Login Flow Test")
            );
            System.out.println("✓ Tracing started");

            Page page = context.newPage();

            // -------- Scenario 1: Login --------
            page.navigate("https://the-internet.herokuapp.com/");
            context.tracing().startChunk();

            page.locator("a:has-text('Form Authentication')").click();
            page.locator("#username").fill("tomsmith");
            page.locator("#password").fill("SuperSecretPassword!");
            page.locator("button[type='submit']").click();

            context.tracing().stopChunk(new Tracing.StopChunkOptions()
                    .setPath(Paths.get("target/trace-login.zip"))
            );
            System.out.println("✓ Login trace saved");

            // -------- Scenario 2: Logout --------
            context.tracing().startChunk();

            page.locator("a[href='/logout']").click();
            page.waitForURL("**/login");

            context.tracing().stopChunk(new Tracing.StopChunkOptions()
                    .setPath(Paths.get("target/trace-logout.zip"))
            );
            System.out.println("✓ Logout trace saved");

            // -------- Cleanup --------
            context.tracing().stop();
            context.close();
            browser.close();
        }
    }
}
