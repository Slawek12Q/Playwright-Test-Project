package org.example.mofule_6_rest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.RequestOptions;
import org.example.common.BaseApiTest;
import org.example.mofule_6_rest.dto.UserDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PartialUpdateUserTest extends BaseApiTest {

    @Test
    public void updateEmailUserTest() {
        JsonObject userUpdate = new JsonObject();
        userUpdate.addProperty("email", "test.email@test.pl");

        APIResponse apiResponse = requestContext.patch("users/10", RequestOptions.create().setData(userUpdate));
        PlaywrightAssertions.assertThat(apiResponse).isOK();
        log.info(apiResponse.text());

        UserDto userDto = new Gson().fromJson(apiResponse.text(), UserDto.class);

        log.info(userDto.toString());

        Assertions.assertTrue(userDto.getEmail().equals("test.email@test.pl"));
    }
}
