package org.example.module_4;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitUntilState;
import org.example.common.BaseTest;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class BasicAuthTest extends BaseTest {

    @Test
    public void basicAuthTest() {
        page.navigate("https://the-internet.herokuapp.com/basic_auth", new Page.NavigateOptions().setWaitUntil(WaitUntilState.NETWORKIDLE));
        assertThat(page.getByText("Basic Auth")).isVisible();
    }
}
