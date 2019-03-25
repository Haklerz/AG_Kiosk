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
    private String response;

    public Kiosk() {
        literatureRegistry = new LiteratureRegistry();
        literatureRegistry.fillDummies();
    }

    /**
     * Executes a request.
     * 
     * @param request the request to execute
     */
    

    private String list() {
        Iterator<Literature> literatureIterator = literatureRegistry.getLiteratureIterator();
        String response = "";
        if (literatureIterator.hasNext()) {
            while (literatureIterator.hasNext()) {
                Literature literature = literatureIterator.next();
                if (literature instanceof Book) {
                    response += getBookDetails((Book) literature);
                } else if (literature instanceof Periodical) {
                    response += getPeriodicalDetails((Periodical) literature);
                } else if (literature instanceof BookSeries) {
                    response += getBookSeriesDetails((BookSeries) literature);
                }
                if (literatureIterator.hasNext()) {
                    response += "\n";
                }
            }
        } else {
            response += "There is no literature in the registry";
        }
        return response;
    }

    private String remove(String argument) {
        return "Yeet";
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
        // String[] arguments = argument.split(" ", 2);
        // String searchType = arguments[0];
        // String searchText = (arguments.length > 1) ? arguments[1] : "";

        Instruction findInstruction = Instruction.parseInstruction(argument);
        String searchType = findInstruction.getCommand();
        String searchText = findInstruction.getArgument();

        String response = "Found following " + searchType + "s that contain " + searchText + ":";
        Iterator<Literature> foundLiterature = literatureRegistry.find(searchType, searchText);
        while (foundLiterature.hasNext()) {
            response += "\n" + foundLiterature.next().getDetails();
        }
        return response;
    }

    public String getResponse() {
        return this.response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}