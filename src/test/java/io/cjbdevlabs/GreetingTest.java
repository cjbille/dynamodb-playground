package io.cjbdevlabs;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
class GreetingTest {

    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/greeting/hello")
          .then()
             .statusCode(200)
             .body(containsString("Hello from Quarkus REST"));
    }

    @Test
    void testNameEndpoint() {
        given()
                .queryParam("name", "Chris")
                .when().get("/greeting/name")
                .then()
                .statusCode(200)
                .body(containsString("Hello there Chris"));
    }
}