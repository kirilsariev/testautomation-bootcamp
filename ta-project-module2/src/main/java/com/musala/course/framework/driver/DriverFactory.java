package com.musala.course.framework.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
    private static final String IGNORE_CERTIFICATE = "--ignore-certificate-errors";

    public static WebDriver getFirefoxDriver(int implicitWait) {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments(IGNORE_CERTIFICATE);

        WebDriverManager.getInstance(FirefoxDriver.class).setup();
        WebDriver driver = new FirefoxDriver(options);
        setImplicitWait(driver, implicitWait);

        return driver;
    }

    private static void setImplicitWait(WebDriver driver, int implicitWait) {
        driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
    }
}
