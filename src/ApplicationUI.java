
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

    private LitteraturRegistry litRegistry;
    // The menu tha will be displayed. Please edit/alter the menu
    // to fit your application (i.e. replace "prodct" with "litterature"
    // etc.
    private String[] menuItems = {
        "1. List all litteratur",
        "2. Add new Litteratur",
        "3. Find a product by name",
    };
    
    private String[] menuTypes = {
        "1. Newspaper",
        "2. Book",
        "3. Magazine",
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
                int menuSelection = this.showMenu(menuItems);
                switch (menuSelection) 
                {
                    case 1:
                        this.listAllProducts();
                        break;

                    case 2:
                        this.addNewLitteratur();
                        break;
                        
                    case 3:
                        this.findProductByName();
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
    public void addNewLitteratur(){
        try 
        {
            int menuSelection = this.showMenu(menuTypes);
            switch (menuSelection) 
            {
                case 1:
                    this.addNewNewspaper();
                    break;

                case 2:
                    this.addNewBook();
                    break;   
                    
                case 3:
                    this.addNewMagazine();
                    break;

                case 4:
                    System.out.println("\nThank you for using Application v0.1. Bye!\n");
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
        System.out.println("\n**** Application v0.1 ****\n");
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
    private Litteratur addNewProduct()
    {  
        System.out.println("Please add the title of the litteratur");
        Scanner reader = new Scanner(System.in);
        String title = reader.nextLine();
         
        System.out.println("Please add the publisher of the litteratur");
        String publisher = reader.nextLine();
                
        System.out.println("Please add the amout pages the litteratur has");
        int pages = reader.nextInt();

        Litteratur litteratur = new Litteratur(publisher, pages, title);
        return litteratur;
    }

    /**
     * Adds a new book to the registry with the information gotten from the user
     */
    void addNewBook(){
        Scanner reader = new Scanner(System.in);
        Litteratur book1 = addNewProduct();
        System.out.println("Please add the genre of the book");
        String genre = reader.nextLine();
        
        System.out.println("Please add the author of the litteratur");
        String author = reader.nextLine();

        this.litRegistry.addLitteratur(new Book(author, book1.getPublisher(), book1.getPages(), book1.getTitle(), genre));
    }

    /**
     * Adds a new newspaper to the registry with the information gotten from the user
     */
    void addNewNewspaper(){
        Scanner reader = new Scanner(System.in);
        Litteratur newspaper1 = addNewProduct();
        System.out.println("Please add the amount of issues the newspaper has a year");
        int issues = reader.nextInt();

        this.litRegistry.addLitteratur(new Newspaper(newspaper1.getPublisher(), newspaper1.getPages(), newspaper1.getTitle(), issues));
    }
    
    /**
     * Adds a new magazine to the registry with the information gotten from the user
     */
    void addNewMagazine(){
        Scanner reader = new Scanner(System.in);
        Litteratur magazine1 = addNewProduct();
        System.out.println("Please add the amount of issues the magazine has a year");
        int issues = reader.nextInt();
        
        System.out.println("Please add the genre of the magazine");
        String genre = reader.nextLine();

        this.litRegistry.addLitteratur(new Magazine(magazine1.getPublisher(), magazine1.getPages(), magazine1.getTitle(), issues, genre));
    }
    
    /**
     * Find and display a product based on name (title).
     * As with the addNewProduct()-method, you have to
     * ask the user for the string (name/title/publisher)
     * to search for, and then use this string as input-
     * parameter to the method in the register-object.
     * Then, upon return from the register, you need
     * to print the details of the found item.
     */
    void findProductByName()
    {
        System.out.println("Please specify what you want to search for: (Author, Title or Publisher)");
        Scanner reader = new Scanner(System.in);
        String type = reader.nextLine();
        
        System.out.println("Please add searchtext");
        String text = reader.nextLine();
        
        Iterator<Book> foundBooksIt = this.litRegistry.findLitteratur(type, text);
        
        printLitteraturInfo(foundBooksIt);
    }
    
    private void printLitteraturInfo(Iterator iterator){
        Iterator<Litteratur> it = iterator;
        
        if(it.hasNext()){
            while(it.hasNext() ){
                Litteratur lit = it.next();
                
                System.out.println();
                System.out.println("Title: " + lit.getTitle()
                    + " Publisher: " + lit.getPublisher()
                    + " Pages: " + lit.getPages()
                    );
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
