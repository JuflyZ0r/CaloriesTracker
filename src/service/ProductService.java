package service;

import model.Product;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    void countCaloriesEatenDuringDay(List<Product> productList,List<String> stringList) throws Exception;

    void addNewProductToFileDb(List<Product> productList ,Product product) throws Exception;

    void addEatenProductName(List<String> namesList,String name) throws IOException;

    void printAllData(List<Product> productList) throws IOException;

}
