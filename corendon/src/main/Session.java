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
    public static int storedUserId;
    
    public static void storeNames(String inputUsername) {
        User user = new User();
       
        user.getUserData(inputUsername);
        storedFirstName = user.getFirstName();
        storedLastName = user.getLastName();
        storedUserId = user.getUserId();
    }
}