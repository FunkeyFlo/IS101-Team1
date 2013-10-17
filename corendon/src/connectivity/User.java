package connectivity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Florentijn Cornet
 */
public class User {

    private final int MAX_INCORRECT_LOGINS = 3;
    
    private DbManager db = new DbManager();
    
    private int userId;
    private int groupId;
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
            int groupId, int incorrectLogin) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.groupId = groupId;
        this.incorrectLogin = incorrectLogin;
        
        //System.out.println(userId + " " + lastName + " " + username);
    }

    public String login(String tfUsername, String tfPasswd) {

        this.getUserData(tfUsername);
        if (this.username.equals(tfUsername)){
            
            if (this.password.equals(tfPasswd)) {
                this.isLoggedIn = true;
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
    
    public int getGroupId() {
        return this.groupId;
    }
    
    public int getIncorrectLogin() {
        return this.incorrectLogin;
    }
    
    public boolean checkOldPassword(String oldPassword, String storedUsername) {
        this.getUserData(storedUsername);
        if(this.password.equals(oldPassword)){
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
    
    public int detectGroup(){
        return this.groupId;
    }
    
    public void getUserData(String tfUsername) {
        try {
            String sql = "SELECT *, COUNT(*) as `rows` FROM `user` WHERE `username`='" + tfUsername + "'";
            ResultSet result = db.doQuery(sql);
            if (result.next()) {
                if (result.getInt("rows") >= 1) {
                    this.username = result.getString("username");
                    this.userId = result.getInt("user_id");
                    this.firstName = result.getString("first_name");
                    this.lastName = result.getString("last_name");
                    this.groupId = result.getInt("group_id");
                    this.password = result.getString("password");
                    this.incorrectLogin = result.getInt("incorrect_login");
                }
                else
                    this.username = "INVALID";
            }
        } catch (SQLException e) {
            System.out.println(db.SQL_EXCEPTION + e.getMessage());
        }
    }
    
    public List<User> getUserList() {
        List<User> users = new ArrayList<>();
        try {
            String sql = "SELECT * FROM user";
            ResultSet result = db.doQuery(sql);
            while (result.next()) {
                users.add(new User(result.getInt("user_id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("username"),
                        result.getInt("group_id"),
                        result.getInt("incorrect_login")));
            }
        } catch (SQLException e) {
            System.out.println(db.SQL_EXCEPTION + e.getMessage());
        }
        return users;
    }
    
    public void setNewUser(String tfUsername, String tfFirstName, String tfLastName, String tfPassword, int inputGroupId) {
        String sql = "INSERT INTO fys.`user` (username, first_name, last_name, password, group_id, incorrect_login) VALUES ('" 
                + tfUsername + "', '" + tfFirstName + "', '" + tfLastName 
                + "', '" + tfPassword + "', " + inputGroupId + ", 0)";
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
        String sql = "UPDATE `user` SET password = '" + tfPassword + "' WHERE `username`='" + tfUsername + "'";
        db.insertQuery(sql);
    }
}