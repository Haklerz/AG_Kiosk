
/**
 * Write a description of class Owner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Owner
{
    // instance variables - replace the example below with your own
    private String name;
    private String address;
    /**
     * Constructor for objects of class Owner
     */
    public Owner(String name, String address)
    {
        this.setName(name);
        this.setAddress(address);
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getAddress(){
        return this.address;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
}
