package main;

import java.util.ArrayList;
import java.util.List;
import model.User;
import connectivity.QueryManager;

/**
 *
 * @author Team AwesomeSauce
 */
public class Session {

    public static Integer storedUserId;
    public static String storedUsername;
    public static String storedFirstName;
    public static String storedLastName;
    public static String storedCustomerId;
    public static String tempUsername;
    public static String storedLuggageId;
    public static List<Integer> itemsToPrint = new ArrayList<>();

    public static void storeNames(String inputUsername) {
        
        QueryManager query = new QueryManager();

        User user = query.getUserData(inputUsername);
        storedFirstName = user.getFirstName();
        storedLastName = user.getLastName();
        storedUsername = inputUsername;
        storedUserId = user.getUserId();
    }

    public void addToList(int value) {
        itemsToPrint.add(value);
    }

    public void clearPrintList() {
        itemsToPrint.removeAll(itemsToPrint);
    }
}
