package Server;

import Common.exceptions.NoArgumentProvidedException;
import Common.exceptions.NoSuchCommandException;

public class CommandManager {

    private CommandFactory commandFactory;
    private HistoryManager historyManager;

    public CommandManager(HistoryManager historyManager, CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
        this.historyManager = historyManager;
    }

    public String execute(String commandName, String arg) throws NoSuchCommandException {
        try {
            if (arg.equals(null)) throw new NoArgumentProvidedException();
            String commandOutput = commandFactory.getCommand(commandName).execute(arg);
            historyManager.addToHistory(commandName);
            ServerConsole.println(commandName + " executed successfully");
            return commandOutput;
        } catch (NoArgumentProvidedException e) {
            ServerConsole.printerror("No argument provided, check requirements " + commandFactory.getCommand(commandName).getName());
        } catch (NoSuchCommandException e) {
            ServerConsole.printerror("No such command exists, check available commands" + commandFactory.getCommand("HELP").execute(""));
        }
        return null;
    }
}
