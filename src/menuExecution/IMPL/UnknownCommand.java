package menuExecution.IMPL;

import menuExecution.Command;

import java.io.IOException;

public class UnknownCommand implements Command {
    @Override
    public void exec(Integer input) throws IOException {
        if(!input.equals(1) && !input.equals(2) && !input.equals(3) && !input.equals(4) && !input.equals(5)){
            System.out.println("Команда не зрозуміла");
        }
    }
}
