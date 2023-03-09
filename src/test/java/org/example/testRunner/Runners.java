package org.example.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"C:\\Users\\EGYPT SRORE\\IdeaProjects\\NopCommerce_Project\\src\\main\\resources\\features"},
        glue = {"org.example.stepDefinitions"},
        tags = "@smoke",
        plugin = {
                "pretty",
                "html:target/cucumber.html",
                "json:target/cucumber.json",
                "junit:target/cukes.xml",
                "rerun:target/rerun.txt"
        }
)
public class Runners extends AbstractTestNGCucumberTests {
}
