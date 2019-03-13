package no.ntnu.ag.src;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents a collection of literature.
 * @see Literature
 * @version 13.03.2019
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

    public Iterator<Literature> find(String searchType, String searchText) {
        ArrayList<Literature> foundLiterature = new ArrayList<>();
        for (Literature searchLiterature : literatureList) {
            switch (searchType) {
            case "title":
                if (searchLiterature.getTitle().toLowerCase().contains(searchText.toLowerCase())) {
                    foundLiterature.add(searchLiterature);
                }
                break;

            case "publisher":
                if (searchLiterature.getPublisher().toLowerCase().contains(searchText.toLowerCase())) {
                    foundLiterature.add(searchLiterature);
                }
                break;
            
            default:
                break;
            }
        }
        return foundLiterature.iterator();
    }

	public void fillDummies() {
	}
}