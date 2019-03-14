
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Iterator;

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

    private BookRegistry bookRegistry;
    // The menu tha will be displayed. Please edit/alter the menu
    // to fit your application (i.e. replace "prodct" with "litterature"
    // etc.
    private String[] menuItems = {
        "1. List all products",
        "2. Add new product",
        "3. Find a product by name",
    };

    /**
     * Creates an instance of the ApplicationUI User interface. 
     */
    public ApplicationUI() 
    {
        this.bookRegistry = new BookRegistry();
        this.bookRegistry.fillDummies();
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
                int menuSelection = this.showMenu();
                switch (menuSelection) 
                {
                    case 1:
                        this.listAllProducts();
                        break;

                    case 2:
                        this.addNewProduct();
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
     * Displays the menu to the user, and waits for the users input. The user is
     * expected to input an integer between 1 and the max number of menu items. 
     * If the user inputs anything else, an InputMismatchException is thrown. 
     * The method returns the valid input from the user.
     *
     * @return the menu number (between 1 and max menu item number) provided by the user.
     * @throws InputMismatchException if user enters an invalid number/menu choice
     */
    private int showMenu() throws InputMismatchException 
    {
        System.out.println("\n**** Application v0.1 ****\n");
        // Display the menu
        for ( String menuItem : menuItems )
        {
            System.out.println(menuItem);
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
        System.out.println("init() was called");
    }

    /**
     * Lists all the products/literature in the register
     */
    void listAllProducts()
    {
        Iterator<Litteratur> bookListIt = this.bookRegistry.getIterator();
       
        printLitteraturInfo(bookListIt);
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
    void addNewProduct()
    {  
        System.out.println("Please add the title of the litteratur");
        Scanner reader = new Scanner(System.in);
        String title = reader.nextLine();
        
        System.out.println("Please add the author of the litteratur");
        String author = reader.nextLine();
         
        System.out.println("Please add the publisher of the litteratur");
        String publisher = reader.nextLine();
        
        System.out.println("Please add the genre of the litteratur");
        String genre = reader.nextLine();
                
        System.out.println("Please add the amout pages the litteratur has");
        int pages = reader.nextInt();
        
        Book book = new Book(author, publisher, pages, title, genre);
        this.bookRegistry.addLitteratur(book);
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
        
        Iterator<Book> foundBooksIt = this.bookRegistry.findLitteratur(type, text);
        
        printLitteraturInfo(foundBooksIt);
    }
    
    private void printLitteraturInfo(Iterator iterator){
        Iterator<Litteratur> it = iterator;
        
        if(it.hasNext()){
            while(it.hasNext() ){
                Litteratur lit = it.next();
                
                System.out.println();
                System.out.println("Title: " + lit.getTitle()
                    + " Author: " + lit.getAuthor()
                    + " Publisher: " + lit.getPublisher()
                    + " Pages: " + lit.getPages()
                    );
                System.out.println();
            }
        }
        
        else{
            System.out.println();
            System.out.println("There are no books registered.");
            System.out.println();
        }
    }
}
