/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import view.administrator.Administrator;
import view.administrator.ChangeName;
import view.employee.RegisterCustomer;
import view.employee.Employee;
import view.employee.Medewerker;
import view.manager.Manager;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import view.*;
import view.administrator.AccountLockedPopup;
import view.administrator.AccountUnlockPopup;
import view.administrator.ChangePassword;
import view.administrator.ChangePermission;
import view.administrator.UserDeletionPopup;
import view.administrator.UserSuccesPopup;

/**
 *
 * @author Florentijn Cornet
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

    public static void displayMedewerker() { //permissionId = 1
        Medewerker frameMedewerker = new Medewerker();
        frameMedewerker.setVisible(true);
    }

    public static void displayEmployee() { //permissionId = 1
        Employee frameEmployee = new Employee();
        frameEmployee.setVisible(true);
    }

    public static void displayManager() { //permissionId = 2
        Manager frameManager = new Manager();
        frameManager.setVisible(true);
    }

    public static void displayBeheerder() { //permissionId = 3
        Administrator frameBeheerder = new Administrator();
        frameBeheerder.setVisible(true);
    }

    public static void displayLinkLuggage() {
        //LinkLuggagePopUp frameLinkLuggage = new LinkLuggagePopUp();
        //frameLinkLuggage.setVisible(true);
    }

    public static void displayRegisterCustomer() {
        RegisterCustomer frameRegisterCustomer = new RegisterCustomer();
        frameRegisterCustomer.setVisible(true);
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

    public static void displayUserSuccesPopup() {
        UserSuccesPopup frameUserSuccesPopup = new UserSuccesPopup();
        frameUserSuccesPopup.setVisible(true);
    }

    public static void displayUserDeletionPopup() {
        UserDeletionPopup frameUserDeletionPopup = new UserDeletionPopup();
        frameUserDeletionPopup.setVisible(true);
    }

    public static void displayAccountLockedPopup() {
        AccountLockedPopup frameAccountLockedPopup = new AccountLockedPopup();
        frameAccountLockedPopup.setVisible(true);
    }
    
    public static void displayAccountUnlockedPopup() {
        AccountUnlockPopup frameAccountUnlockPopup = new AccountUnlockPopup();
        frameAccountUnlockPopup.setVisible(true);
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
