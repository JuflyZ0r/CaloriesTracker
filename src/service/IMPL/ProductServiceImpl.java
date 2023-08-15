package service.IMPL;

import dao.SaveCaloriesToFile;
import service.ProductService;
import model.Product;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    SaveCaloriesToFile saveCaloriesToFile = new SaveCaloriesToFile();
    @Override
    public void countCaloriesEatenDuringDay(List<Product> productList, List<String> namesList) throws IOException {
        double calorieSum = 0;
        for (String productName : namesList){
            for(Product product : productList){
                if(product.getProductName().equals(productName)){
                    calorieSum += product.getNutrition().getCalories();
                }else{
                    System.out.println("Продукт не існує в базі");
                }
            }
            
        }
        saveCaloriesToFile.saveCaloriesValuePerDay(calorieSum);
    }

    @Override
    public void addNewProductToFileDb(List<Product> productList ,Product product) throws IOException {

        List<String> namesList = new ArrayList<>();

        for (Product product1 : productList){
            namesList.add(product1.getProductName());
        }

        if(namesList.contains(product.getProductName())){
            System.out.println("Продукт з таким іменем існує");
        }else {
            productList.add(product);
            saveCaloriesToFile.saveToFile(productList);
        }

    }

    @Override
    public void addEatenProductName(List<String> namesList,String name) throws IOException {
        List<String> updatedList = namesList;
        updatedList.add(name);
        saveCaloriesToFile.saveEatenProductName(updatedList);

    }

    @Override
    public void printAllData(List<Product> productList) throws IOException {
        for(Product product : productList){
            System.out.println(product.getProductName() + " : " + product.getNutrition().getCalories());
        }


    }


}
