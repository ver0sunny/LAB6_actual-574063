package Server;

import Common.DataObjectToSend;
import Common.Serializer;
import Common.exceptions.NoSuchCommandException;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ServerConsole {
    private CommandManager commandManager;
    private ServerManager serverManager;

    public ServerConsole(CommandManager commandManager, ServerManager serverManager) {
        this.commandManager = commandManager;
        this.serverManager = serverManager;
    }

    public void serverMode() {
        try {
            do {
                DataObjectToSend dataObjectToSend = serverManager.receive();
                switch (dataObjectToSend.getName()) {
                    case ("COMMAND"):
                        String commandName = dataObjectToSend.getCommandToSend().getName();
                        String commandArgs = dataObjectToSend.getArgs();
                        String commandOutput = new String();
                        switch (commandName) {
                            case ("ADD"):
                            case ("HELP"):
                            case ("HISTORY"):
                            case ("SAVE"):
                            case ("SHOW"):
                            case ("INFO"):
                            case ("CLEAR"):
                            case ("PRINT_FIELD_DESCENDING_SEMESTER_ENUM"):
                                commandOutput = commandManager.execute(commandName,commandArgs);
                                dataObjectToSend.setName("EXECUTED_COMMAND");
                                dataObjectToSend.setMessage(commandOutput);
                                break;

//                            case ("FILTER_GREATER_THAN_FORM_OF_EDUCATION"):
//                                commandOutput = commandManager.execute(commandName,commandArgs);
//                                if (commandOutput.equals("Collection is empty T-T")) dataObjectToSend.setName("FAIL");
//                                dataObjectToSend.setMessage(commandOutput);
//                                break;
                        }
                        break;
                    case ("MISTAKE"):
                        ServerConsole.printerror("Client mistake");
                }
                serverManager.send(dataObjectToSend);
            } while (true);
        } catch (NoSuchElementException exception) {
            ServerConsole.printerror("No user input detected");
        } catch (IllegalStateException exception) {
            ServerConsole.printerror("Something unexpected went wrong");
        } catch (NoSuchCommandException e) {
            ServerConsole.printerror("No such command found");
        }
    }

    public static void print(Object someThing) {
        System.out.print("Server Message ~ " + someThing);
    }
    public static void println(Object someThing) {
        System.out.println("Server Message ~ " + someThing);
    }
    public static void printerror(Object someThing) {
        System.out.println("Server Message ~ " + "ERROR~ERROR ~ " + someThing);
    }

    @Override
    public String toString() {
        return "Console - works with output and input";
    }

}
