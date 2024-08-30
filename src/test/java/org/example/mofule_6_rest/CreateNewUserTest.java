package org.example.mofule_6_rest;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import org.example.common.BaseApiTest;
import org.junit.jupiter.api.Test;

public class CreateNewUserTest extends BaseApiTest {


    private static final String newUSer = """
              {
              "id": 11,
              "name": "Adrian Graham",
              "username": "Bret",
              "email": "Sincere@april.biz",
              "address": {
                "street": "Kulas Pulas",
                "suite": "Apt. 556",
                "city": "Gwenborough",
                "zipcode": "92998-3874",
                "geo": {
                  "lat": "-37.3159",
                  "lng": "81.1496"
                }
              },
              "phone": "1-770-736-8031 x56442",
              "website": "hildegard.org",
              "company": {
                "name": "Romaguera-Crona",
                "catchPhrase": "Multi-layered client-server neural-net",
                "bs": "harness real-time e-markets"
              }
            }
            """;

    @Test
    public void createNewUserPlainText() {
        APIResponse apiResponse = requestContext.post("users", RequestOptions.create().setData(newUSer));
        log.info(apiResponse.text());
    }
}
