package ntnu.idatx2001.model;

import org.apache.commons.lang3.StringUtils;
/**
 * The type Postal code.
 */
public class PostTown {

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
    public PostTown(String postalCode, String city, String municipality) {
        if (StringUtils.isBlank(postalCode) || StringUtils.isBlank(city) ||
                StringUtils.isBlank(municipality)) {
            throw new IllegalArgumentException("Fields cannot be blank or null");
        } else {
            this.postalCode = postalCode;
            this.city = city;
            this.municipality = municipality;
        }
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
     *
     * @param postalCode the postal code
     * @Throws IllegalArgumentException if the String input is blank, null or if the number is not 4 digits long.
     */
    public void setPostalCode(String postalCode) {
        if (this.postalCode == null) {
            throw new IllegalArgumentException("Postal code cannot be null");
        } else if (StringUtils.length(this.postalCode) != 4) {
            throw new IllegalArgumentException("Postal code must be a 4 digit number");
        } else if (StringUtils.isBlank(this.postalCode)) {
            throw new IllegalArgumentException("String cannot be blank");
        } else {
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
     *
     * @param city the city
     * @Throws IllegalArgumentException if the String input is blank or null.
     */
    public void setCity(String city) {
        if (this.city == null) {
            throw new IllegalArgumentException("Field cannot be null");
        } else if (StringUtils.isBlank(this.city)) {
            throw new IllegalArgumentException("Field cannot be blank");
        } else {
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
     *
     * @param municipality the municipality
     * @Throws IllegalArgumentException if the String input is blank or null.
     */
    public void setMunicipality(String municipality) {
        if (this.municipality == null) {
            throw new IllegalArgumentException("Field cannot be null");
        } else if (StringUtils.isBlank(this.municipality)) {
            throw new IllegalArgumentException("Field cannot be blank");
        } else {
            this.municipality = municipality;
        }
    }
}
