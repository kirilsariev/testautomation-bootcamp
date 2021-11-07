package com.musala.course.stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import lombok.Setter;

public class RequestBuilder {
    private Map<String, String> headers = new HashMap<>();
    @Setter
    private String country;
    @Setter
    private String zipCode;

    public void addHeader(String header) {
        String[] parts = header.split(":");
        if (parts.length == 2) {
            headers.put(parts[0], parts[1]);
        }
    }

    public ValidatableResponse executeGetRequest(String baseUrl) {
        return getRequestSpecification()
//                .auth().basic(username, password)
                .when().get(baseUrl)
                .then();
    }

    private RequestSpecification getRequestSpecification() {
        RequestSpecification requestSpecification = RestAssured.with()
                .headers(headers);

        if (country != null) {
            requestSpecification.queryParam("country", country);
        }

        if (zipCode != null) {
            requestSpecification.queryParam("zipCode", zipCode);
        }

        return requestSpecification;
    }
}
