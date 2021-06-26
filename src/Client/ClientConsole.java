package Client;

import Common.DataObjectToSend;
import Common.exceptions.NoSuchCommandException;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ClientConsole {

    private Scanner userInput;
    private CommandManager commandManager;
    private ClientManager clientManager;
    private DataObjectToSend dataObjectToSend;

    public ClientConsole(Scanner userInput, CommandManager commandManager, ClientManager clientManager, DataObjectToSend dataObjectToSend) {
        this.userInput = userInput;
        this.commandManager = commandManager;
        this.clientManager = clientManager;
        this.dataObjectToSend = dataObjectToSend;
    }

    public void serverMode() {
        java.lang.String[] command;
        try {
            do {
                command = (userInput.nextLine().trim() + " ").split(" ", 2);
                command[1] = command[1].trim();
                String commandName = command[0].toUpperCase();
                String commandArguments = command[1];
                dataObjectToSend.setName("COMMAND");
                switch (commandName) {
                    case ("ADD"):
                        String commandOutput = commandManager.execute(commandName, commandArguments);
                        dataObjectToSend.setCommandToSend(commandName);
                        dataObjectToSend.setArgs(commandOutput);
                        break;
                    case ("HELP"):
                    case ("SHOW"):
                    case ("HISTORY"):
                    case ("INFO"):
                    case ("SAVE"):
                    case ("CLEAR"):
                    case ("PRINT_FIELD_DESCENDING_SEMESTER_ENUM"):
                        dataObjectToSend.setCommandToSend(commandName);
                        dataObjectToSend.setArgs(commandArguments);
                        break;
//                    case ("PRINT_FIELD_DESCENDING_SEMESTER_ENUM"):
//                        if (commandArguments.equals("")) {
//                            ClientConsole.printerror("No filtering parameter provided or no such form of education exists, enter correct form of education");
//                            dataObjectToSend.setName("MISTAKE");
//                        }
//                        else {
//                            dataObjectToSend.setCommandToSend(commandName);
//                            dataObjectToSend.setArgs(commandArguments);
//                        }
//                        break;
                    default:
                        dataObjectToSend.setName("MISTAKE");
                        ClientConsole.printerror("No such command exist");
                }
                clientManager.send(dataObjectToSend);
                DataObjectToSend dataObjectToSend = clientManager.receive();
                switch (dataObjectToSend.getName()) {
                    case ("EXECUTED_COMMAND"):
                        ClientConsole.println(dataObjectToSend.getMessage());
                        break;
                    case ("FAIL"):
                        dataObjectToSend.getMessage();
                    case ("AWFUL_FAIL"):
                        ClientConsole.println("Something somewhere went wrong");
                }
            } while (true);
        } catch (NoSuchCommandException e) {
            ClientConsole.printerror("No such command exist, check the list of available commands by calling 'help' command");
        }
    }

    public static void print(Object someThing) {
        System.out.print(someThing);
    }

    public static void println(Object someThing) {
        System.out.println(someThing);
    }

    public static void printerror(Object someThing) {
        System.out.println("ERROR~ERROR ~ " + someThing);
    }

    @Override
    public String toString() {
        return "Console - works with output and input";
    }

}

