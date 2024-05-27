package org.example.common;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.nio.file.Paths;

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
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));

        page = context.newPage();
    }


    @AfterEach
    void afterEach() {
        context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace/trace.zip")));
        context.close();
    }

    @AfterAll
    static void afterAll() {
        playwright.close();
    }


}
