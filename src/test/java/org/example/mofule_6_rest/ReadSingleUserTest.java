package org.example.mofule_6_rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.example.common.BaseApiTest;
import org.example.mofule_6_rest.dto.UserDto;
import org.junit.jupiter.api.Test;

public class ReadSingleUserTest extends BaseApiTest {


    @Test
    void shouldReturnSingleUserTest() {
        APIResponse apiResponse = requestContext.get("users/10");
        System.out.println(apiResponse.text());
        System.out.println(apiResponse.status());
        System.out.println(apiResponse.statusText());
        System.out.println(apiResponse.headers());
        System.out.println(apiResponse.body());
        PlaywrightAssertions.assertThat(apiResponse).isOK();

    }

    @Test
    void shouldReturnSingleUserGsonTest() {
        APIResponse apiResponse = requestContext.get("users/10");

        PlaywrightAssertions.assertThat(apiResponse).isOK();

        JsonObject jsonResponse = new Gson().fromJson(apiResponse.text(), JsonObject.class);
        System.out.println(jsonResponse);
        System.out.println(jsonResponse.get("id"));
        System.out.println(jsonResponse.get("name"));
    }

    @Test
    void shouldReturnSingleUserJacksonTest() throws JsonProcessingException {
        APIResponse apiResponse = requestContext.get("users/10");

        PlaywrightAssertions.assertThat(apiResponse).isOK();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(apiResponse.text());
        System.out.println(jsonNode.toPrettyString());
    }

    @Test
    void shouldReturnSingleUserDtoTest() throws JsonProcessingException {
        APIResponse apiResponse = requestContext.get("users/10");

        PlaywrightAssertions.assertThat(apiResponse).isOK();

        UserDto userDto = new Gson().fromJson(apiResponse.text(), UserDto.class);
        System.out.println(userDto);
    }
}
