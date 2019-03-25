package no.ntnu.ag.src;

/**
 * Represents an instruction with a command and argument.
 */
public class Instruction {
    String command;
    String argument;

    /**
     * Creates an instruction object with a command and argument.
     * 
     * @param command  the command
     * @param argument the argument
     */
    public Instruction(String command, String argument) {
        setCommand(command);
        setArgument(argument);
    }

    /**
     * Parses a String to an instruction.
     * 
     * @param string String to parse
     * @return an instruction
     */
    public static Instruction parseInstruction(String string) {
        String[] parts = string.split(" ", 2);
        return new Instruction(parts[0], (parts.length > 1) ? parts[1] : "");
    }

    /**
     * Converts an instruction to a String.
     * 
     * @return a string representation of the instruction
     */
    public String toString() {
        return command + " " + argument;
    }

    /**
     * Returns the command of the instruction.
     * 
     * @return the command
     */
    public String getCommand() {
        return command;
    }

    /**
     * Sets the command of the instruction.
     * 
     * @param command the command to set
     */
    private void setCommand(String command) {
        this.command = command;
    }

    /**
     * Returns the argument of the instruction.
     * 
     * @return the argument
     */
    public String getArgument() {
        return argument;
    }

    /**
     * Sets the argument of the instruction.
     * 
     * @param argument the argument to set
     */
    private void setArgument(String argument) {
        this.argument = argument;
    }
}