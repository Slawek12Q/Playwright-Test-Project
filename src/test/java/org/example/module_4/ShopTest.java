package org.example.module_4;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitUntilState;
import org.example.common.BaseTest;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ShopTest extends BaseTest {

    @Test
    public void sendEmptyFormTest() {
        page.navigate("http://www.automationpractice.pl/index.php", new Page.NavigateOptions().setWaitUntil(WaitUntilState.NETWORKIDLE));

        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Contact us")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Send")).click();

        Locator errorForm = page.locator("//div[@class='alert alert-danger']");
        errorForm.screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("screenshot/errorForm.jpg")));
        assertThat(errorForm.locator("li")).hasText("Invalid email address.");
    }
}
