package org.example.mofule_6_rest.transformers;

import com.google.gson.Gson;
import com.microsoft.playwright.APIResponse;
import org.example.mofule_6_rest.dto.PostsDto;

public class PostTransformers {

    public static PostsDto readUserToResponsePostDto(APIResponse apiResponse) {
        return new Gson().fromJson(apiResponse.text(), PostsDto.class);
    }
}
