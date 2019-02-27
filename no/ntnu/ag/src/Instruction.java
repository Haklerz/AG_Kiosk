package no.ntnu.ag.src;

/**
 * Instruction
 */
public class Instruction {
    Command command;
    String arguments;

    public Instruction(String instructionString) {
        String[] components = instructionString.split(" ", 2);
        this.command = Command.UNKNOWN;
        for (Command testCommand : Command.values()) {
            if (testCommand.getCommandString().equals(components[0])) {
                this.command = testCommand;
            }
        }
        this.arguments = components[1];
    }

    public Command getCommand() {
        return this.command;
    }

    public String getArguments() {
        return this.arguments;
    }
}