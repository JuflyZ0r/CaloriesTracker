package dao;

import model.Nutrition;
import model.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GetProductInfoFromFile {

    public List<Product> getProductInfoFromFile(String line) {
        List<Product> productList = new LinkedList<>();

        String[] parts = line.split(",");
        for (String part : parts) {
            String[] keyValue = part.split(":");
            if (keyValue.length == 2) {
                String productName = keyValue[0].trim();
                Double calories = Double.parseDouble(keyValue[1].trim());
                Nutrition nutrition = new Nutrition(calories);
                Product productAdd = new Product(productName, nutrition);
                productList.add(productAdd);
            }
        }

        return productList;
    }

    public List<String> getEatenProductDuringDay() {
        List<String> productNamesList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("D:/productEat.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                for (String part : parts) {
                    String productName = part.trim();
                    productNamesList.add(productName);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productNamesList;
    }
}
