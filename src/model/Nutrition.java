package model;

import java.util.Objects;

public class Nutrition {

    private Double calories;

    public Nutrition(Double calories) {
        this.calories = calories;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nutrition calories1 = (Nutrition) o;
        return Objects.equals(calories, calories1.calories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(calories);
    }

    @Override
    public String toString() {
        return "model.Calories{" +
                "calories=" + calories +
                '}';
    }
}

