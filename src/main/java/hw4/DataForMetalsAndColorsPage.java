package hw4;

import java.util.LinkedList;
import java.util.List;

public class DataForMetalsAndColorsPage {
    private String a;
    private String b;
    private String[] elements;
    private String color;
    private String metal;
    private String[] vegetables;

    private DataForMetalsAndColorsPage(String a, String b, String[] elements, String color, String metal, String[] vegetables) {
        this.a = a;
        this.b = b;
        this.elements = elements;
        this.color = color;
        this.metal = metal;
        this.vegetables = vegetables;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public String[] getElements() {
        return elements;
    }

    public String getColor() {
        return color;
    }

    public String getMetal() {
        return metal;
    }

    public String[] getVegetables() {
        return vegetables;
    }

    public List<String> getNonDefaultResultStrings() {
        List<String> result = new LinkedList<>();
        if (!a.isEmpty() && !b.isEmpty()) {
            result.add("Summary: " + (Integer.parseInt(a) + Integer.parseInt(b)));
        }
        if (elements.length != 0) {
            result.add("Elements: " + String.join(", ", elements));
        }
        if (!color.isEmpty()) {
            result.add("Color: " + color);
        }
        if (!metal.isEmpty()) {
            result.add("Metal: " + metal);
        }
        if (vegetables.length != 0) {
            result.add("Vegetables: " + String.join(", ", vegetables));
        }
        return result;
    }

    public static class Builder {
        private String a = "";
        private String b = "";
        private String[] elements = new String[]{};
        private String color = "";
        private String metal = "";
        private String[] vegetables = new String[]{};

        public Builder setA(String a) {
            this.a = a;
            return this;
        }

        public Builder setB(String b) {
            this.b = b;
            return this;
        }

        public Builder setElements(String... elements) {
            this.elements = elements;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setMetal(String metal) {
            this.metal = metal;
            return this;
        }

        public Builder setVegetables(String... vegetables) {
            this.vegetables = vegetables;
            return this;
        }

        public DataForMetalsAndColorsPage build() {
            return new DataForMetalsAndColorsPage(a, b, elements, color, metal, vegetables);
        }
    }
}
