package no.ntnu.ag;

import java.util.ArrayList;
import java.util.Iterator;

import no.ntnu.ag.literature.Literature;

/**
 * Represents a collection of literature.
 */
public class LiteratureCollection {
    private ArrayList<Literature> literatureList;

	/**
	 * Creates a literature collection.
	 */
    public LiteratureCollection() {
    	this.literatureList = new ArrayList<>();
	}

	/**
	 * Adds literature to the collection.
	 * @param literature
	 */
	public void addLiterature(Literature literature) {
    	if (literature == null) {
			throw new IllegalArgumentException("literature to add must be non-null");
		}
    	else {
			this.literatureList.add(literature);
		}
	}

	/**
	 * Removes literature from the collection.
	 * @param literature
	 */
	public void removeLiterature(Literature literature) {
    	if (literature == null) {
    		throw new IllegalArgumentException("literature to remove must be non-null");
		}
		this.literatureList.remove(literature);
	}

	/**
	 * Returns an iterator over the literature in the collection.
	 * @return an iterator over the literature in the collection
	 */
	public Iterator<Literature> getLiteratureIterator() {
		return this.literatureList.iterator();
	}
}