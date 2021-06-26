package Client;

import Client.commands.AddCommand;
import Common.DataObjectToSend;
import Common.InputAndVerifier;
import Common.Parameters;
import Common.Serializer;

import java.util.Scanner;

public class ClientRunner {
    public static void main(String[] args) {

        Serializer serializer = new Serializer();
        ConnectionBlock connectionChannel = new ConnectionBlock();
        ClientManager clientManager = new ClientManager(serializer, connectionChannel);

        Scanner userInput = new Scanner(System.in);
        InputAndVerifier inputAndVerifier = new InputAndVerifier(userInput);
        CommandFactory commandFactory = new CommandFactory(new AddCommand(inputAndVerifier));
        CommandManager commandManager = new CommandManager(commandFactory);

        ClientConsole clientConsole = new ClientConsole(userInput,commandManager,clientManager,new DataObjectToSend(new Parameters()));
        clientConsole.serverMode();



//        AddCommand addCommand = new AddCommand(inputAndVerifier);
//        String argume = new String();
//        argume = addCommand.execute(null);
//        dataObjectToSend.setArgs(argume);
//        dataObjectToSend.setName("command");
//        connectionChannel.send(serializer.serializeDataObjectToSend(dataObjectToSend));
//        byte[] b = connectionChannel.receive();
//        System.out.println(serializer.deserializeDataObjectToSend(b).getMessage());

//        dataObjectToSend.setName("message");
//        dataObjectToSend.setMessage("i love you, pls work");
//        connectionChannel.send(serializer.serializeDataObjectToSend(dataObjectToSend));
//        byte[] b = connectionChannel.receive();
//        System.out.println(serializer.deserializeDataObjectToSend(b).getMessage());
    }
}
