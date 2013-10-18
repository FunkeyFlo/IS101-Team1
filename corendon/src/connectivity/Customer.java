package connectivity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author $Jelle
 */
public class Customer {
    
    private DbManager db = new DbManager();
    
    private int customerId;
    private String phoneHome;
    private String phoneMobile;
    private String firstName;
    private String lastName;
    private String email;
    private String postalCode;
    private String address;
    
    public Customer() {
        db.openConnection();
    }
    
    public Customer(int customerId, String phoneHome, String phoneMobile, String firstName,
            String lastName, String email, String postalCode, String address) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.postalCode = postalCode;
        this.address = address;
        this.phoneHome = phoneHome;
        this.phoneMobile = phoneMobile;
        
//        System.out.println(customerId + " " + lastName + " " + email);
    }
    
    public void getCustomerData(String tfInput, String databaseVariable) {
        try {
            String sql = "SELECT *, COUNT(*) as `rows` FROM `customer` WHERE `" + databaseVariable + "`='" + tfInput + "'";
            ResultSet result = getDb().doQuery(sql);
            if (result.next()) {
                if (result.getInt("rows") >= 1) {
                    this.setEmail(result.getString("email"));
                    this.setCustomerId(result.getInt("customer_id"));
                    this.setFirstName(result.getString("first_name"));
                    this.setLastName(result.getString("last_name"));
                    this.setPostalCode(result.getString("postal_code"));
                    this.setPhoneHome(result.getString("phoneHome"));
                    this.setAddress(result.getString("address"));
                    this.setPhoneMobile(result.getString("phoneMobile"));
                }
                else
                    this.setEmail("INVALID");
            }
        } catch (SQLException e) {
            System.out.println(getDb().SQL_EXCEPTION + e.getMessage());
        }
    }
    
    public List<Customer> getCustomerList() {
        List<Customer> customers = new ArrayList<>();
        try {
            String sql = "SELECT * FROM `customer`";
            ResultSet result = getDb().doQuery(sql);
            while (result.next()) {
                customers.add(new Customer(result.getInt("customer_id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("email"),
                        result.getString("postal_code"),
                        result.getString("address"),
                        result.getString("phone_home"),
                        result.getString("phone_mobile")));
            }
        } catch (SQLException e) {
            System.out.println(getDb().SQL_EXCEPTION + e.getMessage());
        }
        return customers;
    }
        
    public void setNewCustomer(String tfFirstName, String tfLastName,
            String tfAddress, String tfPostalCode, String tfEmail,
            String tfPhoneHome, String tfPhoneMobile) {
        String sql = "INSERT INTO fys.`customer` (first_name, last_name, address, postal_code, email, phone_home, phone_mobile) VALUES ('" 
                + tfFirstName + "', '" + tfLastName + "', '" + tfAddress 
                + "', '" + tfPostalCode + "', '" + tfEmail + "', '"
                + tfPhoneHome + "', '" + tfPhoneMobile + "'";
        getDb().insertQuery(sql);
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

}
