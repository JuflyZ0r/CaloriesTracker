package menuExecution.IMPL;

import dao.GetProductInfoFromFile;
import menuExecution.Command;
import repository.IMPL.ProductFileRepository;
import service.IMPL.ProductServiceImpl;
import model.Nutrition;
import model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CommandImpl implements Command {

    String address = "D:/out.txt";


    GetProductInfoFromFile getProductInfoFromFile = new GetProductInfoFromFile();
    ProductServiceImpl productService = new ProductServiceImpl();

    ProductFileRepository productFileRepository = new ProductFileRepository();

    String repositoryReturnLine = productFileRepository.readFromFileRepository(address);
    List<Product> productList = getProductInfoFromFile.getProductInfoFromFile(repositoryReturnLine);

    List<String> stringList = getProductInfoFromFile.getEatenProductDuringDay();
    @Override
    public void exec(Integer input) throws IOException {

        List<Integer> integerList = new ArrayList<>(Arrays.asList(1,2,3,4,5));

        for (Integer integer : integerList){
            System.out.println(integer);
        }

        switch (input){
            case 1:
                additionalProduct();
                break;
            case 2:
                productService.printAllData(productList);
                break;
            case 3:
                additionalEatenProductName();
                break;
            case 4:
                productService.countCaloriesEatenDuringDay(productList,stringList);
                break;
            case 5:
                System.exit(0);
        }


    }

    public void additionalProduct() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть ім'я продукту: ");
        String productName = scanner.nextLine();
        System.out.println("Введіть значення калорій цього продукту");
        Double productCalories = scanner.nextDouble();

        productService.addNewProductToFileDb(productList,new Product(productName,new Nutrition(productCalories)));
    }

    public void additionalEatenProductName() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть ім'я продукту: ");
        String productName = scanner.nextLine();
        productService.addEatenProductName(stringList,productName);

    }




}
