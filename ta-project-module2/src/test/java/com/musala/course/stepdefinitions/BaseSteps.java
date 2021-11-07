package com.musala.course.stepdefinitions;

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
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BaseSteps {
    private String url;
    private int implicitWait;
    public WebDriver driver;

    private ProductListerPage productListerPage;
    private LoginPage loginPage;

    @Before(order = 0)
    public void readConfigProperties() {
        try (FileInputStream configFile = new FileInputStream("src/test/resources/config.properties")) {
            Properties config = new Properties();
            config.load(configFile);
            url = config.getProperty("url");
            implicitWait = Integer.parseInt(config.getProperty("implicitWait"));
        } catch (IOException ioe) {
            log.error("Problem with reading the configuration file.");
        }
    }

    @Before(value = "@Firefox", order = 1)
    public void setUpFirefox() {
        driver = DriverFactory.getFirefoxDriver(implicitWait);
    }

    @Before(order = 2)
    public void beforeScenario() {
        productListerPage = new ProductListerPage(driver);
        loginPage = new LoginPage(driver);
    }

    @After
    public void tearDownTest() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @Given("^the user is loading the application$")
    public void loadUrl() {
        driver.get(url);
    }


    @And("^the user is logged in with username (.*) and password (.*)$")
//    @And("^the user is logged in with username {string} and password {string}$")
    public void login(String username, String password) {
        loginPage.login(username, password);
    }

    @And("^product lister page is displayed$")
    public void productListerPageDisplayed() {
        productListerPage.waitUntilProductLabelIsVisible(implicitWait);
        Assert.assertTrue(productListerPage.isProductLabelDisplayed());
    }

    @Then("^the user is logged in with following wrong credentials$")
    public void loginWithWrongData(List<Map<String, String>> data) {
        data.forEach(values -> {
            loginPage.login(values.get("username"), values.get("password"));
            Assert.assertEquals(loginPage.getLoginErrorMessage(), values.get("errorMessage"));
            loginPage.clearFields();
        });
    }

    @When("^login page is displayed$")
    public void isLoginLogoDisplayed() {
        Assert.assertTrue(loginPage.isLoginLogoDisplayed());
    }

    @Then("^the price for product (.*) is (.*)$")
    public void verifyProductPrice(String productName, String productPrice){
        Assert.assertTrue(productListerPage.isProductPriceCorrect(productName, productPrice));
    }

}
