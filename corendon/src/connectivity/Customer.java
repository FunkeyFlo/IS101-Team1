package connectivity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import main.Session;

/**
 * @author Team AwesomeSauce
 */
public class Customer {

    private DbManager db = new DbManager();

    private int customerId, lastChangedBy;
    private final int garbage = 0;
    private String phoneHome, phoneMobile, firstName, lastName, email,
            postalCode, address, city, country, dateChanged;

    public Customer() {
        db.openConnection();
    }

    // Constructor used to initiate the customer object
    public Customer(int customerId, String firstName, String lastName, String address,
            String postalCode, String city, String country, String email,
            String phoneHome, String phoneMobile, String dateChanged, int lastChangedBy) {
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
        this.dateChanged = dateChanged;
        this.lastChangedBy = lastChangedBy;
    }

    // Gets customer data for one specific user
    public void getCustomerData(String tfInput, String databaseVariable) {
        try {
            String sql = "SELECT *, COUNT(*) as `rows` FROM `customer` WHERE `"
                    + databaseVariable + "`='" + tfInput + "'";
            ResultSet result = getDb().doQuery(sql);
            if (result.next()) {
                if (result.getInt("rows") >= 1) {
                    this.email = (result.getString("email"));
                    this.customerId = (result.getInt("customer_id"));
                    this.firstName = (result.getString("first_name"));
                    this.lastName = (result.getString("last_name"));
                    this.postalCode = (result.getString("postal_code"));
                    this.phoneHome = (result.getString("phone_home"));
                    this.address = (result.getString("address"));
                    this.phoneMobile = (result.getString("phone_mobile"));
                    this.city = (result.getString("city"));
                    this.country = (result.getString("country"));
                    this.setDateChanged(result.getString("date_changed"));
                    this.setLastChangedBy(result.getInt("last_changed_by"));
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
        } 
        
        // firstName
        else if (dbField == 2) {
            sql = sqlSelect + " WHERE `first_name` LIKE '%" + searchArg + "%'";
        } 
        
        //lastName
        else if (dbField == 3) {
            sql = sqlSelect + " WHERE `last_name` LIKE '%" + searchArg + "%'";
        }

        // address
        else if (dbField == 4) {
            sql = sqlSelect + " WHERE `address` LIKE '%" + searchArg + "%'";
        }

        // postalCode
        else if (dbField == 5) {
            sql = sqlSelect + " WHERE `postal_code` LIKE '%" + searchArg + "%'";
        }

        // city
        else if (dbField == 6) {
            sql = sqlSelect + " WHERE `city` LIKE '%" + searchArg + "%'";
        }

        // country
        else if (dbField == 7) {
            sql = sqlSelect + " WHERE `country` LIKE '%" + searchArg + "%'";
        }

        // email
        else if (dbField == 8) {
            sql = sqlSelect + " WHERE `email` LIKE '%" + searchArg + "%'";
        }

        // phoneHome
        else if (dbField == 9) {
            sql = sqlSelect + " WHERE `phone_home` LIKE '%" + searchArg + "%'";
        }

        // phoneMobile
        else if (dbField == 10) {
            sql = sqlSelect + " WHERE `phone_mobile` LIKE '%" + searchArg + "%'";
        }

        // Else statement is used to fill the table with all users
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
                        result.getString("phone_mobile"),
                        result.getString("date_changed"),
                        result.getInt("last_changed_by")));
            }
        } catch (SQLException e) {
            System.out.println(getDb().SQL_EXCEPTION + e.getMessage());
        }
        return customers;
    }

    public void setNewCustomer(String tfFirstName, String tfLastName,
            String tfAddress, String tfPostalCode, String tfCity, String tfCountry,
            String tfEmail, String tfPhoneHome, String tfPhoneMobile) {
        
        String sql = "INSERT INTO `customer` (first_name, last_name, address,"
                + "postal_code, city, country, email, phone_home, phone_mobile,"
                + "date_changed, last_changed_by)"
                + " VALUES ('" + tfFirstName + "', '"
                + tfLastName + "', '"
                + tfAddress + "', '"
                + tfPostalCode + "', '"
                + tfCity + "', '"
                + tfCountry + "', '"
                + tfEmail + "', '"
                + tfPhoneHome + "', '"
                + tfPhoneMobile + "', "
                + "CURRENT_TIMESTAMP, '"
                + Session.storedUserId + "')";
        db.insertQuery(sql);
    }
    
    public void deleteCustomer(String tfCustomerId) {
        String sql = "DELETE FROM `customer` WHERE `customer_id` = '" + tfCustomerId + "'";
        db.insertQuery(sql);
    }
    
    public void updateCustomer(String firstName, String lastName, String address,
            String postalCode, String city, String country, String email,
            String phoneHome, String phoneMobile) {
        
        String sql = "UPDATE `customer` SET `first_name` = '" + firstName + "'"
                + ", `last_name` = '" + lastName + "'"
                + ", `address` = '" + address + "'"
                + ", `postal_code` = '" + postalCode + "'"
                + ", `city` = '" + city + "'"
                + ", `country` = '" + country + "'"
                + ", `email` = '" + email + "'"
                + ", `phone_home` = '" + phoneHome + "'"
                + ", `last_changed_by` = '" + Session.storedUserId + "'"
                + ", `phone_mobile` = '" + phoneMobile + "'"
                + ", `date_changed` = CURRENT_TIMESTAMP"
                + " WHERE `customer_id` = " + Session.storedCustomerId;
        
        db.insertQuery(sql);
    }

    public DbManager getDb() {
        return db;
    }

    public void setDb(DbManager db) {
        this.db = db;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getPhoneHome() {
        return phoneHome;
    }

    public void setPhoneHome(String phoneHome) {
        this.phoneHome = phoneHome;
    }

    public String getPhoneMobile() {
        return phoneMobile;
    }

    public void setPhoneMobile(String phoneMobile) {
        this.phoneMobile = phoneMobile;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDateChanged() {
        return dateChanged;
    }

    public void setDateChanged(String dateChanged) {
        this.dateChanged = dateChanged;
    }

    public int getLastChangedBy() {
        return lastChangedBy;
    }

    public void setLastChangedBy(int lastChangedBy) {
        this.lastChangedBy = lastChangedBy;
    }
    //commentaar
}