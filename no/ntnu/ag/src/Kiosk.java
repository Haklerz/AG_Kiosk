package no.ntnu.ag.src;

import java.util.Iterator;

/**
 * Kiosk
 */
public class Kiosk {
    private LiteratureRegistry literatureRegistry;
    private Literature currentLiterature;

    public Kiosk() {
        literatureRegistry = new LiteratureRegistry();
        literatureRegistry.fillDummies();
    }

    /**
     * Executes a request.
     * 
     * @param request the request to execute
     */
    public String executeRequest(String request) {
        Instruction instruction = Instruction.parseInstruction(request);
        String response = "";
        switch (instruction.getCommand()) {
            case "list":
                response = "print|";
                Iterator<Literature> literatureIterator = literatureRegistry.getLiteratureIterator();
                if (literatureIterator.hasNext()) {
                    while(literatureIterator.hasNext()) {
                        Literature literature = literatureIterator.next();
                        response += literature.getDetails();
                        if (literatureIterator.hasNext()) response += "\n";
                    }
                }
                else {
                    response += "There is no literature in the registry";
                }
                break;
            
            case "help":
                System.out.println("Commands:");
                for(Command commandWord : Command.values()) {
                    if (!commandWord.getCommandString().equals("?")) {
                        System.out.println(commandWord.getCommandString());
                    }
                }
                break;
            
            case "new":
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
            
            case "find":
                String[] arguments = instruction.getArguments().split(" ", 2);
                String searchType = arguments[0];
                String searchString = (arguments.length > 1) ? arguments[1] : "";
                try {
                    Book book = this.bookRegistry.findBook(searchType, searchString);
                    if (book != null) {
                        this.printBook(book);
                        this.currentBook = book;
                    } else {
                        System.out.println("Could not find book.");
                    }
                }
                catch(IllegalArgumentException exception) {
                    System.out.println("You need to spesify what to search by.");
                }
                
            break;
        
        case "remove":
            System.out.println("Are you sure?");
            if ("yes".contains(this.input.nextLine().toLowerCase())) {
                if (this.currentBook != null) {
                    System.out.println("Removed book: " + currentBook.getTitle() + ".");
                    this.bookRegistry.removeBook(this.currentBook);
                    this.currentBook = null;
                }
            }
            else {
                System.out.println("Book was not removed.");
            }
            break;

        default:
            System.out.println("Command not recognized.");
            System.out.println("Type help for valid commands.");
            break;
        }
    }
}