package Common.collectionInfo;

import java.io.Serializable;

public enum FormOfEducation implements Serializable {
    DEFAULT,
    DISTANCE_EDUCATION,
    FULL_TIME_EDUCATION,
    EVENING_CLASSES;

    public static String listAll() {
        StringBuilder listAll = new StringBuilder();
        for (FormOfEducation formOfEducation : values()) {
            listAll.append(formOfEducation.name()).append(" ");
        }
        String[] split = listAll.toString().split(" ");
        return new StringBuilder().append(split[1]).append(" ").append(split[2]).append(" ").append(split[3]).toString();
    }
    public FormOfEducation parse(String string) {
        String[] splitedEnum = listAll().split(" ");
        FormOfEducation formOfEducation = DEFAULT;
        if (string.equals(splitedEnum[0])) { formOfEducation = DISTANCE_EDUCATION; }
        else if (string.equals(splitedEnum[1])) { formOfEducation = FULL_TIME_EDUCATION; }
        else if (string.equals(splitedEnum[2])) { formOfEducation = EVENING_CLASSES; }
        return formOfEducation;
    }
}