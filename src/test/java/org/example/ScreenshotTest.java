package org.example;

import com.microsoft.playwright.Page;
import org.example.module_1.BaseTest;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

class ScreenshotTest extends BaseTest {

    @Test
    void screenshotTest() {
        page.navigate("https://limanowa.in/");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot/limanowa.png")));
    }
}
