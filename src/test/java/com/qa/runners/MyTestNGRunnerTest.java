package com.qa.runners;

import com.qa.utils.DriverManager;
import com.qa.utils.GlobalParams;
import com.qa.utils.ServerManager;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.*;

import java.io.IOException;

@CucumberOptions(
        plugin = {"pretty","html:target/cucumber","summary"},
        dryRun = false,
        monochrome = true,
        features = {"src/test/resources"},
        glue = {"com.qa.stepdef"},
        tags = "@Test")
public class MyTestNGRunnerTest {

    private TestNGCucumberRunner testNGCucumberRunner;

    @Parameters({"androidAutomationName"})
    @BeforeSuite
    public void startServer(String androidAutomationName) throws IOException {
        GlobalParams params = new GlobalParams();
        params.setAutomationName(androidAutomationName);
        params.setAdbTimeout("600");
        new ServerManager().startServer();

        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());

    }

    @Parameters({"platformName","udid"})
    @BeforeMethod(alwaysRun = true)
    public void setUpClass(String platformName,String udid) throws IOException {

        GlobalParams params = new GlobalParams();
        params.setPlatformName(platformName);
        params.setUdid(udid);

        new DriverManager().initializeDriver();
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber",description = "Runs Cucumber Scenarios",dataProvider = "scenarios")
    public void scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature){
        testNGCucumberRunner.runScenario(pickle.getPickle());

    }

    @DataProvider
    public Object[][] scenarios(){
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterSuite
    public void closeServer(){

        ServerManager serverManager = new ServerManager();
        if(serverManager.getServer() != null){
            serverManager.getServer().stop();
        }

    }

    @AfterMethod(alwaysRun = true)
    public void tearDownClass(){

        DriverManager driverManager = new DriverManager();
        if (driverManager.getDriver() != null){
            driverManager.getDriver().quit();
            driverManager.setDriver(null);
        }


        testNGCucumberRunner.finish();
    }


}
