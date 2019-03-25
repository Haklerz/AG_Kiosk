
/**
 * Write a description of class Periodical here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Periodical extends Litteratur
{
    private int issuesPerYear;
    /**
     * Constructor for objects of class Periodical
     */
    public Periodical(String publisher, int pages, String title, int issues)
    {
        // initialise instance variables
        super(publisher, pages, title);
        this.issuesPerYear = issues; 
    }
    
     /**
     * returns the number of issues the newspaper has a year.
     * @return the number of issues.
     */
    public int getIssuesPerYear(){
        return this.issuesPerYear;
    }
    
}
