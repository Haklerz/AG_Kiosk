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
    	if (literature != null) {
			this.literatureList.add(literature);
		}
    	else {
    		throw new NullPointerException("literature was a null object");
		}
	}

	public void removeLiterature(Literature literature) {
		this.literatureList.remove(literature);
	}

	public Iterator<Literature> getLiteratureIterator() {
		return this.literatureList.iterator();
	}
}