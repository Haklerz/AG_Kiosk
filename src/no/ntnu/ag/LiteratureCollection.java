package no.ntnu.ag;

import java.util.ArrayList;
import java.util.Iterator;

import no.ntnu.ag.literature.Literature;

/**
 * LiteratureCollection
 */
public class LiteratureCollection {
    private ArrayList<Literature> literatureList;

	public void addLiterature(Literature literature) {
		this.literatureList.add(literature);
	}

	public void removeLiterature(Literature literature) {
		this.literatureList.remove(literature);
	}

	public Iterator<Literature> getLiteratureIterator() {
		return this.literatureList.iterator();
	}

	public Iterator<Literature> findLiterature(String searchText) {
        return null;
	}
    
}