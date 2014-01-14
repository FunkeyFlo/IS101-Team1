package model;

import connectivity.DatabaseManager;

/**
 *
 * @author Niels Reijn
 */
public class Luggage {

    private DatabaseManager db = new DatabaseManager();

    private int luggageId, customerId, status, lastChangedBy;
    private String description, location, dateLost, dateChanged,
            dateHandled, dateFound;

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

    public Luggage() {
    }

    public DatabaseManager getDb() {
        return db;
    }

    public void setDb(DatabaseManager db) {
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
