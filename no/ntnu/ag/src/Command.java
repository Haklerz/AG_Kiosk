package no.ntnu.ag.src;

/**
 * Reprisents a command.
 */
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

    /**
     * Returns the command String for comparing.
     */
    public String getCommandString() {
        return this.commandString;
    }
}