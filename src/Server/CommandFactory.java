package Server;

import Common.commands.AbstractCommand;
import Common.commands.Command;
import Common.exceptions.NoSuchCommandException;
import Server.commands.*;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    public final static Map<String, AbstractCommand> map = new HashMap<>();

    public CommandFactory(AddCommand addCommand, HelpCommand helpCommand, ShowCommand showCommand,
                          HistoryCommand historyCommand, InfoCommand infoCommand, SaveCommand saveCommand,ClearCommand clearCommand,
                          PrintDecendingBySemesterCommand printDecendingBySemesterCommand){
//                          AddIfMinCommand addIfMinCommand, ClearCommand clearCommand, ExecuteScript executeScript,
//                          ExitCommand exitCommand, FilterByFormOfEducationCommand filterByFormOfEducationCommand,
//                          HelpCommand helpCommand, History history, InfoCommand infoCommand, InsertAtCommand insertAtCommand,
//                          PrintDecendingBySemester printDecendingBySemester, RemoveByIdCommand removeByIdCommand,
//                          RemoveByStudentCount removeByStudentCount, SaveCommand saveCommand, ShowCommand showCommand,
//                          UpdateCommand updateCommand) {
        {
            map.put("ADD", addCommand);
//            map.put("ADD_IF_MIN", addIfMinCommand);
            map.put("CLEAR", clearCommand);
//            map.put("EXECUTE_SCRIPT", executeScript);
//            map.put("EXIT", exitCommand);
//            map.put("FILTER_GREATER_THAN_FORM_OF_EDUCATION", filterGreaterThatFormOfEducation);
            map.put("HELP", helpCommand);
            map.put("HISTORY", historyCommand);
            map.put("INFO", infoCommand);
//            map.put("INSERT_AT", insertAtCommand);
            map.put("PRINT_FIELD_DESCENDING_SEMESTER_ENUM", printDecendingBySemesterCommand);
//            map.put("REMOVE_BY_ID", removeByIdCommand);
//            map.put("REMOVE_ANY_BY_STUDENTS_COUNT", removeByStudentCount);
            map.put("SAVE", saveCommand);
            map.put("SHOW", showCommand);
//            map.put("UPDATE", updateCommand);
        }
    }

    public Command getCommand(String commandName) throws NoSuchCommandException {

        AbstractCommand command = map.get(commandName.toUpperCase());
        //check
        return command;
    }
}
