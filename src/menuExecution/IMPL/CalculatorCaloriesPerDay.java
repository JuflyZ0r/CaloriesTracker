package menuExecution.IMPL;

import dao.GetProductInfoFromFile;
import menuExecution.Command;
import model.Product;
import repository.IMPL.ProductFileRepository;
import service.IMPL.ProductServiceImpl;

import java.io.IOException;
import java.util.List;

public class CalculatorCaloriesPerDay implements Command {

    String address = "D:/out.txt";


    GetProductInfoFromFile getProductInfoFromFile = new GetProductInfoFromFile();
    ProductServiceImpl productService = new ProductServiceImpl();

    ProductFileRepository productFileRepository = new ProductFileRepository();

    String repositoryReturnLine = productFileRepository.readFromFileRepository(address);
    List<Product> productList = getProductInfoFromFile.getProductInfoFromFile(repositoryReturnLine);

    List<String> stringList = getProductInfoFromFile.getEatenProductDuringDay();


    @Override
    public void exec(Integer input) throws IOException {
        if(input.equals(4)) {
            productService.countCaloriesEatenDuringDay(productList,stringList);
        }
    }
}
