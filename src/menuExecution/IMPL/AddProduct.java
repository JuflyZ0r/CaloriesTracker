package menuExecution.IMPL;

import dao.GetProductInfoFromFile;
import menuExecution.Command;
import model.Nutrition;
import model.Product;
import repository.IMPL.ProductFileRepository;
import service.IMPL.ProductServiceImpl;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AddProduct implements Command {

    String address = "D:/out.txt";


    GetProductInfoFromFile getProductInfoFromFile = new GetProductInfoFromFile();
    ProductServiceImpl productService = new ProductServiceImpl();

    ProductFileRepository productFileRepository = new ProductFileRepository();

    String repositoryReturnLine = productFileRepository.readFromFileRepository(address);
    List<Product> productList = getProductInfoFromFile.getProductInfoFromFile(repositoryReturnLine);

    List<String> stringList = getProductInfoFromFile.getEatenProductDuringDay();
    @Override
    public void exec(Integer input) throws IOException {
        if(input.equals(1)) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введіть ім'я продукту: ");
            String productName = scanner.nextLine();
            System.out.println("Введіть значення калорій цього продукту");
            Double productCalories = scanner.nextDouble();

            productService.addNewProductToFileDb(productList,new Product(productName,new Nutrition(productCalories)));
        }
    }
}
