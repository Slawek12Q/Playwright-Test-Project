package org.example.module_5;

import com.microsoft.playwright.Response;
import org.example.common.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class RequestResponseTest extends BaseTest {

    @Test
    void shouldReturnStatusCode200() {
        Response response = page.navigate("https://skleptestera.pl");

        System.out.println(response.status() + "\n");
        System.out.println(response.request().url() + "\n");
        System.out.println(response.headers() + "\n");
        System.out.println(response.text() + "\n");

        Assertions.assertEquals(response.status(), 200);

    }

    @Test
    void handlers_test() {
        List <Integer> statusList = new ArrayList();

        page.onRequest(req -> System.out.println(">> " + req.method() + " " + req.url()));
        page.onResponse(resp -> {
            System.out.println("<< " + resp.status() + " " + resp.url());
            statusList.add(resp.status());
        });

        Response response = page.navigate("https://skleptestera.pl");

        assertThat(statusList.stream().allMatch(s -> s == 200)).isTrue();
    }
}
