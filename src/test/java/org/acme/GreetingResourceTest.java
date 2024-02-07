package org.acme;

import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class GreetingResourceTest {
    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hello from RESTEasy Reactive"));
    }

    @Test
    public void testGreetingEndpoint() {
        given()
                .when().get("/hello/greeting/test")
                .then()
                .statusCode(200)
                .body(is("Hello, Test"));
    }

    @Test
    public void testGreetingEndpointWithSmallInput() {
        given()
                .when().get("/hello/greeting/t")
                .then()
                .statusCode(200)
                .body(is("Hello, t"));
    }
}