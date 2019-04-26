package no.ntnu;



/**
 * The Main-class of the application. This class only holds the main()-method
 * to start the application.
 * 
 * @author asty
 * @version 1.0
 */
public class Main 
{
    /**
     * The main entry for the application.
     * @param args arguments provided during startup of the application
     */
    public static void main(String[] args)
    {
        try{
        ApplicationUI appUI = new ApplicationUI();
        appUI.start();
    }
    catch(Exception e){
        System.out.println("Sorry something went wrong, try again or call: 123 45 678");
    }
    }
}
