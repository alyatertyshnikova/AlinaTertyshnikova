package homework_api_2;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ResourceManager {
    public static <T> T getObjectsFromJson(String jsonFile, Class<T> valueType) {
        T objects = null;
        try (FileReader reader = new FileReader(jsonFile)) {
            ObjectMapper objectMapper = new ObjectMapper();
            objects = objectMapper.readValue(reader, valueType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objects;
    }

    public static Properties getTestProperties() {
        Properties properties = new Properties();
        String propertyFile = "/test.properties";
        try {
            properties.load(ResourceManager.class.getResourceAsStream(propertyFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
