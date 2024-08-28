package org.example.mofule_6_rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.example.mofule_6_rest.dto.UserDto;
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
        System.out.println(apiResponse.status());
        System.out.println(apiResponse.statusText());
        System.out.println(apiResponse.headers());
        System.out.println(apiResponse.body());
        PlaywrightAssertions.assertThat(apiResponse).isOK();

    }

    @Test
    void shouldReturnSingleUserGsonTest() {
        APIResponse apiResponse = apiRequestContext.get("users/10");

        PlaywrightAssertions.assertThat(apiResponse).isOK();

        JsonObject jsonResponse = new Gson().fromJson(apiResponse.text(), JsonObject.class);
        System.out.println(jsonResponse);
        System.out.println(jsonResponse.get("id"));
        System.out.println(jsonResponse.get("name"));
    }

    @Test
    void shouldReturnSingleUserJacksonTest() throws JsonProcessingException {
        APIResponse apiResponse = apiRequestContext.get("users/10");

        PlaywrightAssertions.assertThat(apiResponse).isOK();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(apiResponse.text());
        System.out.println(jsonNode.toPrettyString());
    }

    @Test
    void shouldReturnSingleUserDtoTest() throws JsonProcessingException {
        APIResponse apiResponse = apiRequestContext.get("users/10");

        PlaywrightAssertions.assertThat(apiResponse).isOK();

        UserDto userDto = new Gson().fromJson(apiResponse.text(), UserDto.class);
        System.out.println(userDto);
    }
}
