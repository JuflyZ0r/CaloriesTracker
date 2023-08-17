package service.IMPL;

import repository.IMPL.ProductFileRepository;
import service.ProductService;
import model.Product;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    ProductFileRepository productFileRepository = new ProductFileRepository();
    @Override
    public void countCaloriesEatenDuringDay(List<Product> productList, List<String> namesList) throws Exception {
        double calorieSum = 0;
        for (String productName : namesList){
            for(Product product : productList){
                if(productList.contains(productName)){
                    calorieSum += product.getNutrition().getCalories();
                }
                else{
                    throw new Exception("Такого продукта не існує");
                }
            }
            
        }
        productFileRepository.saveCaloriesValuePerDay(calorieSum);
    }

    @Override
    public void addNewProductToFileDb(List<Product> productList ,Product product) throws Exception {

        List<String> namesList = new ArrayList<>();

        for (Product product1 : productList){
            namesList.add(product1.getProductName());
        }

        if(namesList.contains(product.getProductName())){
            throw new Exception("Продукт з таким іменем існує");
        }else {
            productList.add(product);
            productFileRepository.saveToFile(productList);
        }

    }

    @Override
    public void addEatenProductName(List<String> namesList,String name) throws IOException {
        List<String> updatedList = namesList;
        updatedList.add(name);
        productFileRepository.saveEatenProductName(updatedList);

    }

    @Override
    public void printAllData(List<Product> productList) throws IOException {
        for(Product product : productList){
            System.out.println(product.getProductName() + " : " + product.getNutrition().getCalories());
        }


    }


}
