package menu_execution.impl;


import dao.impl.ProductFileDAO;
import menu_execution.Command;
import repository.IMPL.ProductFileRepository;
import service.IMPL.ProductServiceImpl;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AddEatenProduct implements Command {


    private final ProductServiceImpl productService;

    private final List<String> stringList;

    public AddEatenProduct(ProductServiceImpl productService, List<String> stringList) {
        this.productService = productService;
        this.stringList = stringList;
    }



    @Override
    public void exec(Integer input) throws IOException {
        if(!input.equals(3)) {
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть ім'я продукту: ");
        String productName = scanner.nextLine();


        productService.addEatenProductName(stringList,productName);
    }
}
