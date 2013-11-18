package connectivity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Customer {

    private DbManager db = new DbManager();

    private int customerId;
    private String phoneHome, phoneMobile, firstName, lastName, email,
            postalCode, address, city, country;

    public Customer() {
        db.openConnection();
    }

    // Constructor used to initiate the customer object
    public Customer(int customerId, String firstName, String lastName, String address,
            String postalCode, String city, String country, String email, String phoneHome, String phoneMobile) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
        this.email = email;
        this.phoneHome = phoneHome;
        this.phoneMobile = phoneMobile;
    }

    // Gets customer data for one specific user
    public void getCustomerData(String tfInput, String databaseVariable) {
        try {
            String sql = "SELECT *, COUNT(*) as `rows` FROM `customer` WHERE `" + databaseVariable + "`='" + tfInput + "'";
            ResultSet result = getDb().doQuery(sql);
            if (result.next()) {
                if (result.getInt("rows") >= 1) {
                    this.email = (result.getString("email"));
                    this.customerId = (result.getInt("customer_id"));
                    this.firstName = (result.getString("first_name"));
                    this.lastName = (result.getString("last_name"));
                    this.postalCode = (result.getString("postal_code"));
                    this.phoneHome = (result.getString("phoneHome"));
                    this.address = (result.getString("address"));
                    this.phoneMobile = (result.getString("phoneMobile"));
                } else {
                    System.out.println("SOMETHING WENT WRONG");
                }
            }
        } catch (SQLException e) {
            System.out.println(getDb().SQL_EXCEPTION + e.getMessage());
        }
    }

    // Used to populate jTables and search database for customers
    public List<Customer> searchCustomerList(int dbField, String searchArg) {
        List<Customer> customers = new ArrayList<>();
        String sql, sqlSelect = "SELECT * FROM `customer`";

        // Statement for searching all collumns
        if (dbField == 0) {
            sql = sqlSelect + " WHERE `customer_id` LIKE '%" + searchArg + "%'"
                    + "OR `first_name` LIKE '%" + searchArg + "%'"
                    + "OR `last_name` LIKE '%" + searchArg + "%'"
                    + "OR `address` LIKE '%" + searchArg + "%'"
                    + "OR `postal_code` LIKE '%" + searchArg + "%'"
                    + "OR `city` LIKE '%" + searchArg + "%'"
                    + "OR `country` LIKE '%" + searchArg + "%'"
                    + "OR `email` LIKE '%" + searchArg + "%'"
                    + "OR `phone_home` LIKE '%" + searchArg + "%'"
                    + "OR `phone_mobile` LIKE '%" + searchArg + "%'";
        } // for searching customerId
        else if (dbField == 1) {
            sql = sqlSelect + " WHERE `customer_id` LIKE '%" + searchArg + "%'";
        } // firstName
        else if (dbField == 2) {
            sql = sqlSelect + " WHERE `first_name` LIKE '%" + searchArg + "%'";
        } //lastName
        else if (dbField == 3) {
            sql = sqlSelect + " WHERE `last_name` LIKE '%" + searchArg + "%'";
        } // address
        else if (dbField == 4) {
            sql = sqlSelect + " WHERE `address` LIKE '%" + searchArg + "%'";
        } // postalCode
        else if (dbField == 5) {
            sql = sqlSelect + " WHERE `postal_code` LIKE '%" + searchArg + "%'";
        } // city
        else if (dbField == 6) {
            sql = sqlSelect + " WHERE `city` LIKE '%" + searchArg + "%'";
        } // country
        else if (dbField == 7) {
            sql = sqlSelect + " WHERE `country` LIKE '%" + searchArg + "%'";
        } // email
        else if (dbField == 8) {
            sql = sqlSelect + " WHERE `email` LIKE '%" + searchArg + "%'";
        } // phoneHome
        else if (dbField == 9) {
            sql = sqlSelect + " WHERE `phone_home` LIKE '%" + searchArg + "%'";
        } // phoneMobile
        else if (dbField == 10) {
            sql = sqlSelect + " WHERE `phone_mobile` LIKE '%" + searchArg + "%'";
        } // Else statement is used to fill the table with all users
        else {
            sql = sqlSelect;
        }

        try {
            ResultSet result = getDb().doQuery(sql);
            while (result.next()) {
                customers.add(new Customer(result.getInt("customer_id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("address"),
                        result.getString("postal_code"),
                        result.getString("city"),
                        result.getString("country"),
                        result.getString("email"),
                        result.getString("phone_home"),
                        result.getString("phone_mobile")));
            }
        } catch (SQLException e) {
            System.out.println(getDb().SQL_EXCEPTION + e.getMessage());
        }
        return customers;
    }

    public void setNewCustomer(String tfFirstName, String tfLastName,
            String tfAddress, String tfPostalCode, String tfCity, String tfCountry, String tfEmail,
            String tfPhoneHome, String tfPhoneMobile) {
        String sql = "INSERT INTO `customer` (first_name, last_name, address, postal_code, city, country, email, phone_home, phone_mobile) VALUES ('"
                + tfFirstName + "', '" + tfLastName + "', '" + tfAddress
                + "', '" + tfPostalCode + "', '" + tfCity + "', '" + tfCountry
                + "', '" + tfEmail + "', '" + tfPhoneHome + "', '"
                + tfPhoneMobile + "')";
        db.insertQuery(sql);
    }

    /**
     * @return the db
     */
    public DbManager getDb() {
        return db;
    }

    /**
     * @param db the db to set
     */
    public void setDb(DbManager db) {
        this.db = db;
    }

    /**
     * @return the customerId
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * @return the phoneHome
     */
    public String getPhoneHome() {
        return phoneHome;
    }

    /**
     * @param phoneHome the phoneHome to set
     */
    public void setPhoneHome(String phoneHome) {
        this.phoneHome = phoneHome;
    }

    /**
     * @return the phoneMobile
     */
    public String getPhoneMobile() {
        return phoneMobile;
    }

    /**
     * @param phoneMobile the phoneMobile to set
     */
    public void setPhoneMobile(String phoneMobile) {
        this.phoneMobile = phoneMobile;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }
}
