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
    private String dateLost;
    private boolean isLost;
    private boolean isHandled;
    private String dateChanged;
    private String dateHandled;
    private String lastChangedBy;
    
    public Luggage() {
        db.openConnection();
    }
    
    public Luggage(int luggageId, int customerId, String description,
            String location, String dateLost, boolean isLost, boolean isHandled,
            String dateChanged, String dateHandled, String lastChangedBy) {
        this.luggageId = luggageId;
        this.customerId = customerId;
        this.description = description;
        this.location = location;
        this.dateLost = dateLost;
        this.isLost = isLost;
        this.isHandled = isHandled;
        this.dateChanged = dateChanged;
        this.dateHandled = dateHandled;
        this.lastChangedBy = lastChangedBy;
        
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
                    this.setDateLost(result.getString("date_lost"));
                    this.setIsLost(result.getBoolean("is_lost"));
                    this.setIsHandled(result.getBoolean("is_handled"));
                    this.setDateChanged(result.getString("date_changed"));
                    this.setDateHandled(result.getString("date_handled"));
                    this.setLastChangedBy(result.getString("last_changed_by"));
                }
                else
                    System.out.println("SOMETHING WENT WRONG");
            }
        } catch (SQLException e) {
            System.out.println(getDb().SQL_EXCEPTION + e.getMessage());
        }
    }
    
    public List<Luggage> searchLuggageList(int dbField, String searchArg) {
        List<Luggage> luggages = new ArrayList<>();
        String sql, sqlSelect = "SELECT * FROM `luggage`";
        
        // Statement for searching all collumns
        if (dbField == 0) {
            sql = sqlSelect + " WHERE `luggage_id` LIKE '%" + searchArg + "%'"
                    + "OR `customer_id` LIKE '%" + searchArg + "%'" 
                    + "OR `description` LIKE '%" + searchArg + "%'"
                    + "OR `location` LIKE '%" + searchArg + "%'"
                    + "OR `date_lost` LIKE '%" + searchArg + "%'";
        }
        
        // for searching luggageId
        else if (dbField == 1) {
            sql = sqlSelect + " WHERE `luggage_id` LIKE '%" + searchArg + "%'";
        }
        
        // customerId
        else if (dbField == 2) {
            sql = sqlSelect + " WHERE `customer_id` LIKE '%" + searchArg + "%'";
        }
        
        // description
        else if (dbField == 3) {
            sql = sqlSelect + " WHERE `description` LIKE '%" + searchArg + "%'";
        }
        
        // location
        else if (dbField == 4) {
            sql = sqlSelect + " WHERE `location` LIKE '%" + searchArg + "%'";
        }
        
        // date
        else if (dbField == 5) {
            sql = sqlSelect + " WHERE `date_lost` LIKE '%" + searchArg + "%'";
        }
        
        //lost luggage
        else if (dbField == 6) {
            sql = sqlSelect + " WHERE `date_lost` LIKE '%" + searchArg + "%'"
                    + " AND is_lost = 1 AND is_handled = 0";
        }
        
        //found luggage
        else if (dbField == 7) {
            sql = sqlSelect + " WHERE `date_lost` LIKE '%" + searchArg + "%'"
                    + " AND is_lost = 0 AND is_handled = 0";
        }
        
        //handled luggage
        else if (dbField == 8) {
            sql = sqlSelect + " WHERE `date_handled` LIKE '%" + searchArg + "%'"
                    + " AND is_lost = 0 AND is_handled = 1";
        }
        // Else statement is used to fill the table with all users
        else
            sql = sqlSelect;
        
        try {
            ResultSet result = getDb().doQuery(sql);
            while (result.next()) {
                luggages.add(new Luggage(result.getInt("luggage_id"),
                        result.getInt("customer_id"),
                        result.getString("description"),
                        result.getString("location"),
                        result.getString("date_lost"),
                        result.getBoolean("is_lost"),
                        result.getBoolean("is_handled"),
                        result.getString("date_changed"),
                        result.getString("date_handled"),
                        result.getString("last_changed_by")));
            }
        } catch (SQLException e) {
            System.out.println(getDb().SQL_EXCEPTION + e.getMessage());
        }
        return luggages;
    }
    
    // moet nog waardes van luggage krijgen, staan nu nog customer waardes in
    public void setNewLuggage(int customerId, String description, String location, boolean isLost, boolean  isHandled) {
        String sql = "INSERT INTO fys.`luggage` (customer_id, description, location, is_lost, is_handled) VALUES ('" 
                + customerId + "', '" + description + "', '" + location 
                + "', '" + isLost + "', '" + isHandled + "'";
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
    
    public void linkCustomerId(int customerId, int luggageId) {
        String sql = "UPDATE `luggage` SET `customer_id` = " + customerId + " WHERE `luggage_id` = " + luggageId;
        db.insertQuery(sql);
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
    public String getDateLost() {
        return dateLost;
    }

    /**
     * @param date the date to set
     */
    public void setDateLost(String dateLost) {
        this.dateLost = dateLost;
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

    /**
     * @return the dateChanged
     */
    public String getDateChanged() {
        return dateChanged;
    }

    /**
     * @param dateChanged the dateChanged to set
     */
    public void setDateChanged(String dateChanged) {
        this.dateChanged = dateChanged;
    }

    /**
     * @return the dateHandled
     */
    public String getDateHandled() {
        return dateHandled;
    }

    /**
     * @param dateHandled the dateHandled to set
     */
    public void setDateHandled(String dateHandled) {
        this.dateHandled = dateHandled;
    }

    /**
     * @return the lastChangedBy
     */
    public String getLastChangedBy() {
        return lastChangedBy;
    }

    /**
     * @param lastChangedBy the lastChangedBy to set
     */
    public void setLastChangedBy(String lastChangedBy) {
        this.lastChangedBy = lastChangedBy;
    }
}