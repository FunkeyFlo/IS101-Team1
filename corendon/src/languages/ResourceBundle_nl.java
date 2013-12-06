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
        
        // Universally used strings
            { "administrator", "Beheerder" },
            { "create", "Aanmaken" },
            { "employee", "Medewerker" },
            { "exit", "Afsluiten" },
            { "firstName", "Voornaam"},
            { "lastName", "Achternaam"},
            { "login" , "Inloggen" },
            { "manager", "Manager" },
            { "password", "Wachtwoord"},
            { "reset", "Reset" },
            { "username", "Gebruikersnaam"},
        
        // Login.java
            { "accountHasBeenLocked", "Dit account is vergrendeld. \n"
                + "Neem contact op met uw beheerder."},
            { "passwordIncorrect", "Wachtwoord is onjuist."},
            { "usernameIncorrect", "Gebruikersnaam is onjuist."},
            
        // ChangeMyPassword.java
            { "changeMyPassword", "Wachtwoord veranderen" },
            { "typeCurrentPassword", "Typ het huidige wachtwoord" },
            { "typeNewPassword", "Typ nieuw wachtwoord" },
            { "typeRepeatPassword", "Herhaal nieuw wachtwoord" },
            
        // Administrator.java
            { "accountState", "Account status"},
            { "active", "Actief" },
            { "deleteUser", "Verwijder gebruiker" },
            { "editInfo", "Gebruikersinformatie wijzigen" },
            { "lockAccount", "Account vergrendelen" },
            { "locked", "Vergrendeld" },
            { "resetPassword", "Wachtwoord resetten" },
            { "unlockAccount", "Account ontgrendelen" },
            { "userGroup", "Gebruikersgroep"},
    };
}