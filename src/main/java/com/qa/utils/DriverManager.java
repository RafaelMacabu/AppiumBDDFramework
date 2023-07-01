package com.qa.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.util.Properties;

public class DriverManager {
    private static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    public AppiumDriver getDriver(){
        return driver.get();
    }

    public void setDriver(AppiumDriver driver1){
        driver.set(driver1);
    }

    public void initializeDriver() throws IOException {
                driver.set(
                        new AndroidDriver(new ServerManager().getServer().getUrl(),new CapabilitiesManager().getCapabilities()));


        }
    }

