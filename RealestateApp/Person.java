
/**
 * Write a description of class Person here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Person extends Owner
{
    // instance variables - replace the example below with your own
    private final String SOCIAL_SECURITY_NUMBER;
    /**
     * Constructor for objects of class Person
     */
    public Person(String name, String address, String socialSecurityNumber)
    {
        super(name, address);
        this.SOCIAL_SECURITY_NUMBER = socialSecurityNumber;
    }

    public String getSocialSecurityNumber(){
        return this.SOCIAL_SECURITY_NUMBER;
    }
}
