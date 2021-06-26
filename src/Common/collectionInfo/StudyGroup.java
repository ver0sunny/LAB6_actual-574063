package Common.collectionInfo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class StudyGroup implements Serializable {

    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int studentsCount; //Значение поля должно быть больше 0
    private int shouldBeExpelled; //Значение поля должно быть больше 0
    private FormOfEducation formOfEducation; //Поле не может быть null
    private Semester semester; //Поле не может быть null
    private Person groupAdmin; //Поле не может быть null
    private static final long serialVersionUID = 42L;

    public StudyGroup(Integer id, String name, LocalDateTime creationDate, Person groupAdmin, Coordinates coordinates, int studentsCount, int shouldBeExpelled, FormOfEducation formOfEducation, Semester semester) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.studentsCount = studentsCount;
        this.shouldBeExpelled = shouldBeExpelled;
        this.groupAdmin = groupAdmin;
        this.semester = semester;
        this.formOfEducation = formOfEducation;
    }

    public int compareTo(StudyGroup groupObj) {
        return groupAdmin.compareTo(groupObj.getGroupAdmin());
    }

    public Integer getId() { return id; }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public int getStudentsCount() {
        return studentsCount;
    }

    public int getShouldBeExpelled() {
        return shouldBeExpelled;
    }

    public Person getGroupAdmin() { return groupAdmin; }

    public FormOfEducation getFormOfEducation() { return formOfEducation; }

    public Semester getSemester() { return semester; }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setStudentsCount(int studentsCount) {
        this.studentsCount = studentsCount;
    }

    public void setShouldBeExpelled(int shouldBeExpelled) {
        this.shouldBeExpelled = shouldBeExpelled;
    }

    public void setFormOfEducation(FormOfEducation formOfEducation) {
        this.formOfEducation = formOfEducation;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public void setGroupAdmin(Person groupAdmin) {
        this.groupAdmin = groupAdmin;
    }

    //разбить на отдельные строчки
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("*-{ ");
        sb.append(name);
        sb.append(" ");
        sb.append("information }-*");
        sb.append("\n");

        sb.append("Group Id – ");
        sb.append(id);
        sb.append("\n");

        sb.append("Group Name – ");
        sb.append(name);
        sb.append("\n");

        sb.append("Group Creation Date –- ");
        sb.append(creationDate);
        sb.append("\n");

        sb.append("Group Admin:");
        sb.append(groupAdmin);
        sb.append("\n");

        sb.append("Group Coordinates – ");
        sb.append(coordinates);
        sb.append("\n");

        sb.append("Students Count – ");
        sb.append(studentsCount);
        sb.append("\n");

        sb.append("Should Be Expelled...  ");
        sb.append(shouldBeExpelled);
        sb.append("\n");

        sb.append("Form Of Education - ");
        sb.append(formOfEducation);
        sb.append("\n");

        sb.append("Semester - ");
        sb.append(semester);
        sb.append("\n");

        sb.append("-*-*--*-*--*-*--*-*--*-*--*-*-");

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (o instanceof StudyGroup) {
            StudyGroup studyGroup = (StudyGroup) o;
            return studentsCount == studyGroup.studentsCount &&
                    shouldBeExpelled == studyGroup.shouldBeExpelled &&
                    Objects.equals(name, studyGroup.name) &&
                    Objects.equals(coordinates, studyGroup.coordinates) &&
                    Objects.equals(groupAdmin, studyGroup.groupAdmin);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, coordinates, studentsCount, shouldBeExpelled, groupAdmin);
    }
}

