package no.ntnu.ag.literature;

import no.ntnu.ag.exceptions.IllegalFieldException;
import no.ntnu.ag.exceptions.IllegalNumEditionsException;
import no.ntnu.ag.exceptions.IllegalPublisherException;
import no.ntnu.ag.exceptions.IllegalTitleException;

/**
 * Represents a journal with a title, a publisher and a number of editions per
 * year and a field.
 * @author Håkon "Haklerz" Lervik
 * @version 2019.3.25
 */
public class Journal extends Periodical {
    private String field;

    /**
     * Creates a journal with a title, a publisher and a number of editions per year
     * and a field.
     * @param title     the title
     * @param publisher the publisher
     * @param editions  the number of editions
     * @param field     the field
     */
    public Journal(String title, String publisher, int editions, String field) throws IllegalTitleException,
            IllegalPublisherException, IllegalNumEditionsException, IllegalFieldException {
        super(title, publisher, editions);
        this.setField(field);
    }

    /**
     * Returns the field of the journal.
     * @return the field
     */
    public String getField() {
        return field;
    }

    /**
     * Sets the field of the journal.
     * @param field the field to set
     */
    private void setField(String field) throws IllegalFieldException {
        if (field == null) {
            throw new IllegalFieldException("field must be non-null");
        }
        else if (field.trim().length() <= 0) {
            throw new IllegalFieldException("field must be non-empty");
        }
        else {
            this.field = field;
        }
    }
}