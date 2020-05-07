package homework_api_2.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class WordDto {
    private String wordWithError;
    private String lang = "ru,en";
    private long options = 0;
    private String correctWord;
}
