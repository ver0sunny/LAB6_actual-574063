package Server.commands;

import Common.commands.AbstractCommand;
import Common.commands.Command;
import Server.HistoryManager;

public class HistoryCommand extends AbstractCommand implements Command {

    private HistoryManager historyManager;

    public HistoryCommand(HistoryManager historyManager) {
        super("history", "displays 12 previous commands with no argument(s)");
        this.historyManager = historyManager;
    }

    @Override
    public String execute(String arg) {
        return historyManager.history();
    }
}