package homework_api_2.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Accessors(chain = true)
public class WordDto {
    private List<String> wordWithError;
    private String lang = "ru,en";
    private long options = 0;
    private List<String> correctWord;

    public Map<String, Object> toParamsMap() {
        Map<String, Object> params = new HashMap<>();
        params.put("text", wordWithError);
        params.put("lang", lang);
        params.put("options", options);
        return params;
    }
}
