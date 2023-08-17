package menu_execution.impl;


import dao.Configuration;
import dao.impl.ProductFileDAO;
import menu_execution.Command;
import model.Nutrition;
import model.Product;
import repository.IMPL.ProductFileRepository;
import service.IMPL.ProductServiceImpl;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AddProduct implements Command {


    private final ProductFileRepository productFileRepository;
    private final ProductServiceImpl productService;
    private final ProductFileDAO productFileDAO;
    private final String address;

    public AddProduct(ProductFileRepository productFileRepository, ProductServiceImpl productService,
                      ProductFileDAO productFileDAO, String address) {
        this.productFileRepository = productFileRepository;
        this.productService = productService;
        this.productFileDAO = productFileDAO;
        this.address = address;
    }



    @Override
    public void exec(Integer input) throws Exception {
        if(!input.equals(1)) {
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть ім'я продукту: ");
        String productName = scanner.nextLine();
        System.out.println("Введіть значення калорій цього продукту");
        Double productCalories = scanner.nextDouble();

        String repositoryReturnLine = productFileDAO.readFromFileRepository(address);
        List<Product> productList = productFileRepository.getProductInfoFromFile(repositoryReturnLine);

        try {
            productService.addNewProductToFileDb(productList,new Product(productName,new Nutrition(productCalories)));
        }
        catch (Exception productException){
            System.out.println(productException.getMessage());
        }
    }
}
