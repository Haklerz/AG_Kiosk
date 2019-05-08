import java.util.Iterator;
import java.util.Scanner;

import Exceptions.InvalidAreaException; 

/**
 * Represents the RealestateApplication. The class is a delegate for the main
 * application and the menu-system. Any functions triggered by a menu selection
 * leads to a call to one of the methods in this class (via the
 * RealestateApplication interface).
 *
 * @author asty
 * @version 0.1
 */
public class RealestateApplicationImpl implements RealestateApplication
{
    private PropertyRegister propReg;
    @Override
    public void init()
    {
        this.propReg = new PropertyRegister();
        this.fillRegistersWithDataForTesting();
    }

    @Override
    public void doAddRealestatToRegister(){
        try{
            System.out.println("Please specify the name of the property");
            String name = scannerString();
            System.out.println("Please specify the municipality name;");
            String munName = scannerString();
            System.out.println("Please specify the municipality number;");
            int munNumber = scannerInt();
            System.out.println("Please specify the total area of the property;");
            Float area = scannerFloat();
            System.out.println("Please specify the lot number;");
            int lotNumber = scannerInt();
            System.out.println("Please specify the section number;");
            int secNumber = scannerInt();
            Owner owner = creatOwner();
            this.propReg.addProperty(new Property(munNumber, munName, lotNumber, secNumber, name, area, owner));
            System.out.println("Property " + name + " was added to the registry");
        }
        catch(InvalidAreaException e){
            System.out.println(e);
        }
    }

    public Owner creatOwner(){
        Owner owner = null;
        System.out.println("Please specify what type of owner (1 = person or 2 = company);");
        int typeOwner = this.scannerInt();
        if(typeOwner == 1){
            System.out.println("Please specify the social security number of the person:");
            String socialSecurityNumber = this.scannerString();
            System.out.println("Please specify the name of the owner:");
            String name = this.scannerString();
            System.out.println("Please specify the address of the owner:");
            String address = this.scannerString();
            owner = new Person(name, address, socialSecurityNumber);
        }
        else if(typeOwner == 2){
            System.out.println("Please specify the organisation number of the company:");
            String orgNumber = this.scannerString();
            System.out.println("Please specify the name of the owner:");
            String name = this.scannerString();
            System.out.println("Please specify the address of the owner:");
            String address = this.scannerString();
            owner = new Company(name, address, orgNumber);
        }
        return owner;
    }

    @Override
    public void doListAllRealestates() {
        Iterator<Property> propListIt = this.propReg.getIterator();

        printRegistryInfo(propListIt);
    }

    @Override
    public void doFindRealestate() {
        System.out.println("Please specify the municipalityNumber(101-5054);");
        int municipalityNumber = scannerInt();
        System.out.println("Please specify the Lot Number;");
        int lotNumber = scannerInt();
        System.out.println("Please specify the Section Number;");
        int secNumber = scannerInt();
        Iterator foundProp = this.propReg.findProperty(municipalityNumber, lotNumber, secNumber);

        printRegistryInfo(foundProp);
    }

    @Override
    public void doCalculateAverageRealestateArea() {
        System.out.println("The avarage area is " + this.propReg.getAvarageArea()
            + " m\u00B2");
    }

    /**
     * A helper method that fills the register(s) with some
     * data for testing purposes.
     */
    private void fillRegistersWithDataForTesting()
    {
        try{
            Owner holmCo = new Company("Holm & Co", "Fetsundgata 33", "123456");
            Owner frederik = new Company("Frederik Villumsen", "Sørumveien 19", "13039047547");
            Owner sivert = new Company("Sivert Høibråten", "Lwoodveg 37", "28129812345");
            this.propReg.addProperty(new Property(101, "Halden", 37, 1009, "Big Villa", 132.63f , frederik));
            this.propReg.addProperty(new Property(132, "Fetsund", 132, 8170, "D ghetto cottage", 30.2f , holmCo));
            this.propReg.addProperty(new Property(5054, "Indre Fossen", 89, 44, "Høibråten Stovner mansion", 217.3f , sivert));
        }
        catch(InvalidAreaException e){
            System.out.println(e);
        }
    }

    private float scannerFloat(){
        Scanner reader = new Scanner(System.in);
        Float input = reader.nextFloat();
        return input;
    }

    private int scannerInt(){
        Scanner reader = new Scanner(System.in);
        int input = reader.nextInt();
        return input;
    }

    private String scannerString(){
        Scanner reader = new Scanner(System.in);
        String input = reader.nextLine();
        return input;
    }

    public void printRegistryInfo(Iterator iterator){
        Iterator<Property> it = iterator;

        if(it.hasNext()){
            while(it.hasNext()){
                Property prop = it.next();

                System.out.print("\nName of Property: " + prop.getName()
                    + "\nName of Owner: " + prop.getOwner().getName()
                    + "\nArea: " + prop.getArea() + "m\u00B2\n");
            }
        }
        else{
            System.out.println("");
            System.out.println("There are no properties");
            System.out.println("");
        }
    }
}
