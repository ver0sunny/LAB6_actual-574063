package Common.commands;

public interface Command {
    String execute(String arg);
    String getName();
    String getDescription();
}
