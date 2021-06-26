package Common;

import Common.collectionInfo.FormOfEducation;
import Common.collectionInfo.Semester;
import Common.collectionInfo.StudyGroup;

import java.io.Serializable;

public class Parameters implements Serializable {
    String args;
    String message;
    int intArgs;
    StudyGroup studyGroup;
    Semester semester;
    FormOfEducation formOfEducation;
    private static final long serialVersionUID = 47L;

    public Parameters() {
    }

    public String getArgs() {
        return args;
    }
    public void setArgs(String args) {
        this.args = args;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public int getIntArgs() {
        return intArgs;
    }
    public void setIntArgs(int args) {
        this.intArgs = intArgs;
    }

    public void setFormOfEducation(FormOfEducation formOfEducation) {
        this.formOfEducation = formOfEducation;
    }
    public FormOfEducation getFormOfEducation() {
        return formOfEducation;
    }

    public StudyGroup getStudyGroup() {
        return studyGroup;
    }
    public void setStudyGroup(StudyGroup studyGroup) {
        this.studyGroup = studyGroup;
    }

    public Semester getSemester() {
        return semester;
    }
    public void setSemester(Semester semester) {
        this.semester = semester;
    }
}
