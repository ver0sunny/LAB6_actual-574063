package Common.commandsToSend;

import java.io.Serializable;

public class ShowToSend extends CommandToSend implements Serializable {
    public ShowToSend() {
        super("SHOW");
    }
}
