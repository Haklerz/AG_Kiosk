package no.ntnu.ag;

import java.util.ArrayList;
import java.util.Iterator;

import no.ntnu.ag.literature.Literature;

/**
 * LiteratureCollection
 */
public class LiteratureCollection {
    private ArrayList<Literature> literatureList;

    public LiteratureCollection() {
    	this.literatureList = new ArrayList<>();
	}

	public void addLiterature(Literature literature) {
    	if (literature == null) {
			throw new IllegalArgumentException("literature to add must be non-null");
		}
    	else {
			this.literatureList.add(literature);
		}
	}

	public void removeLiterature(Literature literature) {
    	if (literature == null) {
    		throw new IllegalArgumentException("literature to remove must be non-null");
		}
		this.literatureList.remove(literature);
	}

	public Iterator<Literature> getLiteratureIterator() {
		return this.literatureList.iterator();
	}
}