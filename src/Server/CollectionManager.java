package Server;

import Common.collectionInfo.Coordinates;
import Common.collectionInfo.FormOfEducation;
import Common.collectionInfo.Person;
import Common.collectionInfo.StudyGroup;
import Common.exceptions.CollectionIsEmptyException;
import Common.exceptions.NoSuchStudentsCountException;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Objects;

public class CollectionManager {
    private LinkedList<StudyGroup> studyGroupsCollection;
    private LocalDateTime creationTime;
    private final FileManager fileManager;

    public CollectionManager(FileManager fileManager) {
        this.fileManager = fileManager;
//        this.studyGroupsCollection = loadCollection();
    }

    public LinkedList<StudyGroup> getCollection() {
        return studyGroupsCollection;
    }

    public int getCollectionSize() {
        return studyGroupsCollection.size();
    }

    // sorts collection starting with the tallest admin
    public void sortCollection() {
        studyGroupsCollection.sort(StudyGroup::compareTo);
    }

    public void addToCollection(StudyGroup studyGroup) {
        studyGroupsCollection.add(studyGroup);
    }

    public void clearCollection() {
        studyGroupsCollection.clear();
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void saveCollection() {
        fileManager.writeToFile(studyGroupsCollection);
    }

    public LinkedList<StudyGroup> loadCollection() {
        studyGroupsCollection = fileManager.readFile();
        this.creationTime = LocalDateTime.now();
        return studyGroupsCollection;
    }


    public void remove(StudyGroup studyGroup) {
        studyGroupsCollection.remove(studyGroup);
    }

    public Person createAdmin(String name,Integer height,Integer weight,String passportId) {
        Person admin = new Person(name,height,weight,passportId);
        return admin;
    }

    public Coordinates createCoordinates(float x, long y) {
        Coordinates coordinates = new Coordinates(x,y);
        return coordinates;
    }

    public StudyGroup getFirst() {
        if (studyGroupsCollection.isEmpty()) return null;
        return studyGroupsCollection.getFirst();
    }

    public StudyGroup getLast() {
        if (studyGroupsCollection.isEmpty()) return null;
        return studyGroupsCollection.getLast();
    }

    public StudyGroup getById(Integer id) {
        if (studyGroupsCollection.isEmpty()) return null;
        for (StudyGroup studyGroup : studyGroupsCollection) {
            if (studyGroup.getId().equals(id)) return studyGroup;
        }
        return null;
    }

    public Integer generateId() {
        if (studyGroupsCollection.isEmpty()) return 1;
        return studyGroupsCollection.getLast().getId() + 1;
    }

    public void updateAllId() {
        int i = 0;
        for (StudyGroup studyGroup : studyGroupsCollection) {
            studyGroup.setId(i+1);
        }
    }

//    public void insertAt(Integer id) {
//        for (StudyGroup studyGroup : studyGroupsCollection) {
//            if (studyGroup.getId() == id) {
//
//            }
//        }
//    }

    public void removeById(Integer id) {
        try {
            if (studyGroupsCollection.isEmpty()) throw new CollectionIsEmptyException();
            studyGroupsCollection.removeIf(studyGroup -> studyGroup.getId().equals(id));
        }catch (CollectionIsEmptyException e) {
            ServerConsole.printerror("Collection is empty");
        }
    }

//    public StudyGroup getByStudentsCount(StudyGroup studyGr) throws CollectionIsEmptyException {
//        if (studyGroups.isEmpty()) throw new CollectionIsEmptyException();
//        for (StudyGroup studyGroup : studyGroups) {
//            if (studyGroup.getStudentsCount() == studyGr.getStudentsCount()) return studyGroup;
//        }
//        return null;
//    }

    public void removeByStudentsCount(int studyCount) {
        try {
            int theGroupsCount = 0;
            if (studyGroupsCollection.isEmpty()) throw new CollectionIsEmptyException();
            for (StudyGroup studyGroup : studyGroupsCollection) {
                if (studyGroup.getStudentsCount() == studyCount) {
                    theGroupsCount +=1;
                }
            }
            if (theGroupsCount == 0) throw new NoSuchStudentsCountException();
            studyGroupsCollection.removeIf(studyGroup -> studyGroup.getStudentsCount() == studyCount);
        } catch (CollectionIsEmptyException e) {
            ServerConsole.printerror("Collection is empty T-T");
        }catch (NoSuchStudentsCountException e) {
            ServerConsole.printerror("No groups with this many students found");
        }
    }

    public LinkedList<StudyGroup> greaterThanByFormOfEducation(FormOfEducation formOfEducation) throws CollectionIsEmptyException {
        if (studyGroupsCollection.isEmpty()) throw new CollectionIsEmptyException();
        LinkedList<StudyGroup> linkedList = new LinkedList<>();
        for (StudyGroup studyGroup : studyGroupsCollection) {
            if (studyGroup.getFormOfEducation().compareTo(formOfEducation) > 0) {
                linkedList.add(studyGroup);
                return linkedList;
            }
        }
        return null;
    }

    class SortDecendBySemester implements Comparator<StudyGroup> {
        public int compare(StudyGroup sG1, StudyGroup sG2) {
            if (sG1.getSemester() == sG2.getSemester()) {
                return 0;
            } else if (sG1.getSemester().compareTo(sG2.getSemester()) < 0) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public String decendBySemester() {
        studyGroupsCollection.sort(new SortDecendBySemester());
        return studyGroupsCollection.toString();
    }

    public String toString() {
        if (studyGroupsCollection.isEmpty()) {
            return "This collection is empty (｡•́︿•̀｡)";
        }
        StringBuilder info = new StringBuilder();
        for (StudyGroup studyGroup : studyGroupsCollection) {
            info.append(studyGroup).append("\n");
        }
        return info.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CollectionManager that = (CollectionManager) o;
        return Objects.equals(studyGroupsCollection, that.studyGroupsCollection) &&
                Objects.equals(creationTime, that.creationTime) &&
                Objects.equals(fileManager, that.fileManager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studyGroupsCollection, creationTime, fileManager);
    }
}

