package org.example.module_4;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.WaitUntilState;
import org.example.common.BaseTest;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

public class FileTest extends BaseTest {


    @Test
    public void uploadFileTest() {
        page.navigate("https://the-internet.herokuapp.com/upload", new Page.NavigateOptions().setWaitUntil(WaitUntilState.NETWORKIDLE));

        page.setInputFiles("#file-upload", Paths.get("document/PWtestUpload.txt"));
        page.locator("#file-submit").click();
        assertThat(page.getByText("File Uploaded!")).isVisible();
    }
}