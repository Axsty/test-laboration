package se.iths.axel.testlaboration.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlaywrightTest {

    @Test
    public void playwrightTitleTest() {
        try (Playwright playwright = Playwright.create();
             Browser browser = playwright.firefox().launch(
                     new BrowserType.LaunchOptions().setHeadless(true)
             )) {

            Page page = browser.newPage();
            page.navigate("http://localhost:8080/balance");
            assertEquals("ATM", page.title());
        }
    }

    @Test
    public void playwrightBalanceTest() {
        try (Playwright playwright = Playwright.create();
             Browser browser = playwright.firefox().launch(
                     new BrowserType.LaunchOptions().setHeadless(true)
             )) {

            Page page = browser.newPage();
            page.navigate("http://localhost:8080/balance");
            assertTrue(page.isVisible("text=Balance: 0kr"));
        }
    }
}
