package homework_api_2;

import java.io.IOException;
import java.util.Properties;

public class ResourceManager {
    private static Properties properties;

    public static String getTestProperty(String key) {
        if (properties == null) {
            properties = readTestProperties();
        }
        return properties.getProperty(key);
    }

    private static Properties readTestProperties() {
        properties = new Properties();
        String propertyFile = "/test.properties";
        try {
            properties.load(ResourceManager.class.getResourceAsStream(propertyFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
