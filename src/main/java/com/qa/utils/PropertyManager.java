package com.qa.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {
    private static Properties properties = new Properties();

    public Properties getProperties() throws IOException {
        InputStream is = null;
        String propsFileName = "config.properties";
        if(properties.isEmpty()){
            try {
                is = getClass().getClassLoader().getResourceAsStream(propsFileName);
                properties.load(is);
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (is != null){
                    is.close();

                }
            }

        }
        return properties;
    }
}
