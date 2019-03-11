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
}