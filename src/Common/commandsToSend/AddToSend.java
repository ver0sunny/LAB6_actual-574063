package Common.commandsToSend;

import java.io.Serializable;

public class AddToSend extends CommandToSend implements Serializable {
    public AddToSend() {
        super("ADD");
    }
}

