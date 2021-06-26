package Server.commands;

import Common.collectionInfo.FormOfEducation;
import Common.collectionInfo.Semester;
import Common.collectionInfo.StudyGroup;
import Common.commands.AbstractCommand;
import Common.commands.Command;
import Server.CollectionManager;
import Server.ServerConsole;

import java.time.LocalDateTime;
import java.util.Objects;

public class AddCommand extends AbstractCommand implements Command {
    private CollectionManager collectionManager;


    public AddCommand(CollectionManager collectionManager) {
        super("add", "adds a new element to the collection");
        this.collectionManager = collectionManager;
    }

    @Override
    public String execute(String args) {
        String[] splited = args.split(" ");
        FormOfEducation formOfEducation = FormOfEducation.DEFAULT;
        Semester semester = Semester.DEFAULT;
        StudyGroup studyGroup = new StudyGroup(
                collectionManager.generateId(),
                splited[1],
                LocalDateTime.parse(splited[2]),
                collectionManager.createAdmin(splited[3], Integer.parseInt(splited[4]), Integer.parseInt(splited[5]), splited[6]),
                collectionManager.createCoordinates(Float.parseFloat(splited[7]), Long.parseLong(splited[8])),
                Integer.parseInt(splited[9]),
                Integer.parseInt(splited[10]),
                FormOfEducation.valueOf(splited[11]),
                Semester.valueOf(splited[12]));
        collectionManager.addToCollection(studyGroup);
                ServerConsole.print("Study Group added successfully");
        return "Study Group added successfully";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AddCommand that = (AddCommand) o;
        return Objects.equals(collectionManager, that.collectionManager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), collectionManager);
    }
}
