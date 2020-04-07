package hw4;

import java.util.ResourceBundle;

public class ResourceProperty {
    private ResourceBundle bundle;

    public ResourceProperty(String propertyFileName) {
        bundle = ResourceBundle.getBundle(propertyFileName);
    }

    public String getValue(String key) {
        return bundle.getString(key);
    }

}
