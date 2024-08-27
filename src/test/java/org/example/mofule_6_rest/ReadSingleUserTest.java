package org.example.mofule_6_rest;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class ReadSingleUserTest {

    Playwright playwright;
    APIRequest apiRequest;
    APIRequestContext apiRequestContext;

    @BeforeEach
    void setup() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        playwright = Playwright.create();
        apiRequest = playwright.request();
        apiRequestContext = apiRequest.newContext(new APIRequest.NewContextOptions()
                .setBaseURL("https://jsonplaceholder.typicode.com/")
                .setExtraHTTPHeaders(headers));
    }
    @Test
    void shouldReturnSingleUserTest() {
        APIResponse apiResponse = apiRequestContext.get("users/10");
        System.out.println(apiResponse.text());
        PlaywrightAssertions.assertThat(apiResponse).isOK();

    }
}
