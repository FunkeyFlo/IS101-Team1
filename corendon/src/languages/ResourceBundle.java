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
            { "allFields", "All fields" },
            { "cancel", "Cancel" },
            { "create", "Create" },
            { "employee", "Employee" },
            { "exit", "Exit" },
            { "fillInAllFields", "Please fill in all fields and try again."},
            { "firstName", "First name" },
            { "lastName", "Last name" },
            { "login" , "Login" },
            { "manager", "Manager" },
            { "selectItemInTable", "Please select an item from the table and try again." },
            { "options", "Options" },
            { "ok", "Ok" },
            { "password", "Password" },
            { "reset", "Reset" },
            { "search", "Search" },
            { "userId", "User Id" },
            { "username", "Username" },
        
        // Toolbar
            { "changePassword", "Change Password" },
            { "logout", "Logout" },
            
        // Login.java
            { "accountHasBeenLocked", "This account has been locked. \n"
                + "Please contact your administrator." },
            { "passwordIncorrect", "Password is incorrect." },
            { "usernameIncorrect", "Username does not exist." },
            
        // ChangeMyPassword.java
            { "changeMyPassword", "Change Password" },
            { "currentPasswordIncorrect", "Current password is incorrect." },
            { "newPasswordNoMatch", "New password fields do not match." },
            { "typeCurrentPassword", "Enter current password" },
            { "typeNewPassword", "Enter new password" },
            { "typeRepeatPassword", "Repeat new password" },
            
        // Administrator.java
            { "accountState", "Account state" },
            { "accountIsUnlocked",
                "The account has successfully been unlocked." },
            { "accountIsLocked",
                "The account has successfully been locked." },
            { "active", "Active" },
            { "createUserPrompt", 
                "Are you sure you want to create this user account?" },
            { "deleteUserPrompt", 
                "Are you sure you want to delete this user account?" },
            { "deleteUser", "Delete user" },
            { "editInfo", "Edit user information" },
            { "lockAccount", "Lock account" },
            { "locked", "Locked" },
            { "resetPassword", "Reset password" },
            { "unlockAccount", "Unlock account" },
            { "userGroup", "User group" },
            { "usernameInUse", "Username is already in use." },
            { "userOptions", "User options" },
            { "userOverview", "User overview" },
            { "createUser", "Create user" },
    };
}