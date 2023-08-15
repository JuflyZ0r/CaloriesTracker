package model;

import java.util.Map;
import java.util.Objects;

public class Product {

    private String productName;
    private Nutrition nutrition;

    public Product(String productName, Nutrition nutrition) {
        this.productName = productName;
        this.nutrition = nutrition;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Nutrition getNutrition() {
        return nutrition;
    }

    public void setNutrition(Nutrition nutrition) {
        this.nutrition = nutrition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productName, product.productName) && Objects.equals(nutrition, product.nutrition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, nutrition);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", nutrition=" + nutrition +
                '}';
    }
}
