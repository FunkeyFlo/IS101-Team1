package connectivity;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Florentijn Cornet
 */
public class User {

    private DbManager db = new DbManager();
    private int userId;
    private String username;
    private int groupId;
    private String firstName;
    private String lastName;
    private String password;
    private boolean locked;
    private boolean isLoggedIn = false;

    public User() {
        db.openConnection();
    }

    public String login(String tfUsername, String tfPasswd) {

        this.setData(tfUsername);
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
    
    public boolean getLockState(){
        return this.locked;
    }
    
    public int detectGroup(){
        return this.groupId;
    }

    public void setData(String tfUsername) {
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
                    this.locked = result.getBoolean("locked");
                }
                else
                    this.username = "INVALID";
            }
        } catch (SQLException e) {
            System.out.println(db.SQL_EXCEPTION + e.getMessage());
        }
    }
}