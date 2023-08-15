package menuExecution;

import java.io.IOException;

public interface Command {

    void exec(Integer input) throws IOException;

}
