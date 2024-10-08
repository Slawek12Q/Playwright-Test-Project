package org.example.mofule_6_rest;

import com.google.gson.Gson;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.RequestOptions;
import org.example.common.BaseApiTest;
import org.example.mofule_6_rest.dto.PostsDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.example.mofule_6_rest.transformers.PostTransformers.readUserToResponsePostDto;

class PostsTest extends BaseApiTest {


    @Test
    public void readOnePost() {
        APIResponse apiResponse = requestContext.get("posts/1");
        PlaywrightAssertions.assertThat(apiResponse).isOK();
        log.info(apiResponse.text());
        PostsDto postsDto = readUserToResponsePostDto(apiResponse);
        System.out.println(postsDto.toString());
    }

    @Test
    public void readAllPosts() {
        APIResponse apiResponse = requestContext.get("posts");
        PlaywrightAssertions.assertThat(apiResponse).isOK();
        log.info(apiResponse.text());

        List<PostsDto> postsDtos = List.of(new Gson().fromJson(apiResponse.text(), PostsDto[].class));

        for (PostsDto postsDto : postsDtos) {
            System.out.println(postsDto);
        }
    }

    @Test
    public void createNewPost() {
        PostsDto post = PostsDto.builder().userID(1).id(1000).title("Tytul").body("Body").build();

        APIResponse apiResponse = requestContext.post("posts", RequestOptions.create().setData(post));
        PlaywrightAssertions.assertThat(apiResponse).isOK();
        log.info(apiResponse.text());
    }

    @Test
    public void UpdatePost() {
        PostsDto post = PostsDto.builder().userID(1).id(1).title("Tytul").body("Body").build();

        APIResponse apiResponse = requestContext.put("posts/1", RequestOptions.create().setData(post));
        PlaywrightAssertions.assertThat(apiResponse).isOK();
        log.info(apiResponse.text());
    }

    @Test
    public void deletePost() {
        APIResponse apiResponse = requestContext.delete("posts/1");
        PlaywrightAssertions.assertThat(apiResponse).isOK();
        log.info(apiResponse.text());
    }
}
