package org.example.module_3;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitUntilState;
import org.example.common.BaseTest;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DynamicWaitTest extends BaseTest {

    @Test
    public void dynamicWaitTest() {
        page.navigate("https://the-internet.herokuapp.com/dynamic_loading/1", new Page.NavigateOptions().setWaitUntil(WaitUntilState.NETWORKIDLE));
        Locator text = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Hello World"));

        assertThat(text).not().isVisible();

        Locator startButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Start"));

        startButton.click();
        assertThat(text).isVisible();

//        page.click("div#start > button");
//        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot/dynamic_wait.png")));
    }

    @Test
    public void dynamicControlTest() {
        page.navigate("https://the-internet.herokuapp.com/dynamic_controls", new Page.NavigateOptions().setWaitUntil(WaitUntilState.NETWORKIDLE));

        Locator removeButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Remove"));

        Locator text = page.getByText("It's gone!");

        assertThat(text).not().isVisible();
        removeButton.click();
        assertThat(text).isVisible();

        Locator input = page.locator("//form/input");

        assertThat(input).isDisabled();

        Locator enableButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Enable"));
        enableButton.click();

        assertThat(input).isEnabled();

    }
}
