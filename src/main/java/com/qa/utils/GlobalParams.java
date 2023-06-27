package com.qa.utils;

public class GlobalParams {
    private static ThreadLocal<String> platformName = new ThreadLocal<>();
    private static ThreadLocal<String> udid = new ThreadLocal<>();
    private static ThreadLocal<String> automationName = new ThreadLocal<>();
    private static String adbTimeout = "";

    public  String getAdbTimeout() {
        return adbTimeout;
    }

    public void setAdbTimeout(String adbTimeout) {
        GlobalParams.adbTimeout = adbTimeout;
    }

    public  String getAutomationName() {
        return automationName.get();
    }

    public  void setAutomationName(String automationName1) {
        automationName.set(automationName1);
    }

    public  String getPlatformName() {
       return platformName.get();
    }

    public  void setPlatformName(String platformName1) {
        platformName.set(platformName1);
    }

    public  String getUdid() {
        return udid.get();
    }

    public  void setUdid(String udid1) {
        udid.set(udid1);
    }

    public void initializeGlobalParams(){
        GlobalParams params = new GlobalParams();
        params.setPlatformName(System.getProperty("platformName","android"));
        params.setUdid(System.getProperty("udid","291d97f2"));
        params.setAutomationName(System.getProperty("androidAutomationName","UiAutomator2"));
        params.setAdbTimeout(System.getProperty("adbTimeout","600000"));
    }


}
