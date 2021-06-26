package Server;

import java.util.ArrayDeque;

public class HistoryManager {
    public static final int COMMAND_HISTORY_SIZE = 12;
    private ArrayDeque<String> commandHistory = new ArrayDeque<>(COMMAND_HISTORY_SIZE);

    public void addToHistory(String command) {
        commandHistory.addLast(command);
    }

    public String history() {
        StringBuilder history = new StringBuilder();
        for (String commandes : commandHistory) {
            if (!commandes.equals(null)) history.append(commandes).append("\n");
        }
        return history.toString();
    }
}
