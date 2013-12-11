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
            { "adjust", "Aanpassen" }, 
            { "allFields", "Alle velden" },
            { "cancel", "Annuleren" },
            { "create", "Aanmaken" },
            { "customerId", "Klant nummer" },
            { "description", "Omschrijving" },
            { "employee", "Medewerker" },
            { "exit", "Afsluiten" },
            { "fillInAllFields", "Vul alle velden in en probeer het nogmaals."},
            { "firstName", "Voornaam" },
            { "found", "Gevonden" },
            { "handled", "Afgehandeld" },
            { "lastChangedBy", "Laatst gewijzigd door " },
            { "lastName", "Achternaam" },
            { "location", "Locatie" },
            { "login" , "Inloggen" },
            { "lost", "Verloren" },
            { "manager", "Manager" },
            { "ok", "Ok" },
            { "on", "op" },
            { "options", "Opties" },
            { "password", "Wachtwoord" },
            { "reset", "Reset" },
            { "resetOverview", "Tabel Resetten" },
            { "search", "Zoeken" },
            { "selectItemInTable", "Selecteer een onderdeel uit de tabel en probeer het nogmaals." },
            { "status", "Status" },
            { "unlockFields", "Velden ontgrendelen" },
            { "userId", "Gebruikers ID" },
            { "username", "Gebruikersnaam" },
            { "update", "Update" },
            
        // StringArrays
            { "luggageFields", new String [] { "Alle velden", "Bagage nummer",
                "Klant nummer", "Omschrijving", "Locatie", "Datum verloren" } },
            { "customerFields", new String[] { "Alle velden", "Klant nummer", 
                "Voornaam", "Achternaam", "Adres", "Postcode", "Stad", "Land",
                "Email", "Tel. thuis", "Tel. mobiel"} },
            { "months", new String[] { "Januari", "Februari", "Maart", "April",
                "Mei", "Juni", "Juli", "Augustus", "September", "October",
                "November", "December" } },
            { "statuses", new String[] { "Verloren", "Gevonden", "Afgehandeld" } },
            { "userFields", new String[] { "Alle velden", "Gebruikers ID", "Voornaam",
                "Achternaam", "Gebruikersnaam" } },
            { "userTypes", new String[] { "Medewerker", "Manager", "Beheerder" } },
        
        // Toolbar
            { "changePassword", "Wachtwoord wijzigen" },
            { "logout", "Uitloggen" },
            
        // Login.java
            { "accountHasBeenLocked", "Dit account is vergrendeld. \n"
                + "Neem contact op met uw beheerder." },
            { "passwordIncorrect", "Wachtwoord is onjuist." },
            { "usernameIncorrect", "Gebruikersnaam is onjuist." },
            
        // ChangeMyPassword.java
            { "changeMyPassword", "Wachtwoord veranderen" },
            { "currentPasswordIncorrect", "Het huidige wachtwoord is onjuist." },
            { "newPasswordNoMatch", "Ingevoerde nieuwe wachtwoord velden komen niet overeen." },
            { "typeCurrentPassword", "Typ het huidige wachtwoord" },
            { "typeNewPassword", "Typ nieuw wachtwoord" },
            { "typeRepeatPassword", "Herhaal nieuw wachtwoord" },
            
        // Administrator.java
            { "accountState", "Account status" },
            { "accountIsUnlocked",
                "Het gebruikersaccount is succesvol ontgrendeld." },
            { "accountIsLocked",
                "Het gebruikersaccount is succesvol vergrendeld." },
            { "active", "Actief" },
            { "createUserPrompt", 
                "Weet u zeker dat u deze gebruiker wilt aanmaken?" },
            { "deleteUserPrompt", 
                "Weet u zeker dat u deze gebruiker wilt verwijderen?" },
            { "deleteUser", "Verwijder gebruiker" },
            { "editInfo", "Gebruikersinformatie wijzigen" },
            { "lockAccount", "Account vergrendelen" },
            { "locked", "Vergrendeld" },
            { "resetPassword", "Wachtwoord resetten" },
            { "unlockAccount", "Account ontgrendelen" },
            { "userGroup", "Gebruikersgroep"},
            { "usernameInUse", "Gebruikersnaam is al in gebruik." },
            { "userOptions", "Opties voor gebruikers" },
            { "userOverview", "Gebruikers overzicht" },
            { "createUser", "Gebruiker aanmaken" },
            
        // Manager.java
            { "allData", "Alle Data" },
            { "allStatusLuggage", "Vermiste, gevonden en afgehandelde bagage per maand" },
            { "beginDate", "Begindatum kan niet groter zijn dan einddatum." },
            { "foundLuggage", "Gevonden Bagage" },
            { "from", "Van" },
            { "handledLuggage", "Afgehandelde Bagage" },   
            { "missingLuggage", "Vermiste Bagage" },
            { "month", "Maand" },
            { "options", "Opties" },
            { "otherOptions", "Overige Opties" },
            { "seeAllData1", "Zie alle data, zelfs als de status van de" },
            { "seeAllData2", "baggage niet meer van toepassing is." },
            { "to", "Tot" },
            { "xAxis", "Maand/Jaar" },
            { "yAxis", "Aantal" },
            { "year", "Jaar" },
            
        // Employee.java
            { "hideHandled", "Afgehandelde bagage verbergen" },
    };
}