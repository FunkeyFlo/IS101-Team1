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
    public boolean isLoggedIn = false;

    public User() {
        db.openConnection();
    }

    public String login(String pUsername, String pPasswd) {

        this.setData(pUsername);
        if (this.username.equals(pUsername))
            if (this.password.equals(pPasswd)) {
                this.isLoggedIn = true;
                return "Login succes";
            } else {
                return "Password is incorrect";
            }
        else {
            return "Username doesn't exist";
        }
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
                }
                else
                    this.username = "INVALID";
            }
        } catch (SQLException e) {
            System.out.println(db.SQL_EXCEPTION + e.getMessage());
        }
    }
}