package hw6;

import java.util.List;
import java.util.Map;

public class MapTable {
    private Map<String, List<String>> table;

    public MapTable(Map<String, List<String>> table) {
        this.table=table;
    }

    public List<String> getTableValues(String key) {
        return table.get(key);
    }
}
