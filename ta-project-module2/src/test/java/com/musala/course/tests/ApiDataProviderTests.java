package com.musala.course.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.*;

@RunWith(DataProviderRunner.class)
public class ApiDataProviderTests {

    @DataProvider
    public static Object[][] zipCodeAndPlaces() {
        return new Object[][] {
                {"us", "90210", "Beverly Hills"},
                {"bg", "1000", "София / Sofija"},
                {"bg", "9000", "Варна / Varna"}
        };
    }

    @Test
    @UseDataProvider("zipCodeAndPlaces")
    public void requestUsZipCodeDataProvider(String countryCode, String zipCode, String state) {
        given().
           pathParam("countryCode", countryCode).pathParam("zipCode", zipCode).
        when().
           get("http://zippopotam.us/{countryCode}/{zipCode}").
        then().
           assertThat().
           body("places[0].'place name'", equalTo(state));
    }

}
