package Client.commands;

import Client.ClientConsole;
import Common.InputAndVerifier;
import Common.collectionInfo.StudyGroup;
import Common.commands.AbstractCommand;
import Common.commands.Command;

import java.time.LocalDateTime;
import java.util.Objects;

public class AddCommand extends AbstractCommand implements Command {
    private InputAndVerifier inputAndVerifier;

    public AddCommand(InputAndVerifier inputAndVerifier) {
        super("add", "adds a new element to the collection");
        this.inputAndVerifier = inputAndVerifier;
    }

    @Override
    public String execute(String args) {
        StringBuilder studyGroup = new StringBuilder()
                .append(0).append(" ")
                .append(inputAndVerifier.askName()).append(" ")
                .append(LocalDateTime.now()).append(" ")

                .append(inputAndVerifier.askAdminName()).append(" ")
                .append(inputAndVerifier.askAdminHeight()).append(" ")
                .append(inputAndVerifier.askAdminWeight()).append(" ")
                .append(inputAndVerifier.askAdminPassportId()).append(" ")

                .append(inputAndVerifier.askX()).append(" ")
                .append(inputAndVerifier.askY()).append(" ")

                .append(inputAndVerifier.askStudentsCount()).append(" ")
                .append(inputAndVerifier.askShouldBeExpelled()).append(" ")
                .append(inputAndVerifier.askFormOfEducation()).append(" ")
                .append(inputAndVerifier.askSemester());
        ClientConsole.print("Study Group created successfully" + "\n");
        return studyGroup.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AddCommand that = (AddCommand) o;
        return Objects.equals(inputAndVerifier, that.inputAndVerifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), inputAndVerifier);
    }
}
