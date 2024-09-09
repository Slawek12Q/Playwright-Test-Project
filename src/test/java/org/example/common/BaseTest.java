package org.example.common;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest {

    private static Playwright playwright;
    private static Browser browser;
    private BrowserContext context;

    protected Page page;

    @BeforeAll
    static void beforeAll() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
    }

    @BeforeEach
    void beforeEach() {
//        Bacis Auth
//        context = browser.newContext(new Browser.NewContextOptions().setHttpCredentials("admin", "admin"));
        context = browser.newContext();

        //
       context.tracing().start(new Tracing.StartOptions()
               .setSources(true)
               .setSnapshots(true)
               .setScreenshots(true));

        page = context.newPage();
    }


    @AfterEach
    void afterEach(TestInfo testInfo) {
        String traceName = "trace/trace_"
                +testInfo.getDisplayName().replace("()", "")
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"))
                +".zip";

        context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get(traceName)));
        context.close();
    }

    @AfterAll
    static void afterAll() {
        playwright.close();
    }
}
