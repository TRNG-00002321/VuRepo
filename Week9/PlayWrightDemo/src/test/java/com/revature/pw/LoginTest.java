package com.revature.pw;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTest extends BaseTest {
    @BeforeEach
    void navigateToLogin() {
        page.navigate("https://the-internet.herokuapp.com/login");
    }

    @Test
    @DisplayName("Successful login with valid credentials")
    void shouldLoginSuccessfully() {
        page.locator("#username").fill("tomsmith");
        page.locator("#password").fill("SuperSecretPassword!");

        page.locator("button[type='submit']").click();

        assertThat(page.locator("#flash"))
                .containsText("You logged into a secure area!");
        assertThat(page).hasURL("https://the-internet.herokuapp.com/secure");
    }

    @Test
    @DisplayName("Failed login shows error message")
    void shouldShowErrorForInvalidCredentials() {
        page.locator("#username").fill("invalid");
        page.locator("#password").fill("wrongpassword");

        page.locator("button[type='submit']").click();

        assertThat(page.locator("#flash"))
                .containsText("Your username is invalid!");
        assertThat(page).hasURL("https://the-internet.herokuapp.com/login");
    }
}
