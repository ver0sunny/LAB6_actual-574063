package Common.commandsToSend;

import java.io.Serializable;

public abstract class CommandToSend implements Serializable {
    private String name;

    CommandToSend(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(name).toString();
    }
}