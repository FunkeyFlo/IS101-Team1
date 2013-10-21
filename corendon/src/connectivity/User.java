package connectivity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Florentijn Cornet
 */
public class User {

    public final int MAX_INCORRECT_LOGINS = 3;
    
    private DbManager db = new DbManager();
    
    private int userId;
    private int permissionId;
    private int incorrectLogin;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private boolean isLoggedIn = false;
    
    public User() {
        db.openConnection();
    }
    
    public User(int userId, String firstName, String lastName, String username,
            int permissionId, int incorrectLogin) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.permissionId = permissionId;
        this.incorrectLogin = incorrectLogin;
        
        //System.out.println(userId + " " + lastName + " " + username);
    }

    public String login(String tfUsername, String tfPasswd) {

        this.getUserData(tfUsername);
        if (this.username.equals(tfUsername)){
            
            if (this.getPassword().equals(tfPasswd)) {
                this.setIsLoggedIn(true);
                return "Login success";
                
            } else {
                return "Password is incorrect";
            }
        }
        else {
            return "Username doesn't exist";
        }
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
    
    public int getUserId() {
        return this.userId;
    }
    
    public int getPermissionId() {
        return this.permissionId;
    }
    
    public int getIncorrectLogin() {
        return this.incorrectLogin;
    }
    
    public boolean checkOldPassword(String oldPassword, String storedUsername) {
        this.getUserData(storedUsername);
        if(this.getPassword().equals(oldPassword)){
            return true;
        } else {
            return false;
        }
    }
    
    public boolean getLockState(){
        if(this.incorrectLogin >= MAX_INCORRECT_LOGINS)
            return true;
        else
            return false;
    }
    
    public void getUserData(String tfUsername) {
        try {
            String sql = "SELECT *, COUNT(*) as `rows` FROM `user` WHERE `username`='" + tfUsername + "'";
            ResultSet result = db.doQuery(sql);
            if (result.next()) {
                if (result.getInt("rows") >= 1) {
                    this.setUsername(result.getString("username"));
                    this.setUserId(result.getInt("user_id"));
                    this.setFirstName(result.getString("first_name"));
                    this.setLastName(result.getString("last_name"));
                    this.setPermissionId(result.getInt("permission_id"));
                    this.setPassword(result.getString("password"));
                    this.setIncorrectLogin(result.getInt("incorrect_login"));
                }
                else
                    this.setUsername("INVALID");
            }
        } catch (SQLException e) {
            System.out.println(db.SQL_EXCEPTION + e.getMessage());
        }
    }
    
    public List<User> getUserList() {
        List<User> users = new ArrayList<>();
        try {
            String sql = "SELECT * FROM `user`";
            ResultSet result = db.doQuery(sql);
            while (result.next()) {
                users.add(new User(result.getInt("user_id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("username"),
                        result.getInt("permission_id"),
                        result.getInt("incorrect_login")));
            }
        } catch (SQLException e) {
            System.out.println(db.SQL_EXCEPTION + e.getMessage());
        }
        return users;
    }
    
    public void setNewUser(String tfUsername, String tfFirstName, String tfLastName, String tfPassword, int inputPermissionId) {
        String sql = "INSERT INTO `user` (username, first_name, last_name, password, permission_id, incorrect_login) VALUES ('" 
                + tfUsername + "', '" + tfFirstName + "', '" + tfLastName 
                + "', '" + tfPassword + "', " + inputPermissionId + ", 0)";
        db.insertQuery(sql);
    }
    
    public void deleteUser(String tfUsername) {
        String sql = "DELETE FROM `user` WHERE `username` = '" + tfUsername + "'";
        db.insertQuery(sql);
    }
    
    public void changeUserStringData(String inputUsername, String dbField, String newValue) {
        String sql = "UPDATE `user` SET `" + dbField + "` = '" + newValue + "' WHERE `username` = '" + inputUsername + "'";
        db.insertQuery(sql);
    }
    
    public void changeUserIntData(String inputUsername, String dbField, int newValue) {
        String sql = "UPDATE `user` SET `" + dbField + "` = '" + newValue + "' WHERE `username` = '" + inputUsername + "'";
        db.insertQuery(sql);
    }
    
    public void setIncorrectLogin() {
        String sql = "UPDATE `user` SET `incorrect_login` = `incorrect_login` + 1 WHERE `user_id` = '" + this.userId + "'";
        db.insertQuery(sql);
        System.out.println(incorrectLogin + 1);
    }
    
    public void resetIncorrectLogin() {
        String sql = "UPDATE `user` SET `incorrect_login` = 0 WHERE `user_id` = '" + this.userId + "'";
        db.insertQuery(sql);
    }
    
    public void updatePassword(String tfPassword, String tfUsername) {
        String sql = "UPDATE `user` SET `password` = '" + tfPassword + "' WHERE `username`='" + tfUsername + "'";
        db.insertQuery(sql);
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @param permissionId the permissionId to set
     */
    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    /**
     * @param incorrectLogin the incorrectLogin to set
     */
    public void setIncorrectLogin(int incorrectLogin) {
        this.incorrectLogin = incorrectLogin;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the isLoggedIn
     */
    public boolean isIsLoggedIn() {
        return isLoggedIn;
    }

    /**
     * @param isLoggedIn the isLoggedIn to set
     */
    public void setIsLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }
}