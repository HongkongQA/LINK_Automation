package com.linkreit.automationtest;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"/Users/colbert.zhou/Downloads/LINK_Testing/src/test/resources/LINKsearch.feature"},
        format = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},
        glue = {"com.linkreit.automationtest"}

)

public class Run {


}

