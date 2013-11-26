package main;

import connectivity.Luggage;
import connectivity.User;
import java.util.ArrayList;
import java.util.List;

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
    public static List<Integer> itemsToPrint = new ArrayList<>();
    
    public static void storeNames(String inputUsername) {
        User user = new User();
       
        user.getUserData(inputUsername);
        storedFirstName = user.getFirstName();
        storedLastName = user.getLastName();
        storedUsername = user.getUsername();
    }
    
    public void addToList(int value) {
        itemsToPrint.add(value);
    }
}