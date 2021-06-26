package Server.commands;

import Common.collectionInfo.FormOfEducation;
import Common.collectionInfo.StudyGroup;
import Common.commands.AbstractCommand;
import Common.commands.Command;
import Common.exceptions.CollectionIsEmptyException;
import Server.CollectionManager;
import Server.ServerConsole;

import java.util.LinkedList;

public class PrintDecendingBySemesterCommand extends AbstractCommand implements Command {

    private CollectionManager collectionManager;

    public PrintDecendingBySemesterCommand(CollectionManager collectionManager) {
        super("print_field_descending_semester_enum", "displays field semesterEnum of all elements in descending order");
        this.collectionManager = collectionManager;
    }

    @Override
    public String execute(String arg) {
        StringBuilder stringBuilder = new StringBuilder();
        for (StudyGroup studyGroup : collectionManager.getCollection()) {
            stringBuilder.append(studyGroup.getName()).append(" ").append(studyGroup.getSemester()).append("\n");
        }
        return stringBuilder.toString();

    }
}
