package org.example.mofule_6_rest;

import com.google.gson.Gson;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.example.common.BaseApiTest;
import org.example.mofule_6_rest.dto.UserDto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReadAllUsersTest extends BaseApiTest {

    @Test
    public void readAllUsersTest() {
        APIResponse response = requestContext.get("users");
        PlaywrightAssertions.assertThat(response).isOK();

        List<UserDto> userDtos = Arrays.asList(new Gson().fromJson(response.text(), UserDto[].class));

        for(UserDto userDto: userDtos){
            log.info(userDto.toString());
        }

        List<String> emails = userDtos.stream().map(k -> k.getEmail()).toList();
        log.info(emails.toString());
    }
}
