package com.musala.course.framework.utils;

import org.openqa.selenium.WebDriver;

import com.applitools.eyes.selenium.Eyes;

public class EyesManager {
    private final Eyes eyes;
    private final String appName;
    private final WebDriver driver;

    public EyesManager(WebDriver driver, String appName, String apiKey){
        this.driver = driver;
        this.appName = appName;

        eyes = new Eyes();
        eyes.setApiKey(apiKey);
    }

    public void validateWindow(){
        eyes.open(driver, appName, Thread.currentThread().getStackTrace()[2].getMethodName());
        eyes.checkWindow();
        eyes.close();
    }

}
