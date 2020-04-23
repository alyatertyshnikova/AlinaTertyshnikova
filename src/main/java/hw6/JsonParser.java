package hw6;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonParser {
    private JSONArray usersList;
    private final JSONParser jsonParser;

    public JsonParser(String jsonFile) {
        jsonParser = new JSONParser();
        usersList = toParse(jsonFile);
    }

    private JSONArray toParse(String jsonFile) {
        try (FileReader reader = new FileReader(jsonFile)) {
            usersList = (JSONArray) jsonParser.parse(reader);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return usersList;
    }

    public String getUserData(String username, String key) {
        JSONObject userData = (JSONObject) usersList.stream()
                .filter(user -> ((JSONObject) user).get("username").equals(username))
                .findFirst()
                .get();
        return userData.get(key).toString();
    }
}
