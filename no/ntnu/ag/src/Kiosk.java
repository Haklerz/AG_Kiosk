package no.ntnu.ag.src;

import java.util.Iterator;

/**
 * Kiosk
 * 
 * @version 13.03.2019
 * @author Håkon "Haklerz" Lervik
 */
public class Kiosk {
    private static final String[] validCommands = { "list", "help", "find", "remove" };
    private LiteratureRegistry literatureRegistry;

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
            Iterator<Literature> literatureIterator = literatureRegistry.getLiteratureIterator();
            if (literatureIterator.hasNext()) {
                while (literatureIterator.hasNext()) {
                    Literature literature = literatureIterator.next();
                    response += literature.getDetails();
                    if (literatureIterator.hasNext())
                        response += "\n";
                }
            } else {
                response += "There is no literature in the registry";
            }
            break;

        case "help":
            response = help();
            break;

        case "find":
            response = find(instruction.getArgument());
            break;

        case "remove":
            System.out.println("Are you sure?");
            if ("yes".contains(this.input.nextLine().toLowerCase())) {
                if (this.currentBook != null) {
                    System.out.println("Removed book: " + currentBook.getTitle() + ".");
                    this.bookRegistry.removeBook(this.currentBook);
                    this.currentBook = null;
                }
            } else {
                System.out.println("Book was not removed.");
            }
            break;

        default:
            response = unknownCommand();
            break;
        }
        return response;
    }

    private String unknownCommand() {
        return "Command not recognized.\nType help for valid commands.";
    }

    private String help() {
        String response = "Commands:";
        for (String commandWord : validCommands) {
            response += " " + commandWord;
        }
        return response;
    }

    private String find(String argument) {
        String[] arguments = argument.split(" ", 2);
        String searchType = arguments[0];
        String searchText = (arguments.length > 1) ? arguments[1] : "";

        String response = "Found following " + searchType + "s that contain " + searchText + ":";
        Iterator<Literature> foundLiterature = literatureRegistry.find(searchType, searchText);
        while (foundLiterature.hasNext()) {
            response += "\n" + foundLiterature.next().getDetails();
        }
        return response;
    }
}