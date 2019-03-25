package no.ntnu.ag;

import java.util.ArrayList;
import java.util.Iterator;
import no.ntnu.ag.literature.Literature;

//for the dummie fill method
import no.ntnu.ag.literature.*;

/**
 * Represents a collection of literature.
 * 
 * @see Literature
 * @version 2019.3.25
 * @author Håkon "Haklerz" Lervik
 */
public class LiteratureRegistry {
    private ArrayList<Literature> literatureList;

    public LiteratureRegistry() {
        literatureList = new ArrayList<>();
    }

    public void addLiterature(Literature literature) {
        if (literature != null) {
            literatureList.add(literature);
        }
    }

    public void removeLiterature(Literature literature) {
        literatureList.remove(literature);
    }

    public Iterator<Literature> getLiteratureIterator() {
        return literatureList.iterator();
    }

    public Iterator<Literature> findLiterature(String searchText) {
        ArrayList<Literature> foundLiterature = new ArrayList<>();
        for (Literature literature : literatureList) {
            String literatureDetails = literature.getTitle() + literature.getPublisher();
            if (literatureDetails.toLowerCase().contains(searchText.toLowerCase())) {
                foundLiterature.add(literature);
            }
        }
        return foundLiterature.iterator();
    }

    public void fillDummies() {
        addLiterature(new Book("The Hunger Games", "Scholastic Press", "Suzanne Collins", "First Edition"));
        addLiterature(new Book("Harry Potter and the Philosopher's Stone", "Bloomsbury Publishing", "J.K. Rowling",
                "1st Edition"));
        addLiterature(new Book("Harry Potter and the Chamber of Secrets", "Bloomsbury Publishing", "J.K. Rowling",
                "1st Edition"));
        addLiterature(new Book("Harry Potter and the Prisoner of Azkaban", "Bloomsbury Publishing", "J.K. Rowling",
                "1st Edition"));
        addLiterature(new Book("Harry Potter and the Goblet of Fire", "Bloomsbury Publishing", "J.K. Rowling",
                "1st Edition"));
        addLiterature(new Book("Harry Potter and the Order of the Phoenix", "Bloomsbury Publishing", "J.K. Rowling",
                "1st Edition"));
        addLiterature(new Book("Harry Potter and the Half-Blood Prince", "Bloomsbury Publishing", "J.K. Rowling",
                "1st Edition"));
        addLiterature(new Book("Harry Potter and the Deathly Hallows", "Bloomsbury Publishing", "J.K. Rowling",
                "1st Edition"));
        addLiterature(
                new Book("To Kill a Mockingbird", "Harper Perennial Modern Classics", "Harper Lee", "First Edition"));
        addLiterature(new Book("Pride and Prejudice", "Modern Library", "Jane Austen", "First Edition"));
        addLiterature(new Book("Twilight", "Little, Brown and Company", "Stephenie Meyer", "First Edition"));
        addLiterature(new Book("The Chronicles of Narnia", "HarperCollins", "C.S. Lewis", "Reissue Edition"));
        addLiterature(new Journal("Teknisk Ukeblad", "Teknisk Ukeblad Media", 11, "Technology"));
        addLiterature(new Magazine("KK", "Aller Media", 49, "Health and Lifestyle"));
        addLiterature(new Newspaper("Aftenposten", "Schibsted Norge", 52));
        addLiterature(new Newspaper("Dagbladed", "Aller Media", 52));
    }
}