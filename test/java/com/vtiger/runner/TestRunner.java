package com.vtiger.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = "com.vtiger.stepdefinitions",
		//dryRun = true,
		plugin = {"pretty", "html:target/cucumber-html-report.html","json:target/cucumber.json"},
		monochrome = true,
		tags = "@TC01"
		)
        
public class TestRunner {

}
