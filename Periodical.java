
/**
 * Write a description of class Periodical here.
 *
 * @author Trym
 * @version 2019.03.25
 */
public class Periodical extends Litteratur
{
    private int pages;
    private int issuesPerYear;
    /**
     * Constructor for objects of class Periodical
     */
    public Periodical(String publisher, int pages, String title, int issues)
    {
        // initialise instance variables
        super(publisher, title);
        this.setPages(pages);
        this.setIssuesPerYear(issues);
    }
    
     /**
     * returns the number of issues the newspaper has a year.
     * @return the number of issues.
     */
    public int getIssuesPerYear(){
        return this.issuesPerYear;
    }
    
    /**
     * sets the number of issues per year the perodical has.
     */
    public void setIssuesPerYear(int issues){
        this.issuesPerYear = issues;
        if(issues<0){
            this.issuesPerYear = 1;
        }
    }  
        
    /**
     * sets the number of pages in the litteratur.
     */
    public void setPages(int pages){
        this.pages = pages;
        if(pages<0){
            this.pages = 1;
        }
    }
        
    /**
     * returns the amout of pages in the book.
     * @return the amount of pages in the book.
     */
    public int getPages()
    {
        return this.pages;
    }
}
