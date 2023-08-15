package menuExecution.IMPL;

import menuExecution.Command;

import java.io.IOException;

public class Exit implements Command {
    @Override
    public void exec(Integer input) throws IOException {
        if(input.equals(5)) {
            System.exit(0);
        }
    }
}
