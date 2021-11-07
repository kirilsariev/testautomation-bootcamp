package com.musala.course.tests;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;

public class ApiSimpleTests {

    @Test
    void requestUsZipCodeUs(){
        given().
        when().
           get("http://zippopotam.us/us/90210").
        then().
           assertThat().
           statusCode(200).
           contentType(ContentType.JSON);
    }

    @Test
    void loggingRequestAndResponseDetails(){
        given().
           log().all().
        when().
           get("http://zippopotam.us/us/90210").
        then().
           log().body();
    }

    @Test
    void requestUsZipCodeBgEqualsTo(){
        given().
        when().
           get("http://zippopotam.us/bg/6600").
        then().
           assertThat().
           body("places[1].'place name'", equalTo("Кърджали / Kurdzhali"));
    }

    @Test
    void requestUsZipCodeBgHasItem(){
        given().
        when().
           get("http://zippopotam.us/bg/6600").
        then().
           assertThat().
           body("places.'place name'", hasItem("Кърджали / Kurdzhali"));
    }

    @Test
    void requestUsZipCodeBgNotHasItem(){
        given().
                when().
                get("http://zippopotam.us/bg/6600").
                then().
                assertThat().
                body("places.'place name'", not(hasItem("Kurdzhali")));
    }

    @Test
    void requestUsZipCodeBgHasSize(){
        given().
                when().
                get("http://zippopotam.us/bg/6600").
                then().
                assertThat().
                body("places.'place name'", hasSize(2));
    }
}
