package repository;

import model.Product;

import java.io.IOException;
import java.util.List;

public interface ProductRepository {

    void saveToFile(List<Product> productList) throws IOException;

    void saveCaloriesValuePerDay(double calories) throws IOException;

    void saveEatenProductName(List<String> namesList) throws IOException;

    List<Product> getProductInfoFromFile(String line);

    List<String> getEatenProductDuringDay();







}
