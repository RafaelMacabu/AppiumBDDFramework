package com.qa.utils;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.util.Properties;

public class CapabilitiesManager {

    public DesiredCapabilities getCapabilities() throws IOException {
        GlobalParams params = new GlobalParams();
        Properties properties = new PropertyManager().getProperties();

        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME,params.getPlatformName());
            caps.setCapability(MobileCapabilityType.UDID,params.getUdid());
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,params.getAutomationName());
            caps.setCapability("appPackage",properties.getProperty("androidAppPackage"));
            caps.setCapability("appActivity",properties.getProperty("androidAppActivity"));
            return caps;
        }catch (Exception e){
            e.printStackTrace();
            throw e;

        }
    }
}
