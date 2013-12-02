package connectivity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import main.Session;

/**
 *
 * @author Team AwesomeSauce
 */
public class Luggage {

    private DbManager db = new DbManager();

    // Variable declaration.
    private int luggageId, customerId, status, lastChangedBy;
    private String description, location, dateLost, dateChanged,
            dateHandled, dateFound;

    public Luggage() {
        db.openConnection();
    }

    // Constructor used to initiate the Luggage object.
    public Luggage(int luggageId, int customerId, String description,
            String location, String dateLost, int status, String dateChanged,
            String dateHandled, String dateFound, int lastChangedBy) {
        this.luggageId = luggageId;
        this.customerId = customerId;
        this.description = description;
        this.location = location;
        this.dateLost = dateLost;
        this.status = status;
        this.dateChanged = dateChanged;
        this.dateHandled = dateHandled;
        this.dateFound = dateFound;
        this.lastChangedBy = lastChangedBy;
    }

    /**
     * Get all Luggage data from DB.
     * @param tfInput
     * @param databaseVariable 
     */
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
                    this.setStatus(result.getInt("status"));
                    this.setDateChanged(result.getString("date_changed"));
                    this.setDateHandled(result.getString("date_handled"));
                    this.setDateFound(result.getString("date_found"));
                    this.setLastChangedBy(result.getInt("last_changed_by"));
                } else {
                    System.out.println("SOMETHING WENT WRONG");
                }
            }
        } catch (SQLException e) {
            System.out.println(getDb().SQL_EXCEPTION + e.getMessage());
        }
    }

    /**
     * Used to populate jTables and search database for Luggage.
     * @param dbField
     * @param searchArg
     * @param handled
     * @return 
     */
    public List<Luggage> searchLuggageList(int dbField, String searchArg, int handled) {
        List<Luggage> luggages = new ArrayList<>();
        String showHandled, sql, sqlSelect = "SELECT * FROM `luggage`";

        if (handled == 1) {
            showHandled = " AND `status` = 3";
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
                    + " AND status = 1";
        } //lost luggage, regardless if it is still lost or not
        else if (dbField == 7) {
            sql = sqlSelect + " WHERE `date_lost` LIKE '%" + searchArg + "%'";
        } //found luggage
        else if (dbField == 8) {
            sql = sqlSelect + " WHERE `date_found` LIKE '%" + searchArg + "%'"
                    + " AND status = 2";
        } //found luggage, regardless if it is still found or not
        else if (dbField == 9) {
            sql = sqlSelect + " WHERE `date_found` LIKE '%" + searchArg + "%'";
        } //handled luggage
        else if (dbField == 10) {
            sql = sqlSelect + " WHERE `date_handled` LIKE '%" + searchArg + "%'"
                    + " AND `status` = 3";
        } else if (dbField == 11) {
            sql = sqlSelect + " WHERE `customer_id` = '" + searchArg + "'";
        } // Else statement is used to fill the table with all users
        else {
            if (handled == 1) {
                sql = sqlSelect + " WHERE `status` != 3";
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
                        result.getInt("status"),
                        result.getString("date_changed"),
                        result.getString("date_handled"),
                        result.getString("date_found"),
                        result.getInt("last_changed_by")));
            }
        } catch (SQLException e) {
            System.out.println(getDb().SQL_EXCEPTION + e.getMessage());
        }
        return luggages;
    }

    /**
     * Method to create new luggage
     * @param customerId
     * @param description
     * @param location
     * @param status 
     */
    public void createLuggage(String customerId, String description,
            String location, int status) {
        if (customerId.equals("")) {
            customerId = "NULL";
        }
        String sql = "INSERT INTO `luggage` (customer_id, description, location, "
                + "status, last_changed_by , date_changed) VALUES ("
                + customerId + ", '"
                + description + "', '"
                + location + "', '"
                + status + "', '"
                + Session.storedUserId + "', "
                + "CURRENT_TIMESTAMP)";
        db.insertQuery(sql);
    }

    /**
     *  Used to update already existing luggage.
     * @param luggageId
     * @param description
     * @param location
     * @param status 
     */
    public void updateLuggage(int luggageId, String description,
            String location, int status) {
        String dateHandled = "";

        if (status == 3) {
            dateHandled = ", `date_handled` = CURRENT_TIMESTAMP";
        }

        String sql = "UPDATE `luggage` SET `description` = '" + description + "'"
                + ", `location` = '" + location + "'"
                + ", `status` = " + status + ""
                + ", `date_changed` = CURRENT_TIMESTAMP"
                + dateHandled
                + ", `last_changed_by` = '" + Session.storedUserId + "'"
                + " WHERE `luggage_id` =" + luggageId + "";
        db.insertQuery(sql);
    }

    /**
     * Method to link luggage
     * @param customerId
     * @param luggageId 
     */
    public void linkCustomerId(int customerId, int luggageId) {
        String sql = "UPDATE `luggage` SET `customer_id` = " + customerId
                + " WHERE `luggage_id` = " + luggageId;
        db.insertQuery(sql);
    }

    /**
     * Deletes luggage from database.
     * @param luggageId 
     */
    public void deleteLuggage(String luggageId) {
        String sql = "DELETE FROM `luggage` WHERE `luggage_id` = '" + luggageId + "'";
        db.insertQuery(sql);
    }

    public DbManager getDb() {
        return db;
    }

    public void setDb(DbManager db) {
        this.db = db;
    }

    public int getLuggageId() {
        return luggageId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setLuggageId(int luggageId) {
        this.luggageId = luggageId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDateLost() {
        return dateLost;
    }

    public void setDateLost(String dateLost) {
        this.dateLost = dateLost;
    }

    public String getDateChanged() {
        return dateChanged;
    }

    public void setDateChanged(String dateChanged) {
        this.dateChanged = dateChanged;
    }

    public String getDateHandled() {
        return dateHandled;
    }

    public void setDateHandled(String dateHandled) {
        this.dateHandled = dateHandled;
    }

    public int getLastChangedBy() {
        return lastChangedBy;
    }

    public void setLastChangedBy(int lastChangedBy) {
        this.lastChangedBy = lastChangedBy;
    }

    
    public String getDateFound() {
        return dateFound;
    }

   
    public void setDateFound(String dateFound) {
        this.dateFound = dateFound;
    }
}
