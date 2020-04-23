package hw_jdi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public final class JsonParser {
    public static <T> T getObjectsFromJson(String jsonFile, Class<T> valueType) {
        T objects = null;
        try (FileReader reader = new FileReader(jsonFile)) {
            JSONParser jsonParser = new JSONParser();
            ObjectMapper objectMapper = new ObjectMapper();
            JSONObject jsonContent = (JSONObject) jsonParser.parse(reader);
            objects = objectMapper.convertValue(jsonContent.values(), valueType);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return objects;
    }
}
