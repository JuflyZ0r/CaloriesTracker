package repository.IMPL;

import dao.impl.ProductFileDAO;
import model.CaloriesPerDay;
import model.Nutrition;
import model.Product;
import repository.ProductRepository;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class ProductFileRepository implements ProductRepository{

    ProductFileDAO productFileDAO = new ProductFileDAO();
    String address = "D:/out.txt";

    String address2 = "D:/productEat.txt";

    String address3 = "D:/caloriesPerDay.txt";

    List<Product> productsList = new ArrayList<>();


    public ProductFileRepository(List<Product> productsList) {
        this.productsList = productsList;
    }

    public ProductFileRepository() {
    }
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


    public void saveToFile(List<Product> productList) throws IOException {

        String productListString = productList.stream()
                .map(product -> product.getProductName() + ":" + product.getNutrition().getCalories())
                .collect(Collectors.joining(","));
        productFileDAO.saveToFileDAO(productListString,address);
    }

    public void saveCaloriesValuePerDay(double calories) throws IOException {

        LocalDate localDate = LocalDate.now();


        CaloriesPerDay caloriesPerDay = new CaloriesPerDay(localDate,calories);


        String data = caloriesPerDay.getDate() + ":" + caloriesPerDay.getCaloriesSum() + "\n";
        productFileDAO.saveToFileDAO(data,address3);
        System.out.println(data);

    }

    public void saveEatenProductName(List<String> namesList) throws IOException {

        String productListString = namesList + ",";
        productFileDAO.saveToFileDAO(productListString,address2);
    }
}
