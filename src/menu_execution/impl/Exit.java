package menu_execution.impl;

import menu_execution.Command;

import java.io.IOException;

public class Exit implements Command {
    @Override
    public void exec(Integer input) throws IOException {
        if(!input.equals(5)) {
            return;
        }
        System.exit(0);
    }
}
