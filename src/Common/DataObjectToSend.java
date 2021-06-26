package Common;

import Common.collectionInfo.Semester;
import Common.collectionInfo.StudyGroup;
import Common.commandsToSend.*;
import Common.exceptions.NoSuchCommandException;
import Server.commands.ClearCommand;

import java.io.Serializable;

public class DataObjectToSend implements Serializable {
    private String name; //what i'm sending
    private CommandToSend commandToSend; //command name
    private Parameters params; //arguments/message/studyGroup
    private AddToSend addToSend = new AddToSend();
    private HelpToSend helpToSend = new HelpToSend();
    private HistoryToSend historyToSend = new HistoryToSend();
    private InfoToSend infoToSend = new InfoToSend();
    private SaveToSend saveToSend = new SaveToSend();
    private ShowToSend showToSend = new ShowToSend();
    private PrintDecendingBySemesterToSend printDecendingBySemesterToSend = new PrintDecendingBySemesterToSend();
    private ClearToSend clearToSend = new ClearToSend();
    private static final long serialVersionUID = 46L;

    public DataObjectToSend(Parameters params) {
        this.params = params;
    }

    public void clear() {
        name = null;
        commandToSend = null;
        params = null;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public CommandToSend getCommandToSend() {
        return commandToSend;
    }
    public void setCommandToSend(String commandName) {
        try {
            switch (commandName.toUpperCase()) {
                case "ADD":
                    commandToSend = addToSend;
                    break;
                case "HELP":
                    commandToSend = helpToSend;
                    break;
                case "HISTORY":
                    commandToSend = historyToSend;
                    break;
                case "INFO":
                    commandToSend = infoToSend;
                    break;
                case "SAVE":
                    commandToSend = saveToSend;
                    break;
                case "SHOW":
                    commandToSend = showToSend;
                    break;
                case "PRINT_FIELD_DESCENDING_SEMESTER_ENUM":
                    commandToSend = printDecendingBySemesterToSend;
                    break;
                case ("CLEAR"):
                    commandToSend = clearToSend;
                    break;

                default:
                    throw new NoSuchCommandException();
            }
        } catch (NoSuchCommandException e) {
            e.printStackTrace();
        }
    }

    public void setArgs(String args) {
        params.setArgs(args);
    }
    public String getArgs() {
        return params.getArgs();
    }

    public void setIntArgs(int args) {
        params.setIntArgs(args);
    }
    public int getIntArgs() {
        return params.getIntArgs();
    }

    public String getMessage() { return params.getMessage(); }
    public void setMessage(String message) { params.setMessage(message); }

    public void setStudyGroup(StudyGroup args) { params.setStudyGroup(args); }
    public StudyGroup getStudyGroup() { return params.getStudyGroup(); }

    public void setSemester(Semester sem) {
        params.setSemester(sem);
    }
    public Semester getSemester() {
        return params.getSemester();
    }
}


