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
public class ResourceBundle extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return contents;
    }

    private Object[][] contents = {
            { "login" , "Login" },
            { "exit", "Exit" },
            { "username", "Username"},
            { "password", "Password"},
    };
}