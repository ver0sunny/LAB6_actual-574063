package Client;

import Client.commands.AddCommand;
import Common.commands.AbstractCommand;
import Common.commands.Command;
import Common.exceptions.NoSuchCommandException;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    public final static Map<String, AbstractCommand> map = new HashMap<>();

    public CommandFactory(AddCommand addCommand){
//                          AddIfMinCommand addIfMinCommand, ClearCommand clearCommand, ExecuteScript executeScript,
//                          ExitCommand exitCommand, FilterByFormOfEducationCommand filterByFormOfEducationCommand,
//                          History history, InfoCommand infoCommand, InsertAtCommand insertAtCommand,
//                          PrintDecendingBySemester printDecendingBySemester, RemoveByIdCommand removeByIdCommand,
//                          RemoveByStudentCount removeByStudentCount, SaveCommand saveCommand, ShowCommand showCommand,
//                          UpdateCommand updateCommand) {
        {
            map.put("ADD", addCommand);
//            map.put("ADD_IF_MIN", addIfMinCommand);
//            map.put("EXECUTE_SCRIPT", executeScript);
//            map.put("EXIT", exitCommand);
//            map.put("FILTER_GREATER_THAN_FORM_OF_EDUCATION", filterByFormOfEducationCommand);
//            map.put("INSERT_AT", insertAtCommand);
//            map.put("REMOVE_BY_ID", removeByIdCommand);
//            map.put("REMOVE_ANY_BY_STUDENTS_COUNT", removeByStudentCount);
//            map.put("UPDATE", updateCommand);

        }
    }

    public Command getCommand(String commandName) throws NoSuchCommandException {

        AbstractCommand command = map.get(commandName.toUpperCase());
        //check
        return command;
    }
}
