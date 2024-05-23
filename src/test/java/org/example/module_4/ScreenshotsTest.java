package org.example.module_4;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitUntilState;
import org.example.common.BaseTest;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class ScreenshotsTest extends BaseTest {

    @Test
    public void screenshotTest() {

        page.navigate("https://the-internet.herokuapp.com/", new Page.NavigateOptions().setWaitUntil(WaitUntilState.NETWORKIDLE));
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot/home.png")));
    }

    @Test
    public void screenshotElementTest() {
        page.navigate("https://the-internet.herokuapp.com/login", new Page.NavigateOptions().setWaitUntil(WaitUntilState.NETWORKIDLE));
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
        page.locator("#flash-messages").screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("screenshot/login.png")));
    }
}
