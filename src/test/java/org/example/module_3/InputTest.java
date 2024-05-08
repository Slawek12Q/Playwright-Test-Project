package org.example.module_3;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitUntilState;
import org.assertj.core.api.Assertions;
import org.example.common.BaseTest;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class InputTest extends BaseTest {

    @Test
    public void inputTest() {
        page.navigate("https://the-internet.herokuapp.com/dropdown", new Page.NavigateOptions().setWaitUntil(WaitUntilState.NETWORKIDLE));

//        page.fill("#username", "John Smith", new Page.FillOptions().setForce(true));

        page.selectOption("#dropdown", "1");
        String text = page.innerText("#dropdown");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot/select.png")));

    }
}
