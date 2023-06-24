package com.qa.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

public class MyRunnerTest {

    @RunWith(Cucumber.class)
    @CucumberOptions(
            plugin = {"pretty","html:target/cucumber","summary"},
            snippets = CucumberOptions.SnippetType.CAMELCASE,
            dryRun = true,
            monochrome = true
    )
    public class RunCucumberTest{

    }
}
