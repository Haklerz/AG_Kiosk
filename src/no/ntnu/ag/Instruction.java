package no.ntnu.ag;

/**
 * Represents an instruction with a command and argument.
 * 
 * @version 2019.4.30
 * @author Håkon "Haklerz" Lervik
 */
public class Instruction {
    Command command;
    String argument;

    /**
     * Creates an instruction object with a command and argument.
     * 
     * @param command  the command
     * @param argument the argument
     */
    private Instruction(Command command, String argument) {
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
        Instruction instruction;
        if (string == null) {
            instruction = new Instruction(Command.UNKNOWN, "");
        }
        else {
            String[] parts = string.split(" ", 2);
            Command command = Command.parseCommand(parts[0]);
            String argument = (parts.length > 1) ? parts[1] : "";
            instruction = new Instruction(command, argument);
        }
        return instruction;
    }

    /**
     * Returns the command of the instruction.
     * 
     * @return the command
     */
    public Command getCommand() {
        return command;
    }

    /**
     * Sets the command of the instruction.
     * 
     * @param command the command to set
     */
    private void setCommand(Command command) {
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