package model;

/**
 *
 * @author Niels Reijn
 */
public class User {

    // Variable Declaration.
    private int permissionId, incorrectLogin, userId;
    private String username, firstName, lastName, password;
    private boolean isLoggedIn = false;

    // Variable that sets the maximum ammount of incorrect login attempts
    public final int MAX_INCORRECT_LOGINS = 3;
    private final int STANDARD_INCORRECT_LOGINS = 0;

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

    public User() {

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

}
