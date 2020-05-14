package homework_api_2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ErrorDto {
    private long code;
    private long pos;
    private long row;
    private long col;
    private long len;
    private String word;
    private List<String> s;
}
