package menu_execution.impl;


import dao.impl.ProductFileDAO;
import menu_execution.Command;
import model.Product;
import repository.IMPL.ProductFileRepository;
import service.IMPL.ProductServiceImpl;

import java.io.IOException;
import java.util.List;

public class ListOfAllProduct implements Command {

    String address = "D:/out.txt";


    ProductFileRepository productFileRepository = new ProductFileRepository();
    ProductServiceImpl productService = new ProductServiceImpl();

    ProductFileDAO productFileDAO = new ProductFileDAO();

    String repositoryReturnLine = productFileDAO.readFromFileRepository(address);
    List<Product> productList = productFileRepository.getProductInfoFromFile(repositoryReturnLine);



    @Override
    public void exec(Integer input) throws IOException {
        if(!input.equals(2)) {
            return;
        }
        productService.printAllData(productList);
    }
}
