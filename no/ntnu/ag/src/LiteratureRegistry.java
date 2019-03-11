package no.ntnu.ag.src;

import java.util.ArrayList;
import java.util.Iterator;

public class LiteratureRegistry {
    private ArrayList<Literature> literatureList;

    public LiteratureRegistry() {
        this.literatureList = new ArrayList<>();
    }

    public void addLiterature(Literature literature) {
        if (literature != null) {
            this.literatureList.add(literature);
        } else {
            throw new NullPointerException();
        }
    }

    public void removeLiterature(Literature literature) {
        if (!this.literatureList.remove(literature)) {
            throw new NullPointerException();
        }
    }

    public Iterator<Literature> getLiteratureIterator() {
        return this.literatureList.iterator();
    }

    public Iterator<Literature> findContains(String searchType, String searchText) {
        ArrayList<Literature> foundLiterature = new ArrayList<>();
        for (Literature searchLiterature : this.literatureList) {
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
                throw new IllegalArgumentException();
            }
        }
        return foundLiterature.iterator();
    }

    public Literature findSimilarity(String searchType, String searchText) {
        Literature foundLiterature = null;
        double bestMatch = 0;
        for (Literature searchLiterature : this.literatureList) {
            double similarity = 0;
            switch (searchType) {
            case "title":
                similarity = Search.similarity(searchText, searchLiterature.getTitle());
                break;

            case "publisher":
                similarity = Search.similarity(searchText, searchLiterature.getPublisher());
                break;

            default:
                throw new IllegalArgumentException();
            }
            if (similarity > bestMatch) {
                bestMatch = similarity;
                foundLiterature = searchLiterature;
            }
        }
        return foundLiterature;
    }
}