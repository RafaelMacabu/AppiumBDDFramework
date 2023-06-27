package com.qa.utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;

public class ServerManager {
    private static ThreadLocal<AppiumDriverLocalService> server = new ThreadLocal<>();

    public AppiumDriverLocalService getServer(){
        return server.get();
    }

    public void startServer(){
        AppiumDriverLocalService server = getAppiumServerDefault();
        server.start();
        if(!server.isRunning()){
            throw new AppiumServerHasNotBeenStartedLocallyException("Server failed to start locally");
        }
        server.clearOutPutStreams();
        this.server.set(server);
    }

    public AppiumDriverLocalService getAppiumServerDefault(){
        return AppiumDriverLocalService.buildDefaultService();
    }

    public AppiumDriverLocalService getAppiumServerWindows(){
        GlobalParams params = new GlobalParams();
        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                        .usingAnyFreePort()
                        .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                        .withLogFile(new File(params.getPlatformName() + "_" +
                                params.getUdid() + File.separator + "Server.log"))
                );

    }
}
