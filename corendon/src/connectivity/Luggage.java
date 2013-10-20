package connectivity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author $Jelle
 */
public class Luggage {
    
    private DbManager db = new DbManager();
    
    private int luggageId;
    private int customerId;
    private String description;
    private String location;
    private String date;
    private String time;
    private boolean isLost;
    private boolean isHandled;
    
    public Luggage() {
        db.openConnection();
    }
    
    public Luggage(int luggageId, int customerId, String description,
            String location, String date, String time, boolean isLost,
            boolean isHandled) {
        this.luggageId = luggageId;
        this.customerId = customerId;
        this.description = description;
        this.location = location;
        this.date = date;
        this.time = time;
        this.isLost = isLost;
        this.isHandled = isHandled;
        
//        System.out.println(customerId + " " + lastName + " " + email);
    }
    
    public void getCustomerData(String tfInput, String databaseVariable) {
        try {
            String sql = "SELECT *, COUNT(*) as `rows` FROM `customer` WHERE `" + databaseVariable + "`='" + tfInput + "'";
            ResultSet result = getDb().doQuery(sql);
            if (result.next()) {
                if (result.getInt("rows") >= 1) {
                    this.setLuggageId(result.getInt("luggage_id"));
                    this.setCustomerId(result.getInt("customer_id"));
                    this.setDescription(result.getString("description"));
                    this.setLocation(result.getString("location"));
                    this.setDate(result.getString("date"));
                    this.setTime(result.getString("time"));
                    this.setIsLost(result.getBoolean("is_lost"));
                    this.setIsHandled(result.getBoolean("is_handled"));
                }
                else
                    System.out.println("SOMETHING WENT WRONG");
            }
        } catch (SQLException e) {
            System.out.println(getDb().SQL_EXCEPTION + e.getMessage());
        }
    }
    
    public List<Luggage> getLuggageList() {
        List<Luggage> luggages = new ArrayList<>();
        try {
            String sql = "SELECT * FROM `luggage`";
            ResultSet result = getDb().doQuery(sql);
            while (result.next()) {
                luggages.add(new Luggage(result.getInt("luggage_id"),
                        result.getInt("customer_id"),
                        result.getString("description"),
                        result.getString("location"),
                        result.getString("date"),
                        result.getString("time"),
                        result.getBoolean("is_lost"),
                        result.getBoolean("is_handled")));
            }
        } catch (SQLException e) {
            System.out.println(getDb().SQL_EXCEPTION + e.getMessage());
        }
        return luggages;
    }
//        
//    public void setNewLuggage(String tfFirstName, String tfLastName,
//            String tfAddress, String tfPostalCode, String tfEmail,
//            String tfPhoneHome, String tfPhoneMobile) {
//        String sql = "INSERT INTO fys.`customer` (first_name, last_name, address, postal_code, email, phone_home, phone_mobile) VALUES ('" 
//                + tfFirstName + "', '" + tfLastName + "', '" + tfAddress 
//                + "', '" + tfPostalCode + "', '" + tfEmail + "', '"
//                + tfPhoneHome + "', '" + tfPhoneMobile + "'";
//        db.insertQuery(sql);
//    }

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
     * @return the luggageId
     */
    public int getLuggageId() {
        return luggageId;
    }

    /**
     * @param luggageId the luggageId to set
     */
    public void setLuggageId(int luggageId) {
        this.luggageId = luggageId;
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return the isLost
     */
    public boolean isIsLost() {
        return isLost;
    }

    /**
     * @param isLost the isLost to set
     */
    public void setIsLost(boolean isLost) {
        this.isLost = isLost;
    }

    /**
     * @return the isHandled
     */
    public boolean isIsHandled() {
        return isHandled;
    }

    /**
     * @param isHandled the isHandled to set
     */
    public void setIsHandled(boolean isHandled) {
        this.isHandled = isHandled;
    }
}