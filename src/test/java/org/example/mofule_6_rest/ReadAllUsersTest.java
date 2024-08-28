package org.example.mofule_6_rest;

import com.google.gson.Gson;
import com.microsoft.playwright.APIResponse;
import org.example.common.BaseApiTest;
import org.example.mofule_6_rest.dto.UserDto;
import org.junit.jupiter.api.Test;

public class ReadAllUsersTest extends BaseApiTest {

    @Test
    public void readAllUsersTest() {
        APIResponse response = requestContext.get("users");

        UserDto[] userDtos = new Gson().fromJson(response.text(), UserDto[].class);

        for(UserDto userDto: userDtos){
            System.out.println(userDto);
        }
    }
}
