import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * Makes up the user interface (text based) of the application.
 * Responsible for all user interaction, like displaying the menu
 * and receiving input from the user.
 * 
 * @author asty
 * @version 1.0
 */
public class ApplicationUI 
{
    private static final int ADD_NEWSPAPER = 1;
    private static final int ADD_BOOK = 2;
    private static final int ADD_MAGAZINE = 3;
    
    
    private LitteraturRegistry litRegistry;
    // The menu tha will be displayed. Please edit/alter the menu
    // to fit your application (i.e. replace "prodct" with "litterature"
    // etc.
    private String[] menuItems = {
        "1. List all litteratur",
        "2. Add new Litteratur",
        "3. Find a litteratur",
    };
    
    private String[] menuTypes = {
        "1. Newspaper",
        "2. Book",
        "3. Magazine",
    };

    private String [] searchTypes = {
        "1. Title",
        "2. Author",
        "3. Publisher"
    };

    /**
     * Creates an instance of the ApplicationUI User interface. 
     */
    public ApplicationUI() 
    {
        this.litRegistry = new LitteraturRegistry();
    }

    /**
     * Starts the application by showing the menu and retrieving input from the
     * user.
     */
    public void start() 
    {
        this.init();

        boolean quit = false;

        while (!quit) 
        {
            try 
            {
                int menuSelection = this.showMenu(this.menuItems);
                switch (menuSelection) 
                {
                    case 1:
                        this.listAllProducts();
                        break;

                    case 2:
                        this.addNewLitteratur();
                        break;
                        
                    case 3:
                        this.findLitteratur();
                        break;

                    case 4:
                        System.out.println("\nThank you for using Application v0.1. Bye!\n");
                        quit = true;
                        break;

                    default:
                }
            } 
            catch (InputMismatchException ime) 
            {
                System.out.println("\nERROR: Please provide a number between 1 and " + this.menuItems.length + "..\n");
            }
        }        
        
    }

    /**
     * 
     */
    public void findLitteratur(){
        try{
            int menuSelection = this.showMenu(this.searchTypes);
            switch(menuSelection){
                case 1:
                    findLitteraturByTitle();
                    break;
                
                case 2:
                    findLitteraturByAuthor();
                    break;
                
                case 3:
                    findLitteraturByPublisher();
                    break;

                case 4:
                    System.out.println("\nPlease specify what you want to do!\n");
                    break;
            }
        }
        catch (InputMismatchException ime){
            System.out.println("\nERROR: Please provide a number between 1 and " + this.menuItems.length + "..\n");            
        }
    }

    /**
     * adds a new litteratur.
     */
    public void addNewLitteratur(){
        try 
        {
            int menuSelection = this.showMenu(this.menuTypes);
            switch (menuSelection) 
            {
                case 1:
                    this.addNewLitteratur(ADD_NEWSPAPER);
                    break;

                case 2:
                    this.addNewLitteratur(ADD_BOOK);
                    break;   
                    
                case 3:
                    this.addNewLitteratur(ADD_MAGAZINE);
                    break;

                case 4:
                    System.out.println("\nPlease specify what you want to do!\n");
                    break;

                default:
            }
        } 
        catch (InputMismatchException ime) 
        {
            System.out.println("\nERROR: Please provide a number between 1 and " + this.menuItems.length + "..\n");
        }   
    }
    
    /**
     * Displays the menu to the user, and waits for the users input. The user is
     * expected to input an integer between 1 and the max number of menu items. 
     * If the user inputs anything else, an InputMismatchException is thrown. 
     * The method returns the valid input from the user.
     *
     * @return the menu number (between 1 and max menu item number) provided by the user.
     * @throws InputMismatchException if user enters an invalid number/menu choice
     */
    private int showMenu(String [] menuChoices) throws InputMismatchException 
    {
        // Display the menu
        for ( String menuChoice : menuChoices ) 
        {
            System.out.println(menuChoice);
        }
        int maxMenuItemNumber = menuItems.length + 1;
        // Add the "Exit"-choice to the menu
        System.out.println(maxMenuItemNumber + ". Exit\n");
        System.out.println("Please choose menu item (1-" + maxMenuItemNumber + "): ");
        // Read input from user
        Scanner reader = new Scanner(System.in);
        int menuSelection = reader.nextInt();
        if ((menuSelection < 1) || (menuSelection > maxMenuItemNumber)) 
        {
            throw new InputMismatchException();
        }
        return menuSelection;
    }
    
    // ------ The methods below this line are "helper"-methods, used from the menu ----
    // ------ All these methods are made privat, since they are only used by the menu ---
    
    /**
     * Initializes the application.
     * Typically you would create the LiteratureRegistrer-instance here
     */
    private void init()
    {
        this.litRegistry.fillDummies();
        System.out.println("Dummies was made for testing");
        System.out.println("\n**** Application v0.1 ****\n");
    }

    /**
     * Lists all the products/literature in the register
     */
    void listAllProducts()
    {
        Iterator<Litteratur> litListIt = this.litRegistry.getIterator();
       
        printLitteraturInfo(litListIt);
    }

    
    /**
     * Add a new product/literature to the register.
     * In this method you have to add code to ask the
     * user for the necessary information you need to 
     * create an instance of the product, which you
     * then send as a parameter to the addNewspaper()-
     * method of the register.
     * Remember to also handle invalid input from the
     * user!!
     */
    private void addNewLitteratur(int type)
    {  
        System.out.println("Please add the title of the litteratur");
        Scanner reader = new Scanner(System.in);
        String title = reader.nextLine();
         
        System.out.println("Please add the publisher of the litteratur");
        String publisher = reader.nextLine();
                
        System.out.println("Please add the amout pages the litteratur has");
        int pages = reader.nextInt();
        
        reader.close();
        if(type == 1){ // adds a new newspaper
            Scanner reader1 = new Scanner(System.in);
            System.out.println("Please add the amount of issues the newspaper has a year");
            int issues = reader1.nextInt();

            this.litRegistry.addLitteratur(new Newspaper(publisher, pages, title, issues));
        }
        
        else if(type == 2){ //adds a new book
            Scanner reader2 = new Scanner(System.in);
            System.out.println("Please add the genre of the book");
            String genre = reader2.nextLine();
        
            System.out.println("Please add the author of the litteratur");
            String author = reader2.nextLine();

            this.litRegistry.addLitteratur(new Book(author, publisher, pages, title, genre));
        }
        
        else if(type == 3){ //adds a new litteratur
            Scanner reader3 = new Scanner(System.in);
            System.out.println("Please add the genre of the magazine");
            String genre = reader3.nextLine();
        
            System.out.println("Please add the amount of issues the magazine has a year");
            int issues = reader3.nextInt();

            this.litRegistry.addLitteratur(new Magazine(publisher, pages, title, issues, genre));
        }
    }

    // /**
     // * Adds a new book to the registry with the information gotten from the user
     // */
    // void addNewBook(){
        // Scanner reader = new Scanner(System.in);
        // System.out.println("Please add the genre of the book");
        // String genre = reader.nextLine();
        
        // System.out.println("Please add the author of the litteratur");
        // String author = reader.nextLine();

        // this.litRegistry.addLitteratur(new Book(author, book1.getPublisher(), book1.getPages(), book1.getTitle(), genre));
    // }

    // /**
     // * Adds a new newspaper to the registry with the information gotten from the user
     // */
    // void addNewNewspaper(){
        // Scanner reader = new Scanner(System.in);
        // System.out.println("Please add the amount of issues the newspaper has a year");
        // int issues = reader.nextInt();

        // this.litRegistry.addLitteratur(new Newspaper(newspaper1.getPublisher(), newspaper1.getPages(), newspaper1.getTitle(), issues));
    // }
    
    // /**
     // * Adds a new magazine to the registry with the information gotten from the user
     // */
    // void addNewMagazine(){
        // Scanner reader = new Scanner(System.in);
        // Litteratur magazine1 = addNewProduct();
        
        // System.out.println("Please add the genre of the magazine");
        // String genre = reader.nextLine();
        
        // System.out.println("Please add the amount of issues the magazine has a year");
        // int issues = reader.nextInt();

        // this.litRegistry.addLitteratur(new Magazine(magazine1.getPublisher(), magazine1.getPages(), magazine1.getTitle(), issues, genre));
    // }
    
    /**
    * Finds a litteratur by the authors name
    */
    void findLitteraturByAuthor()
    {  
        System.out.println("Please specify the name of the author");
        Scanner reader = new Scanner(System.in);
        String text = reader.nextLine();
        
        Iterator<Book> foundLitIt = this.litRegistry.findLitteratur("author", text);
        
        printLitteraturInfo(foundLitIt);
    }
    
    /**
    * Finds a litteratur by the publsihers name
    */
    void findLitteraturByPublisher()
    {  
        System.out.println("Please specify the name of the publisher");
        Scanner reader = new Scanner(System.in);
        String text = reader.nextLine();
        
        Iterator<Book> foundLitIt = this.litRegistry.findLitteratur("publisher", text);
        
        printLitteraturInfo(foundLitIt);
    }

    /**
      * Finds a littartur by the title
      */
    void findLitteraturByTitle()
    {
        System.out.println("Please specify the title of the book");
        Scanner reader = new Scanner(System.in);
        String text = reader.nextLine();
        
        Iterator<Book> foundLitIt = this.litRegistry.findLitteratur("title", text);
        
        printLitteraturInfo(foundLitIt);
    }
    
    /**
     * Prints the Litteratur
     * @param iterator iterator of the litteratur
     */
    private void printLitteraturInfo(Iterator iterator){
        Iterator<Litteratur> it = iterator;
        
        if(it.hasNext()){
            while(it.hasNext() ){
                Litteratur lit = it.next();
                
                System.out.println();
                System.out.print("Title: " + lit.getTitle()
                    + " Publisher: " + lit.getPublisher()
                    + " Pages: " + lit.getPages()
                    );
                    if(lit instanceof Book){
                        Book book1 = (Book) lit;
                        System.out.print(" Author: " + book1.getAuthor());
                    }
                    else if(lit instanceof Magazine){
                        Magazine mag1 = (Magazine) lit;
                        System.out.print(" Genre: " + mag1.getGenre()
                        + " Issues: " + mag1.getIssuesPerYear());
                    }
                    else if(lit instanceof Newspaper){
                        Newspaper new1 = (Newspaper) lit;
                        System.out.print(" Issues: " + new1.getIssuesPerYear());
                    }
                System.out.println();
                System.out.println();
            }
        }
        
        else{
            System.out.println();
            System.out.println("There are no litteraturs registered.");
            System.out.println();
        }
    }
}