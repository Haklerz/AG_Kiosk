package no.ntnu.ag;

/**
 * Represents a command in the user interface.
 * @author Håkon "Haklerz" Lervik
 */
public enum Command {
    HELP("help"), LIST("list"), FIND("find"), NEW("new"), MOVE("move"), QUIT("quit"), UNKNOWN("");

    private final String commandString;

    /**
     * Creates a command.
     * @param commandString
     */
    Command(String commandString) {
        this.commandString = commandString;
    }

    /**
     * Returns the command string.
     * @return the command string
     */
    public String getCommandString() {
        return this.commandString;
    }

    /**
     * Parses a command from a string.
     * @param string the string to parse
     * @return the command parsed
     */
    public static Command parseCommand(String string) {
        Command command = UNKNOWN;
        for (Command tryCommand : Command.values()) {
            if (tryCommand.getCommandString().equalsIgnoreCase(string)) {
                command = tryCommand;
            }
        }
        return command;
    }
}
