package Common.commandsToSend;

import java.io.Serializable;

public class ClearToSend extends CommandToSend implements Serializable {
    public ClearToSend() {
        super("CLEAR");
    }
}
