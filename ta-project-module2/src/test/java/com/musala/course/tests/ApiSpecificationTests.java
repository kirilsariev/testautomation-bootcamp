package com.musala.course.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ApiSpecificationTests {

    private static RequestSpecification requestSpec;

    @BeforeAll
    public static void createRequestSpecification() {
        requestSpec = new RequestSpecBuilder().
                setBaseUri("http://zippopotam.us").
                build();
    }

    @Test
    void requestSpecTest() {
        given().
                spec(requestSpec).
        when().
                get("us/90210").
        then().
                assertThat().
                statusCode(200);
    }

    private static ResponseSpecification responseSpec;

    @BeforeAll
    public static void createResponseSpecification() {
        responseSpec = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON).
                build();
    }

    @Test
    void responseSpecTest() {
        given().
             spec(requestSpec).
        when().
             get("us/90210").
        then().
              spec(responseSpec).
        and().
              assertThat().
              body("places[0].'place name'", equalTo("Beverly Hills"));
    }

    @Test
    void extractBodyInVariablesTest() {

        String stateName =

        given().
             spec(requestSpec).
        when().
             get("us/90210").
        then().
             extract().
             path("places[0].'place name'");

        Assertions.assertEquals("Beverly Hills", stateName);
    }


}
