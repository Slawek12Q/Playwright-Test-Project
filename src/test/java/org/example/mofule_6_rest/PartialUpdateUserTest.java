package org.example.mofule_6_rest;

import com.google.gson.JsonObject;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.RequestOptions;
import org.example.common.BaseApiTest;
import org.junit.jupiter.api.Test;

public class PartialUpdateUserTest extends BaseApiTest {

    @Test
    public void updateEmailUserTest() {
        JsonObject userUpdate = new JsonObject();
        userUpdate.addProperty("email", "test.email@test.pl");

        APIResponse apiResponse = requestContext.patch("users/10", RequestOptions.create().setData(userUpdate));
        PlaywrightAssertions.assertThat(apiResponse).isOK();
        log.info(apiResponse.text());
    }
}
