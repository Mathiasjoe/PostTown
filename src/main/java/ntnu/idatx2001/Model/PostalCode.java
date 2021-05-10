package ntnu.idatx2001.Model;

/**
 * The type Postal code.
 */
public class PostalCode {

    private String postalCode;
    private String city;
    private String municipality;

    /**
     * Instantiates a new Postal code.
     *
     * @param postalCode   the postal code
     * @param city         the city
     * @param municipality the municipality
     */
    public PostalCode(String postalCode, String city, String municipality) {
        this.postalCode = postalCode;
        this.city = city;
        this.municipality = municipality;
    }

    /**
     * Get the postal code.
     *
     * @return the postal code
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Set the postal code.
     * Throws Exception if the field is blank, null or if the number is not 4 digits long.
     * @param postalCode the postal code
     */
    public void setPostalCode(String postalCode) {
        if(this.postalCode == null){
            throw new IllegalArgumentException("Field cannot be null");
        }if(this.postalCode.length() != 4){
            throw new IllegalArgumentException("Postal code must be a 4 digit number");
        }if(this.postalCode.isBlank()){
            throw new IllegalArgumentException("Field cannot be blank");
        }else {
            this.postalCode = postalCode;
        }
    }

    /**
     * Get the city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Set the city.
     * Throws Exception if the field is blank or null.
     * @param city the city
     */
    public void setCity(String city) {
        if(this.city == null){
            throw new IllegalArgumentException("Field cannot be null");
        }if(this.city.isBlank()){
            throw new IllegalArgumentException("Field cannot be blank");
        }else {
            this.city = city;
        }
    }

    /**
     * Get the municipality.
     *
     * @return the municipality
     */
    public String getMunicipality() {
        return municipality;
    }

    /**
     * Set the municipality.
     * Throws Exception if the field is blank or null.
     * @param municipality the municipality
     */
    public void setMunicipality(String municipality) {
        if(this.municipality == null){
            throw new IllegalArgumentException("Field cannot be null");
        }if(this.municipality.isBlank()){
            throw new IllegalArgumentException("Field cannot be blank");
        }else {
            this.municipality = municipality;
        }
    }
}
