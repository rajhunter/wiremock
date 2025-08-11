package com.wiremock.wiremock.service;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.*;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class PaymentServiceTest {

    private WireMockServer wireMockServer;

    @BeforeEach
    public void setup() {
        wireMockServer = new WireMockServer(8081); // same as your app's URL
        wireMockServer.start();

        configureFor("localhost", 8081);
        stubFor(get(urlEqualTo("/api/payment"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody("Success")));
    }

    @AfterEach
    public void teardown() {
        wireMockServer.stop();
    }

    // test your PaymentService here
}
