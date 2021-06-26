package Server.commands;

import Common.commands.AbstractCommand;
import Server.CommandFactory;
import Server.ServerConsole;

public class HelpCommand extends AbstractCommand {

    public HelpCommand() {
        super("help", "info on available commands");
    }

    @Override
    public String execute(String arg) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CommandFactory.map.get("ADD").toString()).append("\n");
//        ConsoleManager.println(CommandFactory.map.get("ADD_IF_MIN").toString());
        stringBuilder.append(CommandFactory.map.get("CLEAR").toString()).append("\n");
//        ConsoleManager.println(CommandFactory.map.get("EXECUTE_SCRIPT").toString());
//        ConsoleManager.println(CommandFactory.map.get("EXIT").toString());
//        stringBuilder.append(CommandFactory.map.get("FILTER_GREATER_THAN_FORM_OF_EDUCATION")).append("\n");
        stringBuilder.append(CommandFactory.map.get("HELP").toString()).append("\n");
        stringBuilder.append(CommandFactory.map.get("HISTORY").toString()).append("\n");
        stringBuilder.append(CommandFactory.map.get("INFO").toString()).append("\n");
//        ConsoleManager.println(CommandFactory.map.get("INSERT_AT").toString());
        stringBuilder.append(CommandFactory.map.get("PRINT_FIELD_DESCENDING_SEMESTER_ENUM").toString()).append("\n");
//        ConsoleManager.println(CommandFactory.map.get("REMOVE_BY_ID").toString());
//        ConsoleManager.println(CommandFactory.map.get("REMOVE_ANY_BY_STUDENTS_COUNT").toString());
        stringBuilder.append(CommandFactory.map.get("SAVE").toString()).append("\n");
        stringBuilder.append(CommandFactory.map.get("SHOW").toString()).append("\n");
//        ConsoleManager.println(CommandFactory.map.get("UPDATE").toString());
        return stringBuilder.toString();
    }
}