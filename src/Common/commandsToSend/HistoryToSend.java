package Common.commandsToSend;

import java.io.Serializable;

public class HistoryToSend extends CommandToSend implements Serializable {
    public HistoryToSend() {
        super("HISTORY");
    }
}
