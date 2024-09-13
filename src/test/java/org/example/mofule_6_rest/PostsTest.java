package org.example.mofule_6_rest;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.example.common.BaseApiTest;
import org.junit.jupiter.api.Test;

class PostsTest extends BaseApiTest {


    @Test
    public void readOnePost() {
        APIResponse apiResponse = requestContext.get("posts/1");
        PlaywrightAssertions.assertThat(apiResponse).isOK();
        log.info(apiResponse.text());
    }
}
