package Server.commands;

import Common.commands.AbstractCommand;
import Common.commands.Command;
import Server.CollectionManager;

public class ShowCommand extends AbstractCommand implements Command {

    private CollectionManager collectionManager;

    public ShowCommand(CollectionManager collectionManager) {
        super("show","displays all collection elements");
        this.collectionManager = collectionManager;
    }

    @Override
    public String execute(String arg) {
        return collectionManager.toString();
    }
}