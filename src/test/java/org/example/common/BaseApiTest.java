package org.example.common;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;

import java.util.HashMap;
import java.util.Map;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseApiTest {

    private Playwright playwright;
    private APIRequest request;
    protected APIRequestContext requestContext;

    @BeforeAll
    public void setup() {
        playwright = Playwright.create();
        request = playwright.request();
        requestContext = request.newContext();
    }

    @BeforeEach
    public void before() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        requestContext = request.newContext(new APIRequest.NewContextOptions()
                .setBaseURL("https://jsonplaceholder.typicode.com/")
                .setExtraHTTPHeaders(headers));

    }

    @AfterAll
    public void tearDown() {
        playwright.close();
    }
}
