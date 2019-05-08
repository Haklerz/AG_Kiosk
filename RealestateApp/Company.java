
/**
 * Write a description of class Company here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Company extends Owner
{
    // instance variables - replace the example below with your ownprivate finale String orgNumber;
    private final String ORG_NUMBER;
    /**
     * Constructor for objects of class Company
     */
    public Company(String name, String address, String orgNumber)
    {
        super(name, address);
        this.ORG_NUMBER = orgNumber;
    }

    public String getOrgNumber(){
        return this.ORG_NUMBER;
    }
}
