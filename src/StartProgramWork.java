import menuExecution.IMPL.CommandImpl;

import java.io.IOException;
import java.util.Scanner;

public class StartProgramWork {
    Scanner scanner = new Scanner(System.in);
    CommandImpl command = new CommandImpl();

    public void start() throws IOException {
        displayMenu();
        int choiceTheTask = scanner.nextInt();
        command.exec(choiceTheTask);

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
