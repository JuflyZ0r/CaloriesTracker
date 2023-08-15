import menuExecution.Command;
import menuExecution.IMPL.*;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class StartProgramWork {
    Scanner scanner = new Scanner(System.in);


    public void start() throws IOException {
        displayMenu();
        int choiceTheTask = scanner.nextInt();
        List<Command> commands = List.of(
                new AddProduct(),
                new ListOfAllProduct(),
                new AddEatenProduct(),
                new CalculatorCaloriesPerDay(),
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
