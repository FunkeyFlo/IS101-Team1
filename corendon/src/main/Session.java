package main;

import connectivity.User;

/**
 *
 * @author Flo
 */
public class Session {
    
    public static String storedUsername;
    public static String storedFirstName;
    public static String storedLastName;
    
    public static void storeSession(String inputUsername) {
        storedUsername = inputUsername;
        //System.out.println(storedUsername);
    }
    
    public static void storeNames(String inputUsername) {
        User user = new User();
       
        storedFirstName = user.getNames(inputUsername, "first_name");
        storedLastName = user.getNames(inputUsername, "last_name");
        
        System.out.println(storedLastName);
        System.out.println(storedFirstName);
    }
}