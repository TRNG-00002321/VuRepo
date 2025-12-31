package com.revature.pw;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@DisplayName("Playwright Element Locate and Interaction")
public class TestPW02_Interactions extends BaseTest{
    @DisplayName("Playwright interaction")
    @Test
    public void demoWaits(){
        navigateTo("https://the-internet.herokuapp.com/dynamic_loading/1");
        page.locator("#start button").click();
        String result = page.locator("#finish h4").textContent();
        System.out.println("Result: " + result);
    }

    @DisplayName("Playwright locators")
    @Test
    public void demoLocator(){
        navigateTo("https://the-internet.herokuapp.com/login");
        Locator locator = page.locator("#username");
        Locator byText = page.locator("text=login");
        Locator byRole = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"));
        Locator byPlaceHolder = page.getByPlaceholder("Username");
        Locator byLabel = page.getByLabel("Username");
    }

    @DisplayName("Playwright interactions")
    @Test
    public void demoInteractions(){
        page.locator("#username").fill("tomsmith");
        page.locator("#password").fill("SuperSecretPassword!");
        page.locator("button[type='submit']").click();
        assertThat(page.locator("#flash")).containsText("You logged into a secure area!");
    }
}
