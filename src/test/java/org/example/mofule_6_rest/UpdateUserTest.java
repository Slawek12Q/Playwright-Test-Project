package org.example.mofule_6_rest;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import org.assertj.core.api.Assertions;
import org.example.common.BaseApiTest;
import org.example.mofule_6_rest.dto.user.Address;
import org.example.mofule_6_rest.dto.user.Company;
import org.example.mofule_6_rest.dto.user.Geo;
import org.example.mofule_6_rest.dto.user.User;
import org.junit.jupiter.api.Test;

public class UpdateUserTest extends BaseApiTest {

    User user = User.builder().id(10).name("Adrian Graham").username("Bret").email("Sincere@april.biz")
            .address(Address.builder().street("sloneczna").suite("Apt. 556").city("Gwenborough").zipcode("92998-3874")
                    .geo(Geo.builder().lat("-37.3159").lng("81.1496").build()).build())
            .phone("1-770-736-8031 x56442").website("hildegard.org")
            .company(Company.builder().name("Romaguera-Crona").catchPhrase("Multi-layered client-server neural-net").bs("harness real-time e-markets").build()).build();

    @Test
    public void updateUserTest() {
        APIResponse apiResponse = requestContext.put("users/10", RequestOptions.create().setData(user));
        log.info(apiResponse.text());

        Assertions.assertThat(apiResponse.status()).isEqualTo(200);

        APIResponse apiResponse1 = requestContext.get("users/10");
        Assertions.assertThat(apiResponse1.status()).isEqualTo(200);
        log.info(apiResponse1.text());
    }
}
