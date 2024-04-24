package org.example.module_1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class FirstClass extends BaseTest {

    @Test
    void firstTest() {
        page.navigate("https://playwright.dev/");

        Assertions.assertThat(page.title()).isEqualTo("Fast and reliable end-to-end testing for modern web apps | Playwright");
    }
}
