package se.iths.axel.testlaboration.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PlaywrightTest {

    @LocalServerPort
    private int port;

    @Test
    public void playwrightTitleTest() {
        try (Playwright playwright = Playwright.create();
             Browser browser = playwright.firefox().launch(
                     new BrowserType.LaunchOptions().setHeadless(true)
             )) {

            Page page = browser.newPage();
            page.navigate("http://localhost:" + port + "/balance");
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
            page.navigate("http://localhost:" + port + "/balance");
            assertTrue(page.isVisible("text=Balance: "));
        }
    }

    @Test
    public void playwrightDepositTest() {
        try (Playwright playwright = Playwright.create();
             Browser browser = playwright.firefox().launch(
                     new BrowserType.LaunchOptions().setHeadless(true)
             )) {

            Page page = browser.newPage();
            page.navigate("http://localhost:" + port + "/balance");
            
            page.getByLabel("Deposit Amount:").fill("2000");
            page.getByRole(AriaRole.BUTTON,
                    new Page.GetByRoleOptions().setName("Deposit")).click();
        }
    }

    @Test
    public void playwrightWithdrawTest() {
        try (Playwright playwright = Playwright.create();
             Browser browser = playwright.firefox().launch(
                     new BrowserType.LaunchOptions().setHeadless(true)
             )) {

            Page page = browser.newPage();
            page.navigate("http://localhost:" + port + "/balance");

            page.getByLabel("Withdraw Amount:").fill("500");
            page.getByRole(AriaRole.BUTTON,
                    new Page.GetByRoleOptions().setName("Withdraw")).click();
        }
    }
}
