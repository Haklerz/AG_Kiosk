package no.ntnu.Litteratur;

import no.ntnu.Exception.IllegalPagesException;
import no.ntnu.Exception.IllegalAuthorException;
import no.ntnu.Exception.IllegalPublisherException;

/**
 * Represents a Book.
 * <p>
 * With this class you can:
 * <ul>
 * <li>Make a book.
 * <li>Get the author of the book.
 * <li>Get the title of the book.
 * <li>Get the publisher of the book.
 * <li>Get the amout of pages in the book.
 * </ul>
 * @author Trym Jorgensen
 * @version 2019.03.25
 */
public class Book extends Litteratur
{
    // The fields.
    // private String author;
    // private String title;
    // private int pages;
    // private String publisher;
    private String genre;
    private String author;
    private int pages;

    /**
     * Set the author and title fields when this object
     * is constructed.
     */
    public Book(String author, String publisher, int pages, String title, String genre) throws IllegalPagesException, IllegalAuthorException, IllegalPublisherException
    {
        super(publisher, title);
        this.setPages(pages);
        this.setGenre(genre);
        this.author = author;
        // this.author = author;
        // this.title = title;
        // this.pages = pages;
        // this.publisher = publisher;
    }

    /**
     * returns the books author
     * @return the author of the book
     */
    public String getGenre()
    {
        return this.genre;
    }

    /**
     * returns the books author
     * @return the author of the book
     */
    public String getAuthor()
    {
        return this.author;
    }
    
    /**
     * Sets the author of the book
     */
    public void setAuthor(String author)throws IllegalAuthorException{
        if(author == null){
            throw new IllegalAuthorException("String was null");
        }
        else if(author.trim() == ""){
            throw new IllegalAuthorException("Authors name cant be empty");
        }
        else{
            this.author = author;
        }
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    /**
     * sets the number of pages in the litteratur.
     */
    public void setPages(int pages) throws IllegalPagesException{
        if(pages<0){
            throw new IllegalPagesException("Pages cant be less than 0: " + pages);
        }
        else{
            this.pages = pages;
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
    // /**
    // * returns the books publisher
    // * @return the publisher of the book
    // */
    // public String getPublisher()
    // {
    // return this.publisher;
    // }

    // /**
    // * returns the books title
    // * @return the title of the book
    // */
    // public String getTitle()
    // {
    // return this.title; 
    // }

    // /**
    // * returns the amout of pages in the book
    // * @return the amount of pages in the book
    // */
    // public int getPages()
    // {
    // return this.pages;
    // }
}