package org.example.module_3;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitUntilState;
import org.example.common.BaseTest;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class DynamicWaitTest extends BaseTest {

    @Test
    public void dynamicWaitTest() {
        page.navigate("https://the-internet.herokuapp.com/dynamic_loading/1", new Page.NavigateOptions().setWaitUntil(WaitUntilState.NETWORKIDLE));
        Locator text = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Hello World"));

        PlaywrightAssertions.assertThat(text).not().isVisible();

        Locator startButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Start"));

        startButton.click();
        PlaywrightAssertions.assertThat(text).isVisible();

//        page.click("div#start > button");
//        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot/dynamic_wait.png")));
    }

    @Test
    public void dynamicControlTest() {
        page.navigate("https://the-internet.herokuapp.com/dynamic_controls", new Page.NavigateOptions().setWaitUntil(WaitUntilState.NETWORKIDLE));

        Locator removeButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Remove"));

        Locator text = page.getByText("It's gone!");

        PlaywrightAssertions.assertThat(text).not().isVisible();
        removeButton.click();
        PlaywrightAssertions.assertThat(text).isVisible();

        Locator input = page.locator("//form/input");

        PlaywrightAssertions.assertThat(input).isDisabled();

        Locator enableButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Enable"));
        enableButton.click();

        PlaywrightAssertions.assertThat(input).isEnabled();

    }
}
