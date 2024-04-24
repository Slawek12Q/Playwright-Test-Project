package org.example.module_1;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.example.BaseTest;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

class AllBrowserTest extends BaseTest {

    @Test
    void openSupportedBrowserChromium() {
        page.navigate("https://www.whatismybrowser.com/");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Consent")).click();
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot/chromium.png")));
    }

    @Test
    void openSupportedBrowserFirefox() {
        page.navigate("https://www.whatismybrowser.com/");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Consent")).click();
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot/firefox.png")));
    }

    @Test
    void openSupportedBrowserWebkit() {
        page.navigate("https://www.whatismybrowser.com/");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Consent")).click();
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot/webkit.png")));
    }

}
