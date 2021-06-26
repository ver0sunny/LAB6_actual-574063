package Server.commands;

import Common.commands.AbstractCommand;
import Common.commands.Command;
import Server.CollectionManager;

import java.time.LocalDateTime;

public class InfoCommand extends AbstractCommand implements Command {

    private CollectionManager collectionManager;

    public InfoCommand(CollectionManager collectionManager) {
        super("info", "provides information on Collection");
        this.collectionManager = collectionManager;
    }

    @Override
    public String execute(String arg) {
        LocalDateTime creationTime = collectionManager.getCreationTime();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("--Collection information--").append("\n");
        stringBuilder.append("Collection type -- " + collectionManager.getCollection().getClass().getName()).append("\n");
        stringBuilder.append("Collection size -- " + collectionManager.getCollectionSize()).append("\n");
        stringBuilder.append("Collection creation date -- " + collectionManager.getCreationTime()).append("\n");
        return stringBuilder.toString();
    }
}