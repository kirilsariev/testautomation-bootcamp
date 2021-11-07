package com.musala.course;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        plugin = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber.json"})
public class CucumberTestRunnerIT {

}
