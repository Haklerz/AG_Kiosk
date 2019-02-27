package no.ntnu.ag.src;

public enum Command {
    QUIT("quit"),
    FIND("find"),
    NEW("new"),
    REMOVE("remove"),
    HELP("help"),
    UNKNOWN("?");

    private final String commandString;

    private Command(String commandString) {
        this.commandString = commandString;
    }

    public String getCommandString() {
        return this.commandString;
    }
}