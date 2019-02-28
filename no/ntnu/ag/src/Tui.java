package no.ntnu.ag.src;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Represents a Text-based User Interface.
 */
public class Tui {
    private Scanner input;
    private BookRegistry bookRegistry;
    private boolean running;

    /**
     * Creates an instance of the Tui class.
     */
    public Tui() {
        input = new Scanner(System.in);
        bookRegistry = new BookRegistry();
        bookRegistry.fillDummies();
    }

    /**
     * Starts the main logic loop of the Tui.
     */
    public void run() {
        this.running = true;
        while(running) {
            System.out.print("\n> ");
            Instruction instruction = this.getInput();
            this.executeInstruction(instruction);
        }
    }

    /**
     * Executes an instruction.
     * @param instruction Instructuion to execute.
     */
    private void executeInstruction(Instruction instruction) {
        Command command = instruction.getCommand();
        switch (command) {
            case QUIT:
                this.input.close();
                this.running = false;
                System.out.println("Bye-bye!");
                break;

            case LIST:
                Iterator<Book> bookIterator = this.bookRegistry.getBookIterator();
                while(bookIterator.hasNext()) {
                    Book book = bookIterator.next();
                    System.out.println(book.getTitle());
                }
                break;
            
            case HELP:
                System.out.println("Commands:");
                for(Command commandWord : Command.values()) {
                    System.out.println(commandWord.getCommandString());
                }
                break;
            
            case FIND:
                Book book = this.bookRegistry.findBook(instruction.getArguments());
                if (book != null) {
                    System.out.println(book.getTitle());
                }
                else {
                    System.out.println("Could not find book.");
                }
                break;
        
            default:
                System.out.println("Command not recognized.");
                System.out.println("Type help for valid commands.");
                break;
        }
    }

    /**
     * Gets an instruction from the user.
     * @return Instruction from user.
     */
    private Instruction getInput() {
        Instruction instruction = new Instruction(this.input.nextLine());
        return instruction;
    }
}