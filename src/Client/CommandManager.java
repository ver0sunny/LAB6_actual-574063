package Client;

import Common.InputAndVerifier;
import Common.exceptions.NoArgumentProvidedException;
import Common.exceptions.NoSuchCommandException;

public class CommandManager {

    private CommandFactory commandFactory;

    public CommandManager(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    public String execute(String commandName, String arg) throws NoSuchCommandException {
        try {
            String commandOutput = commandFactory.getCommand(commandName).execute(arg);
            return commandOutput;
        } catch (NoSuchCommandException e) {
            ClientConsole.printerror("No such command exists, check available commands" + commandFactory.getCommand("HELP").execute(""));
        }
        return null;
    }
}
