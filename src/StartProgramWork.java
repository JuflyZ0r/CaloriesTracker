import dao.Configuration;
import dao.impl.ProductFileDAO;
import menu_execution.Command;
import menu_execution.impl.*;
import repository.IMPL.ProductFileRepository;
import service.IMPL.ProductServiceImpl;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class StartProgramWork {

    Configuration configuration = new Configuration();

    List<String> stringList;
    String address;
    Scanner scanner = new Scanner(System.in);


    public void start() throws Exception {
        displayMenu();
        int choiceTheTask = scanner.nextInt();
        List<Command> commands = List.of(
                new AddProduct(
                        configuration.getProductFileRepository(),
                        configuration.getProductService(),
                        configuration.getProductFileDAO(),
                        configuration.getOutFileAddress()
                ),
                new ListOfAllProduct(),
                new AddEatenProduct(
                        configuration.getProductService(),
                        configuration.getStringList()
                ),
                new CalculatorCaloriesPerDay(
                     configuration.getRepositoryReturnLine(),
                     configuration.getProductList(),
                     configuration.getStringList(),
                     configuration.getProductService()
                ),
                new Exit(),
                new UnknownCommand()
        );

        for (Command command : commands) {
            command.exec(choiceTheTask);
        }

    }


    private void displayMenu() {
        System.out.println("\nОберіть дію: " +
                "\n1. Додати продукт " +
                "\n2. Список всіх продуктів " +
                "\n3. Додати з'їджений продукт " +
                "\n4. Калькулятор калорій за день" +
                "\n5. Вийти з програми");
    }

}
