package org.example.mofule_6_rest;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.RequestOptions;
import org.example.common.BaseApiTest;
import org.example.mofule_6_rest.dto.user.Address;
import org.example.mofule_6_rest.dto.user.Company;
import org.example.mofule_6_rest.dto.user.Geo;
import org.example.mofule_6_rest.dto.user.User;
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

    @Test
    public void createNewUserDTOTest() {
        User user = User.builder().id(12).name("Adrian Graham").username("Bret").email("Sincere@april.biz")
                .address(Address.builder().street("sloneczna").suite("Apt. 556").city("Gwenborough").zipcode("92998-3874")
                        .geo(Geo.builder().lat("-37.3159").lng("81.1496").build()).build())
                .phone("1-770-736-8031 x56442").website("hildegard.org")
                .company(Company.builder().name("Romaguera-Crona").catchPhrase("Multi-layered client-server neural-net").bs("harness real-time e-markets").build()).build();

        User user1 = user.withName("Michal").withUsername("Kowalski");

        APIResponse apiResponse = requestContext.post("users", RequestOptions.create().setData(user));
        APIResponse apiResponse1 = requestContext.post("users", RequestOptions.create().setData(user1));
        PlaywrightAssertions.assertThat(apiResponse).isOK();
        PlaywrightAssertions.assertThat(apiResponse1).isOK();
        log.info(apiResponse.text());
        log.info(apiResponse1.text());
    }
}
