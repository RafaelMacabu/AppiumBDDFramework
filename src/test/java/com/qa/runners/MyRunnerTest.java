package com.qa.runners;


import com.qa.utils.DriverManager;
import com.qa.utils.GlobalParams;
import com.qa.utils.ServerManager;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","html:target/cucumber","summary"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        dryRun = false,
        monochrome = true,
        features = {"src/test/resources"},
        glue = {"com.qa.stepdef"},
        tags = "@Test"
)
public class MyRunnerTest {

    /*@BeforeClass
    public static void initialize() throws IOException {
        GlobalParams params = new GlobalParams();
        params.initializeGlobalParams();
        new ServerManager().startServer();
        new DriverManager().initializeDriver();

    }

    @AfterClass
    public static void quit(){
        DriverManager driverManager = new DriverManager();
        if (driverManager.getDriver() != null){
            driverManager.getDriver().quit();
            driverManager.setDriver(null);
        }
        ServerManager serverManager = new ServerManager();
        if(serverManager.getServer() != null){
            serverManager.getServer().stop();
        }

    }*/

}
