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
    private Book currentBook;

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
        System.out.println("Kiosk Interface v0.4");
        while(running) {
            this.printCursor();
            Instruction instruction = this.getInput();
            this.executeInstruction(instruction);
        }
    }

    /**
     * Executes an instruction.
     * 
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
                if (bookIterator.hasNext()) {
                    while(bookIterator.hasNext()) {
                        Book book = bookIterator.next();
                        this.printBook(book);
                        if (bookIterator.hasNext()) System.out.println();
                    }
                }
                else {
                    System.out.println("There are no books.");
                }
                break;
            
            case HELP:
                System.out.println("Commands:");
                for(Command commandWord : Command.values()) {
                    if (!commandWord.getCommandString().equals("?")) {
                        System.out.println(commandWord.getCommandString());
                    }
                }
                break;
            
            case NEW:
                System.out.print("Title     > ");
                String title = this.input.nextLine();
                System.out.print("Author    > ");
                String author = this.input.nextLine();
                System.out.print("Publisher > ");
                String publisher = this.input.nextLine();
                System.out.print("Pages     > ");
                int pages;
                try {
                    pages = Integer.parseInt(this.input.nextLine());
                }
                catch(NumberFormatException exception) {
                    pages = 0;
                }
                System.out.print("Edition   > ");
                int edition;
                try {
                    edition = Integer.parseInt(this.input.nextLine());
                }
                catch(NumberFormatException exception) {
                    edition = 0;
                }
                try {
                    this.bookRegistry.addBook(new Book(title, author, publisher, pages, edition));
                    System.out.println("Added book: " + title + ".");
                }
                catch(IllegalArgumentException exception) {
                    System.out.println("Invalid book.");
                    System.out.println(exception.getLocalizedMessage());
                }
                break;
            
            case FIND:
                Book book = this.bookRegistry.findBook(instruction.getArguments());
                if (book != null) {
                    this.printBook(book);
                    this.currentBook = book;
            } else {
                System.out.println("Could not find book.");
            }
            break;
        
        case REMOVE:
            if (this.currentBook != null) {
                System.out.println("Removed book: " + currentBook.getTitle() + ".");
                this.bookRegistry.removeBook(this.currentBook);
                this.currentBook = null;
            }
            break;

        case UNKNOWN:
            System.out.println("Command not recognized.");
            System.out.println("Type help for valid commands.");
            break;
        }
    }

    private void printCursor() {
        System.out.println();
        if (currentBook != null) {
            System.out.print(currentBook.getTitle());
        }
        System.out.print("> ");
    }

    private void printBook(Book book) {
        System.out.println("Title     : " + book.getTitle());
        System.out.println("Author    : " + book.getAuthor());
        System.out.println("Publisher : " + book.getPublisher());
        System.out.println("Pages     : " + book.getPages());
        System.out.println("Edition   : " + book.getEdition());
    }

    /**
     * Gets an instruction from the user.
     * @return Instruction from user.
     */
    private Instruction getInput() {
        String instructionString = this.input.nextLine();
        String[] components = instructionString.split(" ", 2);
        Command command = Command.UNKNOWN;
        String arguments = "";
        for (Command testCommand : Command.values()) {
            if (testCommand.getCommandString().equalsIgnoreCase(components[0])) {
                command = testCommand;
            }
        }
        if (components.length > 1) {
            arguments = components[1];
        }
        return new Instruction(command, arguments);
    }
}