package org.example.module_4;

import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.WaitUntilState;
import org.example.common.BaseTest;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class StorageUsageTest extends BaseTest {

    Playwright playwright = Playwright.create();
    Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
    @Test
    public void saveStorageStateAfterLogin() {

        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
        page.navigate("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account", new Page.NavigateOptions().setWaitUntil(WaitUntilState.NETWORKIDLE));

        page.locator("#email").fill("demouser@akademiaqa.pl");
        page.locator("#passwd").fill("123456");
        page.locator("#SubmitLogin").click();

        browserContext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("storage/storage_state.json")));
    }

    @Test
    public void loadStorageStateAfterLogin() {
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("storage/storage_state.json")));
        Page page = browserContext.newPage();
        page.navigate("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account", new Page.NavigateOptions().setWaitUntil(WaitUntilState.NETWORKIDLE));

        PlaywrightAssertions.assertThat(page.locator("//div/h1[@class='page-heading']")).isVisible();
        page.pause();
    }
}
