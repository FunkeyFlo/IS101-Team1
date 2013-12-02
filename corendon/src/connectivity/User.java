package connectivity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Team AwesomeSauce
 */
public class User {

    private final DbManager db = new DbManager();

    // Variable that sets the maximum ammount of incorrect login attempts
    public final int MAX_INCORRECT_LOGINS = 3;
    private final int STANDARD_INCORRECT_LOGINS = 0;

    // Variable Declaration.
    private int permissionId, incorrectLogin, userId;
    private String username, firstName, lastName, password;
    private boolean isLoggedIn = false;

    public User() {
        db.openConnection();
    }

   // Constructor.
    public User(String firstName, String lastName, String username,
            int permissionId, int incorrectLogin, int userId) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.permissionId = permissionId;
        this.incorrectLogin = incorrectLogin;
    }

    /**
     * determines whether a user is logging in with the correct information
     * @param tfUsername
     * @param tfPassword
     * @return 
     */
    public String login(String tfUsername, String tfPassword) {
        this.getUserData(tfUsername);
        if (this.username.equals(tfUsername)) {
            if (BCrypt.checkpw(tfPassword, this.getPassword())) {
                this.setIsLoggedIn(true);
                return "Login success";
            } else {
                return "Password is incorrect";
            }
        } else {
            return "Username doesn't exist";
        }
    }

    /**
     * Checks whether the old password is correct (USED IN COMBINATION WITH updatePassword METHOD)
     * @param oldPassword
     * @param storedUsername
     * @return 
     */
    public boolean checkOldPassword(String oldPassword, String storedUsername) {
        this.getUserData(storedUsername);
        return BCrypt.checkpw(oldPassword, this.getPassword());
    }

    /**
     * Determines whether a user's account has been locked
     * @return 
     */
    public boolean getLockState() {
        return this.incorrectLogin >= MAX_INCORRECT_LOGINS;
    }

    /**
     * Gets all data of one selected user(STRINGS).
     * @param username 
     */
    public void getUserData(String username) {
        try {
            String sql = "SELECT *, COUNT(*) as `rows` FROM `user` WHERE `username`='" + username + "'";
            ResultSet result = db.doQuery(sql);
            if (result.next()) {
                if (result.getInt("rows") >= 1) {
                    this.setUserId(result.getInt("user_id"));
                    this.setUsername(result.getString("username"));
                    this.setFirstName(result.getString("first_name"));
                    this.setLastName(result.getString("last_name"));
                    this.setPermissionId(result.getInt("permission_id"));
                    this.setPassword(result.getString("password"));
                    this.setIncorrectLogin(result.getInt("incorrect_login"));
                } else {
                    this.setUsername("INVALID");
                }
            }
        } catch (SQLException e) {
            System.out.println(db.SQL_EXCEPTION + e.getMessage());
        }
    }

    /**
     * Gets all data of one selected user(INTERGERS).
     * @param userId 
     */
    public void getUserDataInt(int userId) {
        try {
            String sql = "SELECT *, COUNT(*) as `rows` FROM `user` WHERE `user_id`='" + userId + "'";
            ResultSet result = db.doQuery(sql);
            if (result.next()) {
                if (result.getInt("rows") >= 1) {
                    this.setUserId(result.getInt("user_id"));
                    this.setUsername(result.getString("username"));
                    this.setFirstName(result.getString("first_name"));
                    this.setLastName(result.getString("last_name"));
                    this.setPermissionId(result.getInt("permission_id"));
                    this.setPassword(result.getString("password"));
                    this.setIncorrectLogin(result.getInt("incorrect_login"));
                } else {
                    this.setUsername("INVALID");
                }
            }
        } catch (SQLException e) {
            System.out.println(db.SQL_EXCEPTION + e.getMessage());
        }
    }

    /**
     * Used to create a new user, User ID is auto increment
     * @param tfUsername
     * @param tfFirstName
     * @param tfLastName
     * @param tfPassword
     * @param inputPermissionId 
     */
    public void createUser(String tfUsername, String tfFirstName, String tfLastName,
            String tfPassword, int inputPermissionId) {
        tfPassword = BCrypt.hashpw(tfPassword, BCrypt.gensalt());

        String sql = "INSERT INTO `user` (username, first_name, last_name,"
                + "password, permission_id, incorrect_login) VALUES ('"
                + tfUsername + "', '"
                + tfFirstName + "', '"
                + tfLastName + "', '"
                + tfPassword + "', "
                + inputPermissionId + ","
                + STANDARD_INCORRECT_LOGINS + ")";
        db.insertQuery(sql);
    }

    /**
     * Update already existing user data.
     * @param username
     * @param firstName
     * @param lastName
     * @param permissionId 
     */
    public void updateUser(String username, String firstName, String lastName,
            int permissionId) {

        String sql = "UPDATE `user` SET `first_name` = '" + firstName + "', "
                + "`last_name` = '" + lastName + "', "
                + "`permission_id` = " + permissionId
                + " WHERE `username` = '" + username + "'";
        db.insertQuery(sql);
    }

    /**
     * Deletes user in database
     * @param tfUsername 
     */
    public void deleteUser(String tfUsername) {
        String sql = "DELETE FROM `user` WHERE `username` = '" + tfUsername + "'";
        db.insertQuery(sql);
    }

    /**
     * Checks if the username is in use in de tabel User
     *
     * @param username
     * @return true if username is in use
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
     * User to change desired user information (STRINGS)
     * @param username
     * @param dbField
     * @param newValue 
     */
    public void changeUserStringData(String username, String dbField,
            String newValue) {

        String sql = "UPDATE `user` SET `" + dbField + "` = '" + newValue
                + "' WHERE `username` = '" + username + "'";
        db.insertQuery(sql);
    }

    /**
     * Used to change desired user information (INTEGERS)
     * @param inputUsername
     * @param dbField
     * @param newValue 
     */
    public void changeUserIntData(String inputUsername, String dbField, int newValue) {
        String sql = "UPDATE `user` SET `" + dbField + "` = '" + newValue
                + "' WHERE `username` = '" + inputUsername + "'";
        db.insertQuery(sql);
    }

    /**
     * Increases incorrect login count by one on incorrect login attempt
     */
    public void setIncorrectLogin() {
        String sql = "UPDATE `user` SET `incorrect_login` = `incorrect_login`"
                + "+ 1 WHERE `username` = '" + this.username + "'";
        db.insertQuery(sql);
    }

    /**
     * Sets incorrect login count to 0
     */
    public void resetIncorrectLogin() {
        String sql = "UPDATE `user` SET `incorrect_login` = 0 WHERE `username` = '"
                + this.username + "'";
        db.insertQuery(sql);
    }

    /**
     * Password update method
     * @param tfPassword
     * @param tfUsername 
     */
    public void updatePassword(String tfPassword, String tfUsername) {
        tfPassword = BCrypt.hashpw(tfPassword, BCrypt.gensalt());

        String sql = "UPDATE `user` SET `password` = '" + tfPassword
                + "' WHERE `username`='" + tfUsername + "'";
        db.insertQuery(sql);
    }

    /**
     * Method for filling jTable and searching database
     * @param dbField
     * @param searchArg
     * @return 
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

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getUsername() {
        return this.username;
    }

    public int getPermissionId() {
        return this.permissionId;
    }

    public int getIncorrectLogin() {
        return this.incorrectLogin;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    public void setIncorrectLogin(int incorrectLogin) {
        this.incorrectLogin = incorrectLogin;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIsLoggedIn() {
        return isLoggedIn;
    }

    public void setIsLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    //commentaar
}
