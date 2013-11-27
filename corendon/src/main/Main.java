/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import view.employee.*;
import view.manager.Manager;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import view.*;
import view.administrator.*;

/**
 *
 * @author Team AwesomeSauce
 */
public class Main {

    private JFrame frameLogin;
    public static Session session;

    private Main() {
    }

    public static void displayLogin() {
        Login frameLogin = new Login();
        frameLogin.setVisible(true);
    }

    public static void displayEmployee() { // permissionId = 1
        Employee frameEmployee = new Employee();
        frameEmployee.setVisible(true);
    }

    public static void displayManager() { // permissionId = 2
        Manager frameManager = new Manager();
        frameManager.setVisible(true);
    }

    public static void displayBeheerder() { // permissionId = 3
        Administrator frameBeheerder = new Administrator();
        frameBeheerder.setVisible(true);
    }

    public static void displayChangeMyPassword() {
        ChangeMyPassword frameChangeMyPassword = new ChangeMyPassword();
        frameChangeMyPassword.setVisible(true);
    }

    public static void displayChangeName() {
        ChangeName frameChangeName = new ChangeName();
        frameChangeName.setVisible(true);
    }

    public static void displayChangePassword() {
        ChangePassword frameChangePassword = new ChangePassword();
        frameChangePassword.setVisible(true);
    }

    public static void displayChangePermission() {
        ChangePermission frameChangePermission = new ChangePermission();
        frameChangePermission.setVisible(true);
    }
    
    public static void displayExtendedCustomer() {
        ExtendedCustomer frameExtendedCustomer = new ExtendedCustomer();
        frameExtendedCustomer.setVisible(true);
    }
    
    public static void displayChangeLuggage() {
        ChangeLuggage frameChangeLuggage = new ChangeLuggage();
        frameChangeLuggage.setVisible(true);
    }
    
    public static void displayChangeUser() {
        ChangeUser frameChangeUser = new ChangeUser();
        frameChangeUser.setVisible(true);
    }
    public static void displaySaveDocument(){
        SaveDocument frameSaveDocument = new SaveDocument();
        frameSaveDocument.setVisible(true);
    }
    
    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                displayLogin();
                Session session = new Session();

            }
        });
    }
}