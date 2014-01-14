package model;

import connectivity.DatabaseManager;

/**
 *
 * @author Niels Reijn
 */
public class Resort {

    DatabaseManager db = new DatabaseManager();

    private int id;
    private String phone, email, name, address, country, city, postalCode;

    /**
     * Constructor.
     *
     * @param id
     * @param phone
     * @param email
     * @param name
     * @param address
     * @param country
     * @param city
     * @param postalCode
     */
    public Resort(int id, String phone, String email, String name,
            String address, String country, String city, String postalCode) {
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.name = name;
        this.address = address;
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
    }

    public Resort() {
    }

    public DatabaseManager getDb() {
        return db;
    }

    public void setDb(DatabaseManager db) {
        this.db = db;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
