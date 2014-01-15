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
            { "add", "Toevoegen"},
            { "address", "Adres" },
            { "adjust", "Aanpassen" },
            { "allFields", "Alle velden" },
            { "apply", "Toepassen" },
            { "cancel", "Annuleren" },
            { "city", "Plaats" },
            { "country", "Land" },
            { "create", "Aanmaken" },
            { "customerId", "Klant nummer" },
            { "description", "Omschrijving" },
            { "email", "Email" },
            { "employee", "Medewerker" },
            { "exit", "Afsluiten" },
            { "fillInAllFields", "Vul alle velden in en probeer het nogmaals."},
            { "firstName", "Voornaam" },
            { "found", "Gevonden" },
            { "handled", "Afgehandeld" },
            { "lastChangedBy", "Laatst gewijzigd door " },
            { "lastName", "Achternaam" },
            { "linkCustomer", "Klanten koppelen" },
            { "location", "Locatie" },
            { "login" , "Inloggen" },
            { "lost", "Verloren" },
            { "luggage", "Bagage" },
            { "manager", "Manager" },
            { "name", "Naam" },
            { "ok", "Ok" },
            { "on", "op" },
            { "options", "Opties" },
            { "overviews", "Overzichten" },
            { "password", "Wachtwoord" },
            { "phoneHome", "Tel. thuis" },
            { "phoneNumber", "Telefoonnummer" },
            { "phoneMobile", "Tel. mobiel" },
            { "postalCode", "Postcode" },
            { "reset", "Reset" },
            { "resetOverview", "Overzicht verversen" },
            { "resort", "Verblijf" },
            { "resortTab", "Verblijfs overzicht en registratie" },
            { "search", "Zoeken" },
            { "selectItemInTable", "Selecteer een onderdeel uit de tabel en probeer het nogmaals." },
            { "status", "Status" },
            { "unlockFields", "Velden ontgrendelen" },
            { "userId", "Gebruikers ID" },
            { "username", "Gebruikersnaam" },
            { "update", "Update" },
            
        // StringArrays
            { "customerSearchFields", new String[] { "Alle velden", "Klant nummer", 
                "Voornaam", "Achternaam", "Adres", "Postcode", "Stad", "Land",
                "Email", "Tel. thuis", "Tel. mobiel"} },
            
            { "customerSearchFieldsMin", new String[] { "Alle velden", "Klant nummer", 
                "Voornaam", "Achternaam", "Adres", "Postcode", "Stad", "Land",
                "Email"} },
            
            { "customerTableFields", new String[] { "Klant nummer", "Voornaam",
                "Achternaam", "Adres", "Postcode", "Stad", "Land",
                "Email", "Tel. Thuis", "Tel. Mobiel"} },
            
            { "customerTableFieldsMin", new String[] { "Klant nummer", "Voornaam",
                "Achternaam", "Adres", "Postcode", "Stad", "Land",
                "Email"} },
            
            { "luggageSearchFields", new String [] { "Alle velden", "Bagage nummer",
                "Klant nummer", "Omschrijving", "Locatie", "Datum verloren" } },
            
            { "luggageTableFields", new String[] { "Bagage nummer", "Klant nummer",
                "Omschrijving", "Locatie", "Datum verloren", "Status" } },
            
            { "months", new String[] { "Januari", "Februari", "Maart", "April",
                "Mei", "Juni", "Juli", "Augustus", "September", "October",
                "November", "December" } },
            
            { "statuses", new String[] { "Verloren", "Gevonden", "Afgehandeld" } },
            
            { "userSearchFields", new String[] { "Alle velden", "Gebruikers ID", "Voornaam",
                "Achternaam", "Gebruikersnaam" } },
            
            { "userTableFields", new String[] { "Gebruikersnaam", "Voornaam",
                "Achternaam", "Gebruikersgroep", "Account Status" } },
            
            { "userTypes", new String[] { "Medewerker", "Manager", "Beheerder" } },
            
            { "countriesComboBox", new String[] { "Nederland", "Turkije", "Australië" } },
            
            { "resortTableTitles", new String[] { "Resort ID", "Resort naam",
                "Adres", "Land", "Stad", "Telefoon", "Email", "Postcode"} },
            
            { "resortTableAllFieldsLink", new String [] { "Alle velden", "Naam",
                "Adres", "Land", "Stad", "Telefoon", "Email", "Postcode" } },
            
            { "resortTableAllFields", new String[] { "Resort ID", "Resort naam",
                "Adres", "Land", "Stad", "Telefoon", "Email", "Postcode"} },
        
        // Toolbar
            { "changePassword", "Wachtwoord wijzigen" },
            { "logout", "Uitloggen" },
            
        // Login.java
            { "accountHasBeenLocked", "Dit account is vergrendeld. \n"
                + "Neem contact op met uw beheerder." },
            { "loginIncorrect", "Gebruikersnaam/Wachtwoord is incorrect." },
            
            //ResetPassword
            {"changePasswordForUser","Wachtwoord aanpassen voor gebruiker: "},                       
            
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
            { "administrator", "Beheerder" },
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
            //Month abbreviations
            { "Jan", "Jan" },
            { "Feb", "Feb" },
            { "Mar", "Maa" },
            { "Apr", "Apr" },
            { "May", "Mei" },
            { "Jun", "Jun" },
            { "Jul", "Jul" },
            { "Aug", "Aug" },
            { "Sep", "Sep" },
            { "Oct", "Okt" },
            { "Nov", "Nov" },
            { "Dec", "Dec" },
            
        // Employee.java
            { "hideHandled", "Afgehandelde bagage verbergen" },
            { "unassigned", "Nog niet toegewezen"},
            { "found", "Gevonden"},
            { "lost", "Vermist"},
            { "handled", "Afgehandeld"},
            { "registerCustomer", "Registreren klant"},
            { "customer", "Klant"},
            { "extensiveCustomerData", "Uitgebreide klantgegevens" },
            { "deleteCustomer", "Delete customer" },
            { "summaryCustomerRegister", "Klantenoverzicht en registratie" },
            { "registerLuggage", "Baggage registreren"},
            { "modifyLuggage", "Baggage aanpassen"},
            { "proofPrint", "Bewijs voor klant printen"},
            { "deleteLuggage", "Baggage verwijderen"},
            { "summaryLuggageRegister", "Baggage overzicht en registratie"},
            { "summary", "Overzicht"},
            { "connect", "Koppelen"},
            { "newResort", "Nieuw resort"},
            { "updateResort", "Resort aanpassen"},
            { "deleteResort", "Resort verwijderen"},
            { "createResort", "Resort aanmaken"},
            { "summaryResort", "Resort overzicht"},
            
            
        // ExtendedCustomer.java
            { "changeCustomerInfo", "Klant gegevens wijzigen" },
            { "clearList", "Alle onderdelen uit lijst verwijdern" },
            { "deleteFromList", "Geselecteerde onderdeel verwijderen" },
            { "itemsToPrint", "Lijst van onderdelen die geprint zullen worden" },
            { "printTicket", "Ophaalbewijs printen" },
            { "resortInfo", "Verblijfsgegevens" },
    };
}