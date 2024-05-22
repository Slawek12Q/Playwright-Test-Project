package org.example.module_4;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitUntilState;
import org.example.common.BaseTest;
import org.junit.jupiter.api.Test;

class DialogTest extends BaseTest {

    @Test
    public void checkJSAllert() {
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts", new Page.NavigateOptions().setWaitUntil(WaitUntilState.NETWORKIDLE));

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Click for JS Alert")).click();

        PlaywrightAssertions.assertThat(page.locator("#result")).hasText("You successfully clicked an alert");
    }

    @Test
    public void checkJSConfirm() {
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts", new Page.NavigateOptions().setWaitUntil(WaitUntilState.NETWORKIDLE));


        page.onceDialog(dialog -> {
            dialog.dismiss();
        });

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Click for JS Confirm")).click();
        PlaywrightAssertions.assertThat(page.locator("#result")).hasText("You clicked: Cancel");
    }

    @Test
    public void checkJSPrompt() {
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts", new Page.NavigateOptions().setWaitUntil(WaitUntilState.NETWORKIDLE));

        page.onceDialog(dialog -> {
            dialog.accept("Hello World");
        });

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Click for JS Prompt")).click();
        PlaywrightAssertions.assertThat(page.locator("#result")).hasText("You entered: Hello World");
    }
}