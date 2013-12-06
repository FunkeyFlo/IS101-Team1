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
public class ResourceBundle_nl extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return contents;
    }

    private Object[][] contents = {
        
        // login.java
            { "login" , "Inloggen" },
            { "exit", "Afsluiten" },
            { "username", "Gebruikersnaam"},
            { "password", "Wachtwoord"},
            { "passwordIncorrect", "Wachtwoord is onjuist."},
            { "usernameIncorrect", "Gebruikersnaam bestaat niet."},
            { "accountHasBeenLocked", "Dit account is vergrendeld. \n"
                + "Neem contact op met uw administrator."},
    };
}