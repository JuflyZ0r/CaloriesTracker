package menu_execution.impl;


import dao.impl.ProductFileDAO;
import menu_execution.Command;
import model.Product;
import repository.IMPL.ProductFileRepository;
import service.IMPL.ProductServiceImpl;
import service.ProductService;

import java.io.IOException;
import java.util.List;

public class CalculatorCaloriesPerDay implements Command {

    String repositoryReturnLine;

    List<Product> productList;

    List<String> stringList;

    ProductServiceImpl productService;



    public CalculatorCaloriesPerDay(String repositoryReturnLine, List<Product> productList, List<String> stringList, ProductServiceImpl productService) {
        this.repositoryReturnLine = repositoryReturnLine;
        this.productList = productList;
        this.stringList = stringList;
        this.productService = productService;
    }

    @Override
    public void exec(Integer input) throws Exception {
        if(!input.equals(4)) {
            return;
        }

        try {
            productService.countCaloriesEatenDuringDay(productList,stringList);
        }
        catch (Exception productNotFound){
            System.out.println(productNotFound.getMessage());
        }
    }
}
