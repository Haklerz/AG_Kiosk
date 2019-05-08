import Exceptions.InvalidAreaException; 

/**
 * Represents a Property.
 * <p>
 * With this class you can:
 * <ul>
 * <li>Make a Property.
 * <li> Get the propertys municipality Number
 * <li> Get the propertys municipality Name
 * <li> Get the propertys Lot Number
 * <li> Get the propertys Section Number
 * <li> Get the propertys name
 * <li> Get the propertys area in m^2
 * <li> Get the propertys owner
 * </ul>
 * <br>
 * @author Trym Jorgensen
 * @version 2019.04.29
 */
public class Property
{
    private int municipalityNumber;
    private String municipalityName;
    private int lotNumber;
    private int sectionNumber;
    private String name;
    private float area;     // in m^2
    private Owner owner;
    /**
     * Constructor for objects of class Property
     */
    public Property(int munNumber, String munName, int lotNumber, int secNumber, String name, float area, Owner owner) throws InvalidAreaException
    {
        this.setMunicipalityNumber(munNumber);
        this.setMunicipalityName(munName);
        this.setLotNumber(lotNumber);
        this.setSectionNumber(secNumber);
        this.setName(name);
        this.setArea(area);
        this.owner = owner;
    }

    /**
     * returns the municipalityNumber
     * @return the municipalityNumber
     */
    public int getMunicipalityNumber() {
        return municipalityNumber;
    }

    /**
     * sets the municipalityNumber of the property
     * @param municipalityNumber the municipalityNumber to set
     */
    public void setMunicipalityNumber(int municipalityNumber) {
        if(municipalityNumber > 100 && municipalityNumber < 5055){
            this.municipalityNumber = municipalityNumber;
        }
        else{
            // throw
        }
    }

    /**
     * returns the municipalityName
     * @return the municipalityName
     */
    public String getMunicipalityName() {
        return municipalityName;
    }

    /**
     * sets the municipalityName of the property
     * @param municipalityName the municipalityName to set
     */
    public void setMunicipalityName(String municipalityName) {
        if(municipalityName == null){
            // throw 
        }
        else if(municipalityName == ""){
            // throw
        }
        else{
            this.municipalityName = municipalityName;
        }
    }

    /**
     * returns the lotNumber
     * @return the lotNumber
     */
    public int getLotNumber() {
        return lotNumber;
    }

    /**
     * sets the lotNumber of the property
     * @param lotNumber the lotNumber to set
     */
    public void setLotNumber(int lotNumber) {
        if(lotNumber < 0){
            //throw
        }
        else{
            this.lotNumber = lotNumber;
        }
    }

    /**
     * returns the sectionNumber of the property
     * @return the sectionNumber
     */
    public int getSectionNumber() {
        return sectionNumber;
    }

    /**
     * sets the sectionNumber of the property
     * @param sectionNumber the sectionNumber to set
     */
    public void setSectionNumber(int sectionNumber) {
        if(sectionNumber < 0){
            //throw
        }
        else{
            this.sectionNumber = sectionNumber;
        } 
    }

    /**
     * returns the name of the property
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name of the property
     * @param name the name to set
     */
    public void setName(String name) {
        if(name == null){
            //throw
        }
        else if (name == ""){
            //throw
        }
        else{
            this.name = name;
        }
    }

    /**
     * returns the area of the property
     * @return the area
     */
    public float getArea() {
        return area;
    }

    /**
     * sets the area of the property
     * @param area the area to set
     */
    public void setArea(float area) throws InvalidAreaException {
        if(area < 0){
            throw new InvalidAreaException("Area can´t be less than 0, Your input was: " + area);
        }
        else{
            this.area = area;
        }
    }

    /**
     * returns the owner of the property
     * @return the owner
     */
    public Owner getOwner() {
        return owner;
    }
}
