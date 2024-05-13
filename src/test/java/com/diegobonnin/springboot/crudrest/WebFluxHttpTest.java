package com.diegobonnin.springboot.crudrest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;


// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebFluxHttpTest {

    @Autowired
    private WebTestClient webTestClient;

    // @Test
    public void test() throws Exception {


        // retrieve the body
        webTestClient.get().uri("/api/k8s-test")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.hostname").isNotEmpty()
                .jsonPath("$.ip").isNotEmpty()
                .jsonPath("$.appVersion").isNotEmpty()
                .jsonPath("$.timestamp").isNotEmpty();

    }

}