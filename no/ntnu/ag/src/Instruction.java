package no.ntnu.ag.src;

/**
 * Represents an instruction with a command and arguments.
 * <p>
 * With this class you can:
 * <ul>
 * <li>Create an instruction.
 * <li>Get the command of an instruciton.
 * <li>Get the arguments of an instruction.
 * </ul>
 */
public class Instruction {
    Command command;
    String arguments;

    /**
     * Parses and creates an istruction from a user input String.
     * If the String does not match any of the valid commands,
     * the command is set to UNNKNOWN. If the string does not have any
     * arguments the argument is set to and empty String<code>""</code>.
     * @param instructionString Instruction String.
     */
    public Instruction(Command command, String arguments) {
        this.command = command;
        this.arguments = arguments;
    }

    /**
     * Returns the command part of the instruction.
     * @return Command of the instruction.
     */
    public Command getCommand() {
        return this.command;
    }

    /**
     * Returns the argument part of the instruction.
     * @return Arguments of the instruciton.
     */
    public String getArguments() {
        return this.arguments;
    }
}