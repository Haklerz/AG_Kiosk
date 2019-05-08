import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 */

public class PropertyRegister{
    private ArrayList<Property> properties;
    public PropertyRegister(){
        this.properties = new ArrayList<>();
    }

    /**
     * Adds a property to the register
     */
    public void addProperty(Property property){
        this.properties.add(property);
    }

    /**
     * returns an iterator of the arraylist
     * @return an iterator of the arraylist
     */
    public Iterator getIterator(){
        return this.properties.iterator();
    }

    /**
     * returns the size of the arraylist
     * @return the size of the arraylist
     */
    public int getSize(){
        return this.properties.size();
    }

    public float getAvarageArea(){
        float avarage = 0;
        if(this.properties.size() > 0){
            avarage = this.getSumOfArea()/this.getSize();
        }
        return avarage;
    }

    public float getSumOfArea(){
        float sum = 0;
        for(Property property : properties){
            sum += property.getArea();
        }
        return sum;
    }

    public Iterator findProperty(int municipalityNumber, int lotNumber, int secNumber) {
        ArrayList<Property> foundProperties = new ArrayList<>();
        for (Property testProperty : properties) {
            if (municipalityNumber == testProperty.getMunicipalityNumber()
            && testProperty.getLotNumber() == lotNumber
            && testProperty.getSectionNumber() == secNumber) {
                foundProperties.add(testProperty);
            }
        }
        return foundProperties.iterator();
    }
}