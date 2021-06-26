package Common.collectionInfo;

import java.io.Serializable;

public enum Semester implements Serializable {
    DEFAULT,
    SECOND,
    FOURTH,
    FIFTH,
    SEVENTH,
    EIGHTH;

    public static String listAll() {
        StringBuilder listAll = new StringBuilder();
        for (Semester semester : values()) {
            listAll.append(semester.name()).append(" ");
        }
        String[] split = listAll.toString().split(" ");
        return new StringBuilder().append(split[1]).append(" ").append(split[2]).append(" ").append(split[3]).append(" ").append(split[4]).append(" ").append(split[5]).toString();
    }

    public Semester parse(String string) {
        String[] splitedEnum = listAll().split(" ");
        Semester semester = DEFAULT;
        if (string.equals(splitedEnum[0])) { semester = SECOND; }
        else if (string.equals(splitedEnum[1])) { semester = FOURTH; }
        else if (string.equals(splitedEnum[2])) { semester = FIFTH; }
        else if (string.equals(splitedEnum[3])) { semester = SEVENTH; }
        else if (string.equals(splitedEnum[4])) { semester = EIGHTH; }
        return semester;
    }
}
