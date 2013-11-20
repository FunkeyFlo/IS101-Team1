package main;

import connectivity.User;

/**
 * 
 * @author Team AwesomeSauce
 */
public class Session {
    
    public static String storedUsername;
    public static String storedFirstName;
    public static String storedLastName;
    public static String storedCustomerId;
    public static String tempUsername;
    public static String storedLuggageId;
    
    public static void storeNames(String inputUsername) {
        User user = new User();
       
        user.getUserData(inputUsername);
        storedFirstName = user.getFirstName();
        storedLastName = user.getLastName();
        storedUsername = user.getUsername();
    }
}