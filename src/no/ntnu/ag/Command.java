package no.ntnu.ag;

/**
 * new list find add remove
 * @author Håkon "Haklerz" Lervik
 */
public enum Command {
    LIST("list"),
    FIND("find"),
    MOVE("move"),
    QUIT("quit"),
    UNKNOWN("");
    
    private final String commandString;
    
    private Command(String commandString) {
        this.commandString = commandString;
    }
    
    private String getCommandString() {
        return this.commandString;
    }

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
