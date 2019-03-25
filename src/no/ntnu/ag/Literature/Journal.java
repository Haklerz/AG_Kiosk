package no.ntnu.ag.literature;

/**
 * Represents a journal with a title, a publisher and a number of editions per
 * year and a field.
 * 
 * @version 2019.3.25
 * @author Håkon "Haklerz" Lervik
 */
public class Journal extends Periodical {
    public String field;

    /**
     * Creates a journal with a title, a publisher and a number of editions per year
     * and a field.
     * 
     * @param title     the title
     * @param publisher the publisher
     * @param editions  the number of editions
     * @param field     the field
     */
    public Journal(String title, String publisher, int editions, String field) {
        super(title, publisher, editions);
        this.setField(field);
    }

    /**
     * Returns the field of the journal.
     * 
     * @return the field
     */
    public String getField() {
        return field;
    }

    /**
     * Sets the field of the journal.
     * 
     * @param field the field to set
     */
    private void setField(String field) {
        if (field.trim().length() > 0) {
            this.field = field;
        } else {
            this.field = "noField";
        }
    }
}