package com.musala.course.stepdefinitions;

import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.musala.course.framework.driver.DriverFactory;
import com.musala.course.framework.pages.LoginPage;
import com.musala.course.framework.pages.ProductListerPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApiSteps {

    private ValidatableResponse validatableResponse;
    private RequestBuilder requestBuilder = new RequestBuilder();


    @When("^the client calls the REST API endpoint$")
    public void theClientCallsTheRESTAPIEndpoint() {
        validatableResponse = requestBuilder.executeGetRequest("http://zippopotam.us/");
    }

    @And("^request has header \"([^\"]*)\"$")
    public void reportHeaderIs(String header) {
        requestBuilder.addHeader(header);
    }

    @And("^country is \"([^\"]*)\"$")
    public void countryIs(String country) {
        requestBuilder.setCountry(country);
    }

    @And("^zip code is \"([^\"]*)\"$")
    public void zipCodeIs(String zipCode) {
        requestBuilder.setZipCode(zipCode);
    }

    @Then("^the status code is (\\d+)$")
    public void theStatusCodeIs(int statusCode) {
        if (validatableResponse.extract().statusCode() != statusCode) {
            validatableResponse.log().all(true);
        }
        validatableResponse.statusCode(equalTo(statusCode));
    }

}
