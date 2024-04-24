package org.example.module_1;

import com.microsoft.playwright.Page;
import org.example.BaseTest;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

class ScreenshotTest extends BaseTest {

    @Test
    void screenshotTest() {
        page.navigate("https://limanowa.in/");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot/limanowa.png")));
    }
}
