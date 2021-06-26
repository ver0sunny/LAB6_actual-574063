package Common.commands;

import Common.collectionInfo.StudyGroup;

public interface CommandStudyGr {
    StudyGroup execute(String arg);
    String getName();
    String getDescription();
}
