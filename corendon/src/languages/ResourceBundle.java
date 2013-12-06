/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package languages;

import java.util.ListResourceBundle;

/**
 *
 * @author Flo
 */
public class ResourceBundle extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return contents;
    }

    private Object[][] contents = {
        
        // Universally used strings
            { "administrator", "Administrator" },
            { "create", "Create" },
            { "employee", "Employee" },
            { "exit", "Exit" },
            { "firstName", "First name"},
            { "lastName", "Last name"},
            { "login" , "Login" },
            { "manager", "Manager" },
            { "password", "Password"},
            { "reset", "Reset" },
            { "username", "Username"},
        
        // Login.java
            { "accountHasBeenLocked", "This account has been locked. \n"
                + "Please contact your administrator."},
            { "passwordIncorrect", "Password is incorrect."},
            { "usernameIncorrect", "Username does not exist."},
            
        // ChangeMyPassword.java
            { "changeMyPassword", "Change Password" },
            { "typeCurrentPassword", "Enter current password" },
            { "typeNewPassword", "Enter new password" },
            { "typeRepeatPassword", "Repeat new password" },
            
        // Administrator.java
            { "accountState", "Account state"},
            { "active", "Active" },
            { "deleteUser", "Delete user" },
            { "editInfo", "Edit user information" },
            { "lockAccount", "Lock account" },
            { "locked", "Locked" },
            { "resetPassword", "Reset password" },
            { "unlockAccount", "Unlock account" },
            { "userGroup", "User group"},
    };
}