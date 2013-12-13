package connectivity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Session;
import model.*;

/**
 *
 * @author Niels Reijn
 */
public class QueryManager {

    private final DatabaseManager db = new DatabaseManager();
    private final User user = new User();
    private final Customer customer = new Customer();
    private final Luggage luggage = new Luggage();
    private final Resort resort = new Resort();
    private String FUCK_YOU;

    private int permissionId, incorrectLogin, userId;
    private String username, firstName, lastName, password;
    private boolean isLoggedIn = false;
    public final int MAX_INCORRECT_LOGINS = 3;
    public PreparedStatement preparedStatement = null;

    /**
     * Compares username and password to database entries, denies or grants
     * access depending on the result.
     *
     * @param tfUsername username to be checked by this method.
     * @param tfPassword password to match the username.
     * @return String returns specific string depending on the result of the
     * method.
     */
    public String login(String tfUsername, String tfPassword) {
        this.getUserData(tfUsername);
        if (user.getUsername().equals(tfUsername)) {
            if (BCrypt.checkpw(tfPassword, user.getPassword())) {
                user.setIsLoggedIn(true);
                return "Login success";
            } else {
                return "Password is incorrect";
            }
        } else {
            return "Username doesn't exist";
        }
    }

    /**
     * Checks whether the old password is correct (USED IN COMBINATION WITH
     * updatePassword METHOD)
     *
     * @param oldPassword 'old' password to be checked.
     * @param storedUsername Username data pulled from current session.
     * @return
     */
    public boolean checkOldPassword(String oldPassword, String storedUsername) {
        this.getUserData(storedUsername);
        return BCrypt.checkpw(oldPassword, user.getPassword());
    }

    /**
     * Determines whether a user's account has been locked.
     *
     * @return boolean returns true if the amount of incorrect logins has
     * exceeded the maximum allowed amount.
     */
    public boolean getLockState() {
        return this.incorrectLogin >= MAX_INCORRECT_LOGINS;
    }

    /**
     * Method that pulls data entries for one specific user.
     *
     * @param username String parameter to determine which user data is pulled
     * from the database.
     */
    public void getUserData(String username) {
        try {
            String sql = "SELECT *, COUNT(*) as `rows` FROM `user` WHERE `username`='" + username + "'";
            ResultSet result = db.doQuery(sql);
            if (result.next()) {
                if (result.getInt("rows") >= 1) {
                    user.setUserId(result.getInt("user_id"));
                    user.setUsername(result.getString("username"));
                    user.setFirstName(result.getString("first_name"));
                    user.setLastName(result.getString("last_name"));
                    user.setPermissionId(result.getInt("permission_id"));
                    user.setPassword(result.getString("password"));
                    user.setIncorrectLogin(result.getInt("incorrect_login"));
                } else {
                    user.setUsername("INVALID");
                }
            }
        } catch (SQLException e) {
            System.out.println(db.SQL_EXCEPTION + e.getMessage());
        }
    }

    /**
     * Method that pulls data entries for one specific user.
     *
     * @param userId integer parameter to determine which user data is pulled
     * from the database.
     */
    public void getUserDataInt(int userId) {
        try {
            String sql = "SELECT *, COUNT(*) as `rows` FROM `user` WHERE `user_id`='" + userId + "'";
            ResultSet result = db.doQuery(sql);
            if (result.next()) {
                if (result.getInt("rows") >= 1) {
                    user.setUserId(result.getInt("user_id"));
                    user.setUsername(result.getString("username"));
                    user.setFirstName(result.getString("first_name"));
                    user.setLastName(result.getString("last_name"));
                    user.setPermissionId(result.getInt("permission_id"));
                    user.setPassword(result.getString("password"));
                    user.setIncorrectLogin(result.getInt("incorrect_login"));
                } else {
                    user.setUsername("INVALID");
                }
            }
        } catch (SQLException e) {
            System.out.println(db.SQL_EXCEPTION + e.getMessage());
        }
    }

    /**
     * Method used to create and insert a new user into the database.
     *
     * @param tfUsername parameter to specify the new username.
     * @param tfFirstName parameter to specify the new user's first name.
     * @param tfLastName parameter to specify the new user's last name.
     * @param tfPassword parameter to specify the new user's password.
     * @param inputPermissionId parameter to specify the role of the new user 1
     * = Employee, 2 = Manager, 3 = Administrator.
     */
    public void createUser(String tfUsername, String tfFirstName, String tfLastName,
            String tfPassword, int inputPermissionId) {
        try {
            tfPassword = BCrypt.hashpw(tfPassword, BCrypt.gensalt());
            preparedStatement = db.connection.prepareStatement("INSERT INTO"
                    + "`user`(`permission_id`,"
                    + "`username`, `first_name`, `last_name`, `password`)"
                    + "VALUES (?,?,?,?,?)");
            preparedStatement.setInt(1, inputPermissionId);
            preparedStatement.setString(2, tfUsername);
            preparedStatement.setString(3, tfFirstName);
            preparedStatement.setString(4, tfLastName);
            preparedStatement.setString(5, tfPassword);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Method used to update already existing user data.
     *
     * @param username parameter to specify the new username.
     * @param firstName parameter to specify the new first name.
     * @param lastName parameter to specify the new last name.
     * @param permissionId parameter to specify the new role. 1 = Employee, 2 =
     * Manager, 3 = Administrator.
     */
    public void updateUser(String username, String firstName, String lastName,
            int permissionId) {
        try {
            preparedStatement = db.connection.prepareStatement("UPDATE `user`"
                    + "SET `first_name` = ?, `last_name` = ?,"
                    + "`permission_id` = ? WHERE `username` = ?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setInt(4, permissionId);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Method called to remove user database entry.
     *
     * @param tfUsername parameter to specify which user entry should be
     * removed.
     */
    public void deleteUser(String tfUsername) {
        String sql = "DELETE FROM `user` WHERE `username` = '" + tfUsername + "'";
        db.insertQuery(sql);
    }

    /**
     * Method that checks whether or not a specific username already exists or
     * not.
     *
     * @param username username to check.
     * @return true if username already exists.
     */
    public boolean checkUsernameInUse(String username) {
        boolean usernameInUse = true;
        try {
            String sql = "SELECT * FROM `user` WHERE `username` LIKE '%" + username + "%'";
            ResultSet result = db.doQuery(sql);

            if (result.next()) {
                usernameInUse = true;
            } else {
                usernameInUse = false;
            }
        } catch (SQLException e) {
            System.out.println(db.SQL_EXCEPTION + e.getMessage());
        }

        return usernameInUse;
    }

    /**
     * Method that changes specific user data depending on the dbField
     * parameter.
     *
     * @param username parameter to specify user to be altered.
     * @param dbField parameter that specifies the field to be altered.
     * @param newValue String value to be inputted into the specific database
     * field.
     */
    public void changeUserStringData(String username, String dbField,
            String newValue) {

        String sql = "UPDATE `user` SET `" + dbField + "` = '" + newValue
                + "' WHERE `username` = '" + username + "'";
        db.insertQuery(sql);
    }

    /**
     * Method that changes specific user data depending on the dbField
     * parameter.
     *
     * @param inputUsername parameter to specify user to be altered.
     * @param dbField parameter that specifies the field to be altered.
     * @param newValue Integer value to be inputted into the specific database
     * field.
     */
    public void changeUserIntData(String inputUsername, String dbField, int newValue) {
        String sql = "UPDATE `user` SET `" + dbField + "` = '" + newValue
                + "' WHERE `username` = '" + inputUsername + "'";
        db.insertQuery(sql);
    }

    /**
     * Increases incorrect login count by one on incorrect login attempt.
     */
    public void setIncorrectLogin() {
        String sql = "UPDATE `user` SET `incorrect_login` = `incorrect_login`"
                + "+ 1 WHERE `username` = '" + this.username + "'";
        db.insertQuery(sql);
    }

    /**
     * Sets incorrect login count to 0.
     */
    public void resetIncorrectLogin() {
        String sql = "UPDATE `user` SET `incorrect_login` = 0 WHERE `username` = '"
                + this.username + "'";
        db.insertQuery(sql);
    }

    /**
     * Method used to update a specific user's password.
     *
     * @param tfPassword parameter that determines the new password.
     * @param tfUsername parameter to specify the user to be altered.
     */
    public void updatePassword(String tfPassword, String tfUsername) {
        tfPassword = BCrypt.hashpw(tfPassword, BCrypt.gensalt());

        String sql = "UPDATE `user` SET `password` = '" + tfPassword
                + "' WHERE `username`='" + tfUsername + "'";
        db.insertQuery(sql);
    }

    /**
     * Method for filling jTable and searching database
     *
     * @param dbField parameter to specify which field to search in, if this
     * parameter is set to 0 this method will search in all fields.
     * @param searchArg argument used to search in the database.
     * @return users that match the search argument.
     */
    public List<User> searchUserList(int dbField, String searchArg) {
        List<User> users = new ArrayList<>();
        String sql, sqlSelect = "SELECT * FROM `user`";

        // Statement for searching all collumns
        if (dbField == 0) {
            sql = sqlSelect + " WHERE `last_name` LIKE '%" + searchArg + "%'"
                    + "OR `first_name` LIKE '%" + searchArg + "%'"
                    + "OR `username` LIKE '%" + searchArg + "%'"
                    + "OR `permission_id` LIKE '%" + searchArg + "%'";
        } // firstName collumns
        else if (dbField == 1) {
            sql = sqlSelect + " WHERE `first_name` LIKE '%" + searchArg + "%'";
        } // lastName collumns
        else if (dbField == 2) {
            sql = sqlSelect + " WHERE `last_name` LIKE '%" + searchArg + "%'";
        } // username collumns
        else if (dbField == 3) {
            sql = sqlSelect + " WHERE `username` LIKE '%" + searchArg + "%'";
        } // permissionId collumns
        else if (dbField == 4) {
            sql = sqlSelect + " WHERE `permission_id` LIKE '%" + searchArg + "%'";
        } // Else statement is used to fill the table with all users
        else {
            sql = sqlSelect;
        }

        try {
            ResultSet result = db.doQuery(sql);
            while (result.next()) {
                users.add(new User(result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("username"),
                        result.getInt("permission_id"),
                        result.getInt("incorrect_login"),
                        result.getInt("user_id")));
            }
        } catch (SQLException e) {
            System.out.println(db.SQL_EXCEPTION + e.getMessage());
        }
        return users;
    }

    /**
     * Gets customer data for one specific user
     *
     * @param tfInput the value databaseVariable has to be.
     * @param databaseVariable the column in the table that will be searched in.
     */
    public void getCustomerData(String tfInput, String databaseVariable) {
        try {
            String sql = "SELECT *, COUNT(*) as `rows` FROM `customer` WHERE `"
                    + databaseVariable + "`='" + tfInput + "'";
            ResultSet result = customer.getDb().doQuery(sql);
            if (result.next()) {
                if (result.getInt("rows") >= 1) {
                    user.setUserId(result.getInt("user_id"));
                    customer.setEmail(result.getString("email"));
                    customer.setCustomerId(result.getInt("customer_id"));
                    customer.setFirstName(result.getString("first_name"));
                    customer.setLastName(result.getString("last_name"));
                    customer.setPostalCode(result.getString("postal_code"));
                    customer.setPhoneHome(result.getString("phone_home"));
                    customer.setAddress(result.getString("address"));
                    customer.setPhoneMobile(result.getString("phone_mobile"));
                    customer.setCity(result.getString("city"));
                    customer.setCountry(result.getString("country"));
                    customer.setDateChanged(result.getString("date_changed"));
                    customer.setLastChangedBy(result.getInt("last_changed_by"));
                } else {
                    System.out.println("SOMETHING WENT WRONG");
                }
            }
        } catch (SQLException e) {
            System.out.println(customer.getDb().SQL_EXCEPTION + e.getMessage());
        }
    }

    /**
     * Used to populate jTables and search database for customers
     *
     * @param dbField can be 0-10, specifies different columns.
     * @param searchArg the data that will be searched for.
     * @return
     */
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
            ResultSet result = customer.getDb().doQuery(sql);
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
            System.out.println(customer.getDb().SQL_EXCEPTION + e.getMessage());
        }
        return customers;
    }

    /**
     * Creates a new customer. All parameters below are attributes of the
     * customer.
     *
     * @param tfFirstName
     * @param tfLastName
     * @param tfAddress
     * @param tfPostalCode
     * @param tfCity
     * @param tfCountry
     * @param tfEmail
     * @param tfPhoneHome
     * @param tfPhoneMobile
     */
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

    /**
     * Deletes a customer with CustomerID.
     *
     * @param tfCustomerId id of the customer that will be deleted.
     */
    public void deleteCustomer(String tfCustomerId) {
        String sql = "DELETE FROM `customer` WHERE `customer_id` = '" + tfCustomerId + "'";
        db.insertQuery(sql);
    }

    /**
     * Updates the following attributes of a customer.
     *
     * @param firstName
     * @param lastName
     * @param address
     * @param postalCode
     * @param city
     * @param country
     * @param email
     * @param phoneHome
     * @param phoneMobile
     */
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

    /**
     * Get all Luggage data from DB.
     *
     * @param tfInput
     * @param databaseVariable
     */
    public void getLuggageData(String tfInput, String databaseVariable) {
        try {
            String sql = "SELECT *, COUNT(*) as `rows` FROM `luggage` WHERE `"
                    + databaseVariable + "`='" + tfInput + "'";
            ResultSet result = luggage.getDb().doQuery(sql);
            if (result.next()) {
                if (result.getInt("rows") >= 0) {
                    luggage.setLuggageId(result.getInt("luggage_id"));
                    luggage.setCustomerId(result.getInt("customer_id"));
                    luggage.setDescription(result.getString("description"));
                    luggage.setLocation(result.getString("location"));
                    luggage.setDateLost(result.getString("date_lost"));
                    luggage.setStatus(result.getInt("status"));
                    luggage.setDateChanged(result.getString("date_changed"));
                    luggage.setDateHandled(result.getString("date_handled"));
                    luggage.setDateFound(result.getString("date_found"));
                    luggage.setLastChangedBy(result.getInt("last_changed_by"));
                } else {
                    System.out.println("SOMETHING WENT WRONG");
                }
            }
        } catch (SQLException e) {
            System.out.println(luggage.getDb().SQL_EXCEPTION + e.getMessage());
        }
    }

    /**
     * Used to populate jTables and search database for Luggage.
     *
     * @param dbField the row given by a textfield
     * @param searchArg the search parameter.
     * @param handled searchs for handled items if 1 else it searches for 0.
     * @return a list of items.
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
            ResultSet result = luggage.getDb().doQuery(sql);
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
            System.out.println(luggage.getDb().SQL_EXCEPTION + e.getMessage());
        }
        return luggages;
    }

    /**
     * Method to create new luggage with data given by textfields.
     *
     * @param customerId textfield Input.
     * @param description textfield Input.
     * @param location textfield Input.
     * @param status textfield Input.
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
     * Used to update already existing luggage.
     *
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
     * Method to link luggage so a relation is created between the luggage and
     * the customer.
     *
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
     *
     * @param luggageId
     */
    public void deleteLuggage(String luggageId) {
        String sql = "DELETE FROM `luggage` WHERE `luggage_id` = '" + luggageId + "'";
        db.insertQuery(sql);
    }

    /**
     * Create a new Resort recort. Create a new resort.
     *
     * @param tfName
     * @param tfAddress
     * @param tfCountry
     * @param tfCity
     * @param tfPhoneResort
     * @param tfEmail
     * @param tfpostalCode
     */
    public void setNewResort(String tfName, String tfAddress, String tfCountry, String tfCity,
            String tfPhoneResort, String tfEmail, String tfpostalCode) {

        String sql = "INSERT INTO `resort` (resort_name, address, country, city,"
                + "phone_resort, email, postal_code)"
                + "VALUES ('" + tfName + "', '"
                + tfAddress + "', '"
                + tfCountry + "', '"
                + tfCity + "', '"
                + tfPhoneResort + "', '"
                + tfEmail + "', '"
                + tfpostalCode + "')";

        db.insertQuery(sql);
    }

    /**
     * Delete a single resort record.
     *
     * @param tfResortId
     */
    public void deleteResort(String tfResortId) {
        String sql = "DELETE FROM `resort` WHERE `resort_id` = '" + tfResortId + "'";
        db.insertQuery(sql);
    }

    /**
     * Update a singel resort record. Update a resort record.
     *
     * @param tfId
     * @param tfName
     * @param tfAddress
     * @param tfCountry
     * @param tfCity
     * @param tfPhoneResort
     * @param tfEmail
     * @param tfpostalCode
     */
    public void updateResort(int tfId, String tfName, String tfAddress, String tfCountry, String tfCity,
            String tfPhoneResort, String tfEmail, String tfpostalCode) {

        String sql = "UPDATE `resort` SET `resort_name` = '" + tfName + "'"
                + ", `address` = '" + tfAddress + "'"
                + ", `country` = '" + tfCountry + "'"
                + "', `city` = '" + tfCity + "'"
                + "', `phone_resort` = '" + tfPhoneResort + "'"
                + "', `email` = '" + tfEmail + "'"
                + "', `postal_code` = '" + tfpostalCode + "'"
                + "WHERE `resort_id` =" + tfId;

        db.insertQuery(sql);
    }

    /**
     * get a single resort record.
     *
     * @param tfInput
     * @param databaseVariable
     */
    public void getResortDate(String tfInput, String databaseVariable) {

        try {
            String sql = "SELECT *, COUNT(*) as `rows` FROM `resort` WHERE `"
                    + databaseVariable + "`='" + tfInput + "'";

            ResultSet result = resort.getDb().doQuery(sql);
            if (result.next()) {

                if (result.getInt("rows") >= 0) {
                    resort.setId(result.getInt("resort_id"));
                    resort.setName(result.getString("resort_name"));
                    resort.setAddress(result.getString("address"));
                    resort.setCity(result.getString("city"));
                    resort.setPhone(result.getString("phone_resort"));
                    resort.setEmail(result.getString("email"));
                    resort.setPostalCode(result.getString("postal_code"));
                } else {
                    System.out.println("SOMETING WENT WRONG");
                }
            }

        } catch (SQLException e) {
            System.out.println(resort.getDb().SQL_EXCEPTION + e.getMessage());
        }
    }

    /**
     * Method to search the entity Resorts.
     *
     * @param dbField field to search, if null it searches al fields.
     * @param searchArg the paramater to search with.
     * @return a list of resorts coresponding to the parameters.
     */
    public List<Resort> searchResortList(int dbField, String searchArg) {
        List<Resort> resorts = new ArrayList<>();
        String sql, sqlSelect = "SELECT * FROM `resort`";

        if (dbField == 0) {
            sql = sqlSelect + "WHERE `resort_id` LIKE '%" + searchArg + "%'"
                    + "OR `resort_name` LIKE '%" + searchArg + "%'"
                    + "OR `address` LIKE '%" + searchArg + "%'"
                    + "OR `country` LIKE '%" + searchArg + "%'"
                    + "OR `city` LIKE '%" + searchArg + "%'"
                    + "OR `phone_resort` LIKE '%" + searchArg + "%'"
                    + "OR `email` LIKE '%" + searchArg + "%'"
                    + "OR `postal_code`  LIKE '%" + searchArg + "%'";
        } else if (dbField == 1) {
            sql = sqlSelect + "WHERE `resort_name` LIKE '%" + searchArg + "%'";
        } else if (dbField == 2) {
            sql = sqlSelect + "WHERE `address` LIKE '%" + searchArg + "%'";
        } else if (dbField == 3) {
            sql = sqlSelect + "WHERE `country` LIKE '%" + searchArg + "%'";
        } else if (dbField == 4) {
            sql = sqlSelect + "WHERE `city` LIKE '%" + searchArg + "%'";
        } else if (dbField == 5) {
            sql = sqlSelect + "WHERE `phone_resort` LIKE '%" + searchArg + "%'";
        } else if (dbField == 6) {
            sql = sqlSelect + "WHERE `email` LIKE '%" + searchArg + "%'";
        } else if (dbField == 7) {
            sql = sqlSelect + "WHERE `postal_code` LIKE '%" + searchArg + "%'";
        } else {
            sql = sqlSelect;
        }

        try {
            ResultSet result = resort.getDb().doQuery(sql);
            while (result.next()) {
                resorts.add(new Resort(result.getInt("resort_id"),
                        result.getString("resort_name"),
                        result.getString("address"),
                        result.getString("country"),
                        result.getString("city"),
                        result.getString("phone_resort"),
                        result.getString("email"),
                        result.getString("postal_code")));
            }
        } catch (SQLException e) {
            System.out.println(resort.getDb().SQL_EXCEPTION + e.getMessage());
        }

        return resorts;

    }

    /**
     * links a resort to a customer.
     *
     * @param customerId
     * @param resortId
     */
    public void linkCustomerIdToResort(int customerId, int resortId) {
        String sql = "UPDATE `customer` SET `resort_id` = " + resortId
                + "WHERE `customer_id` =" + customerId;
        db.insertQuery(sql);
    }

}