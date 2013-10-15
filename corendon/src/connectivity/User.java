package connectivity;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Florentijn Cornet
 */
public class User {

    private final int MAX_INCORRECT_LOGINS = 3;
    
    private DbManager db = new DbManager();
    private int userId;
    private int groupId;
    private int incorrectLogins;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private boolean isLoggedIn = false;

    public User() {
        db.openConnection();
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
    
    public boolean checkOldPassword(String oldPassword, String tfUsername) {
        this.getUserData(tfUsername);
        if(this.password.equals(oldPassword)){
            return true;
        } else {
            return false;
        }
    }
    
    public boolean getLockState(){
        if(this.incorrectLogins >= MAX_INCORRECT_LOGINS)
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
                    this.incorrectLogins = result.getInt("incorrect_login");
                }
                else
                    this.username = "INVALID";
            }
        } catch (SQLException e) {
            System.out.println(db.SQL_EXCEPTION + e.getMessage());
        }
    }
    
    public void setIncorrectLogin() {
        String sql = "UPDATE `user` SET `incorrect_login` = `incorrect_login` + 1 WHERE `user_id` = '" + this.userId + "'";
        db.insertQuery(sql);
        System.out.println(incorrectLogins + 1);
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