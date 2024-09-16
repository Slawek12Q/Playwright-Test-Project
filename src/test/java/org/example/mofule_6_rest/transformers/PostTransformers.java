package org.example.mofule_6_rest.transformers;

import com.google.gson.Gson;
import com.microsoft.playwright.APIResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.mofule_6_rest.dto.PostsDto;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PostTransformers {

    public static PostsDto readUserToResponsePostDto(APIResponse apiResponse) {
        return new Gson().fromJson(apiResponse.text(), PostsDto.class);
    }
}
