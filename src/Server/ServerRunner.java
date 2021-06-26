package Server;

import Server.commands.*;
import Common.InputAndVerifier;
import Common.Serializer;

import java.util.Scanner;

public class ServerRunner {
    public static void main(String[] args) {
        System.setProperty("fileName", "groupsCollection.json");

        System.setProperty("scriptName", "commandScript.txt");

        Serializer serializer = new Serializer();
        ConnectionBlock connectionBlock = new ConnectionBlock(serializer);
        Scanner userInput = new Scanner(System.in);
        InputAndVerifier inputAndVerifier = new InputAndVerifier(userInput);

        FileManager fileManager = new FileManager(System.getProperty("fileName"));
        CollectionManager collectionManager = new CollectionManager(fileManager);
        collectionManager.loadCollection();

        HistoryManager historyManager = new HistoryManager();
        CommandFactory commandFactory = new CommandFactory(new AddCommand(collectionManager),new HelpCommand(),new ShowCommand(collectionManager),
                                        new HistoryCommand(historyManager),new InfoCommand(collectionManager),new SaveCommand(collectionManager),
                                        new ClearCommand(collectionManager),new PrintDecendingBySemesterCommand(collectionManager));
        CommandManager commandManager = new CommandManager(historyManager,commandFactory);
        ServerManager serverManager = new ServerManager(commandManager,serializer,connectionBlock);

        ServerConsole serverConsole = new ServerConsole(commandManager,serverManager);
        serverConsole.serverMode();





//        byte[] b = connectionBlock.receive();
//        DataObjectToSend dataObjectToSend = serializer.deserializeDataObjectToSend(b);
//        if (dataObjectToSend.getName().toUpperCase().equals("COMMAND")) System.out.println(dataObjectToSend.getArgs());
//        String[] stringStudyGroup = dataObjectToSend.getArgs().split(" ");
//        AddCommand addCommand = new AddCommand(collectionManager);
//        addCommand.execute(dataObjectToSend.getArgs());
//        dataObjectToSend.setMessage(stringStudyGroup[1]);
//        connectionBlock.send(serializer.serializeDataObjectToSend(dataObjectToSend));

//        dataObjectToSend.setMessage("i love u too we work well together <3");
//        connectionChannel.send(serializer.serializeDataObjectToSend(dataObjectToSend));
    }
}
