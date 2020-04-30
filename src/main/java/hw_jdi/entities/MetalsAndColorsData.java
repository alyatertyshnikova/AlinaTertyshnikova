package hw_jdi.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.codehaus.plexus.util.StringUtils.isNotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class MetalsAndColorsData {
    private String[] summary;
    private String[] elements;
    private String color;
    private String metals;
    private String[] vegetables;

    public String[] getNonDefaultResultStrings() {
        List<String> result = new LinkedList<>();
        if (isNotEmpty(summary[0]) && isNotEmpty(summary[1])) {
            int sum = Arrays.stream(summary).mapToInt(Integer::parseInt).sum();
            result.add("Summary: " + sum);
        }
        if (elements.length != 0) {
            result.add("Elements: " + String.join(", ", elements));
        }
        if (isNotEmpty(color)) {
            result.add("Color: " + color);
        }
        if (isNotEmpty(metals)) {
            result.add("Metal: " + metals);
        }
        if (vegetables.length != 0) {
            result.add("Vegetables: " + String.join(", ", vegetables));
        }
        return result.toArray(new String[0]);
    }
}
