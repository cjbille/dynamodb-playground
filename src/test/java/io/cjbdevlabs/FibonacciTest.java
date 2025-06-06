package io.cjbdevlabs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class FibonacciTest {

    @Test
    void testFibonacciEndpoint() {
        given()
          .when().get("/fibonacci/2")
          .then()
             .statusCode(200)
             .body(is("1"));
    }
}
