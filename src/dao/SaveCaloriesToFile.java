package dao;

import model.CaloriesPerDay;
import model.Product;
import repository.IMPL.ProductFileRepository;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SaveCaloriesToFile{
    ProductFileRepository productFileRepository = new ProductFileRepository();
    String address = "C:/Users/Daniil/IdeaProjects/Task2/db/out.txt";

    String address2 = "C:/Users/Daniil/IdeaProjects/Task2/db/productEat.txt";

    String address3 = "C:/Users/Daniil/IdeaProjects/Task2/db/caloriesPerDay.txt";


    List<Product> productsList = new ArrayList<>();

    public SaveCaloriesToFile(List<Product> productsList) {
        this.productsList = productsList;
    }

    public SaveCaloriesToFile() {
    }

    public void saveToFile(List<Product> productList) throws IOException {

        String productListString = productList.stream()
                .map(product -> product.getProductName() + ":" + product.getNutrition().getCalories())
                .collect(Collectors.joining(","));
        productFileRepository.saveToFileRepository(productListString,address);
    }

    public void saveCaloriesValuePerDay(double calories) throws IOException {

        LocalDate localDate = LocalDate.now();


        CaloriesPerDay caloriesPerDay = new CaloriesPerDay(localDate,calories);


        String data = caloriesPerDay.getDate() + ":" + caloriesPerDay.getCaloriesSum() + "\n";
        productFileRepository.saveToFileRepository(data,address3);

    }

    public void saveEatenProductName(List<String> namesList) throws IOException {

        String productListString = namesList + ",";
        productFileRepository.saveToFileRepository(productListString,address2);
    }

}
