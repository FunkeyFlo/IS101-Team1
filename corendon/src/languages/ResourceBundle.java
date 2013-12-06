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
        
        // login.java
            { "login" , "Login" },
            { "exit", "Exit" },
            { "username", "Username"},
            { "password", "Password"},
            { "passwordIncorrect", "Password is incorrect."},
            { "usernameIncorrect", "Username does not exist."},
            { "accountHasBeenLocked", "This account has been locked. \n"
                + "Please contact your administrator."},
        //changeMyPassword
            { "typeCurrentPassword", "Enter current password" },
            { "typeNewPassword", "Enter new password" },
            { "typeRepeatPassword", "Repeat new password" }
    };
}