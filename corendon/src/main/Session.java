package main;

/**
 *
 * @author Flo
 */
public class Session {
    
    public static String storedUsername;
    
    public static void storeSession(String inputUsername) {
        storedUsername = inputUsername;
        //System.out.println(storedUsername);
    }
}
