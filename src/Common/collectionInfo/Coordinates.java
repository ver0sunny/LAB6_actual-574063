package Common.collectionInfo;

import java.io.Serializable;
import java.util.Objects;

public class Coordinates implements Serializable {
    private float x;
    private long y; //Значение поля должно быть больше -828
    private static final long serialVersionUID = 40L;

    public Coordinates(float x, long y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    @Override
    public String toString() {
        return "X=" + x + " Y=" + y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Float.compare(that.x, x) == 0 &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}