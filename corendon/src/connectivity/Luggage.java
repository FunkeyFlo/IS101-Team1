package connectivity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import main.Session;

/**
 *
 * @author IS_101
 */
public class Luggage {

    private DbManager db = new DbManager();

    private int luggageId, customerId;
    private String description, location, dateLost, dateChanged, dateHandled, lastChangedBy;
    private boolean isLost, isHandled;

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
    }

    public void getLuggageData(String tfInput, String databaseVariable) {
        try {
            String sql = "SELECT *, COUNT(*) as `rows` FROM `luggage` WHERE `" 
                    + databaseVariable + "`='" + tfInput + "'";
            ResultSet result = getDb().doQuery(sql);
            if (result.next()) {
                if (result.getInt("rows") >= 0) {
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
                } else {
                    System.out.println("SOMETHING WENT WRONG");
                }
            }
        } catch (SQLException e) {
            System.out.println(getDb().SQL_EXCEPTION + e.getMessage());
        }
    }

    public List<Luggage> searchLuggageList(int dbField, String searchArg, int handled) {
        List<Luggage> luggages = new ArrayList<>();
        String showHandled, sql, sqlSelect = "SELECT * FROM `luggage`";

        if (handled == 1) {
            showHandled = " AND `is_handled` = 0";
        } else {
            showHandled = "";
        }

        // Statement for searching all collumns
        if (dbField == 0) {
            sql = sqlSelect + " WHERE `luggage_id` LIKE '%" + searchArg + "%'" + showHandled
                    + " OR `customer_id` LIKE '%" + searchArg + "%'" + showHandled
                    + " OR `description` LIKE '%" + searchArg + "%'" + showHandled
                    + " OR `location` LIKE '%" + searchArg + "%'" + showHandled
                    + " OR `date_lost` LIKE '%" + searchArg + "%'" + showHandled;
        } // for searching luggageId
        else if (dbField == 1) {
            sql = sqlSelect + " WHERE `luggage_id` LIKE '%" + searchArg + "%'"
                    + showHandled;
        } // customerId
        else if (dbField == 2) {
            sql = sqlSelect + " WHERE `customer_id` LIKE '%" + searchArg + "%'"
                    + showHandled;
        } // description
        else if (dbField == 3) {
            sql = sqlSelect + " WHERE `description` LIKE '%" + searchArg + "%'"
                    + showHandled;
        } // location
        else if (dbField == 4) {
            sql = sqlSelect + " WHERE `location` LIKE '%" + searchArg + "%'"
                    + showHandled;
        } // date
        else if (dbField == 5) {
            sql = sqlSelect + " WHERE `date_lost` LIKE '%" + searchArg + "%'"
                    + showHandled;
        } //lost luggage
        else if (dbField == 6) {
            sql = sqlSelect + " WHERE `date_lost` LIKE '%" + searchArg + "%'"
                    + " AND is_lost = 1 AND is_handled = 0";
        } //found luggage
        else if (dbField == 7) {
            sql = sqlSelect + " WHERE `date_lost` LIKE '%" + searchArg + "%'"
                    + " AND is_lost = 0 AND is_handled = 0";
        } //handled luggage
        else if (dbField == 8) {
            sql = sqlSelect + " WHERE `date_handled` LIKE '%" + searchArg + "%'"
                    + " AND is_lost = 0 AND is_handled = 1";
        } // Else statement is used to fill the table with all users
        else {
            if (handled == 1) {
                sql = sqlSelect + " WHERE `is_handled` = 0";
            } else {
                sql = sqlSelect;
            }
        }

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
    public void setNewLuggage(String customerId, String description, 
            String location, int isLost, int isHandled, int storedUserId) {
        if (customerId.equals("")) {
            customerId = "NULL";
        }
        String sql = "INSERT INTO `luggage` (customer_id, description, location, "
                + "is_lost, is_handled, last_changed_by , date_changed) VALUES ("
                + customerId + ", '" 
                + description + "', '" 
                + location + "', '"
                + isLost + "', '"
                + isHandled + "', '"
                + storedUserId + "', "
                + "CURRENT_TIMESTAMP)";
        db.insertQuery(sql);
    }
    
    public void updateLuggage(int luggageId, String description, 
            String location, int isLost, int isHandled) {
        String dateHandled = "";
        
        if(isHandled == 1) {
            dateHandled = ", `date_handled` = CURRENT_TIMESTAMP";
        }
        
        String sql = "UPDATE `luggage` SET `description` = '" + description + "'"
                + ", `location` = '" + location + "'"
                + ", `is_lost` = " + isLost + ""
                + ", `is_handled` = " + isHandled + ""
                + ", `date_changed` = CURRENT_TIMESTAMP"
                + dateHandled
                + ", `last_changed_by` = '" + Session.storedUserId + "'"
                + " WHERE `luggage_id` =" + luggageId + "";
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
        String sql = "UPDATE `luggage` SET `customer_id` = " + customerId 
                + " WHERE `luggage_id` = " + luggageId;
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
     * @param dateLost
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
