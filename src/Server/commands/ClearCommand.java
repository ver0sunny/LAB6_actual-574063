package Server.commands;

import Common.commands.AbstractCommand;
import Common.commands.Command;
import Server.CollectionManager;

public class ClearCommand extends AbstractCommand implements Command {

    private CollectionManager collectionManager;

    public ClearCommand(CollectionManager collectionManager) {
        super("clear", "empties collection");
        this.collectionManager = collectionManager;
    }

    @Override
    public String execute(String args) {
        if (collectionManager.getCollectionSize() == 0) {
            return "This collection is already empty! Nothing to clear out";
        }
        collectionManager.clearCollection();
        return "Collection cleared! Now it's so empty... ( •́ ‸ • ̀)";
    }
}
