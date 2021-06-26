package Common.commandsToSend;

import java.io.Serializable;

public class SaveToSend extends CommandToSend implements Serializable {
    public SaveToSend() {
        super("SAVE");
    }
}
