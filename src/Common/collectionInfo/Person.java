package Common.collectionInfo;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Integer height; //Поле может быть null, Значение поля должно быть больше 0
    private Integer weight; //Поле не может быть null, Значение поля должно быть больше 0
    private String passportID; //Длина строки должна быть не меньше 10, Строка не может быть пустой, Поле не может быть null
    private static final long serialVersionUID = 41L;

    public Person(String name, Integer height, Integer weight, String passportID) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.passportID = passportID;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {}

    public Integer getHeight() {
        return height;
    }
    public void setHeight(Integer height) {}

    public Integer getWeight() {
        return weight;
    }
    public void setWeight(Integer weight) {}

    public String getPassportID() {
        return passportID;
    }
    public void setPassportID(String passportID) {}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ").append(name);
        sb.append("\n");

        sb.append("------admin--info------");
        sb.append("\n");

        sb.append("height=");
        sb.append(height);
        sb.append("\n");

        sb.append("weight=");
        sb.append(weight);
        sb.append("\n");

        sb.append("PassportID=");
        sb.append(passportID);
        sb.append("\n");
        sb.append("-----------------------");

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (o instanceof Person) {
            Person person = (Person) o;
            return Objects.equals(name, person.name) &&
                    Objects.equals(height, person.height) &&
                    Objects.equals(weight, person.weight) &&
                    Objects.equals(passportID, person.passportID);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, height, weight, passportID);
    }

    public int compareTo(Person groupAdmin) {
        if (height == groupAdmin.getHeight()) {
            return 0;
        }
        if (height > groupAdmin.getHeight()) {
            return 1;
        }else return -1; // from great to little
    } //else return -1 -- from little to great
}
