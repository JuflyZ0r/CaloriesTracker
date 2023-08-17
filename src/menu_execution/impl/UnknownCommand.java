package menu_execution.impl;

import menu_execution.Command;

import java.io.IOException;

public class UnknownCommand implements Command {
    @Override
    public void exec(Integer input) throws IOException {
        if (!support(input)) {
            System.out.println("Команда не зрозуміла");
        }
    }

    public boolean support(Integer input) {
        return !(input.equals(1) || input.equals(2) || input.equals(3) || input.equals(4) || input.equals(5));
    }
}
