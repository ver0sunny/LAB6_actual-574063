package Server.commands;

import Common.commands.AbstractCommand;
import Common.commands.Command;
import Server.CollectionManager;
import Server.ServerConsole;

public class SaveCommand extends AbstractCommand {

    private CollectionManager collectionManager;

    public SaveCommand(CollectionManager collectionManager) {
        super("save", "saves collection to a file");
        this.collectionManager = collectionManager;
    }

    @Override
    public String execute(String arg) {
        collectionManager.saveCollection();
        ServerConsole.println("Collection saved successfully");
        return "Collection saved successfully";
    }
}
